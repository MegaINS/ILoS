package ru.megains.ilos.db.daoquill

import ru.megains.ilos.GameClass
import ru.megains.ilos.db.dao.LocationDao
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._
import ru.megains.ilos.world.location._
import ru.megains.ilos.world.location.shop.LocationShop
class LocationDaoQuill() extends LocationDao {

    implicit val locationSchemaMeta: ctx.SchemaMeta[LocationDto] = schemaMeta[LocationDto]("location",_.locationType ->"type")
    implicit val locationOpenSchemaMeta: ctx.SchemaMeta[LocationOpenDto] = schemaMeta[LocationOpenDto]("location_open")
    implicit val locationHabSchemaMeta: ctx.SchemaMeta[LocationHabDto] = schemaMeta[LocationHabDto]("location_hab")
    implicit val locationMineSchemaMeta: ctx.SchemaMeta[LocationMineDto] = schemaMeta[LocationMineDto]("location_mine")
    implicit val locationShopSchemaMeta: ctx.SchemaMeta[LocationShopDto] = schemaMeta[LocationShopDto]("location_shop")
    case class LocationDto(id:Int,name:String,locationType:String,width:Int,height:Int)

    case class LocationOpenDto(locationId:Int,src:String)
    case class LocationHabDto(locationId:Int,area:String)
    case class LocationMineDto(locationId:Int,`class`:String,level:Int,`type`:String)
    case class LocationShopDto(locationId:Int,shopId:Int)




    override def getById(id: Int): Option[Location] = {

        val locationDtoOpt = run(quote{query[LocationDto].filter(_.id == lift(id))})
        var loc:Option[(LocationDto, Any)] = null
            locationDtoOpt.headOption match {
            case Some(locationDto) =>
                LocationType.withName(locationDto.locationType) match {
                    case LocationType.OPEN =>
                        loc = run(quote{query[LocationDto].join(query[LocationOpenDto]).on(_.id == _.locationId).filter(_._1.id == lift(id) )}).headOption
                    case LocationType.HAB =>
                        loc = run(quote{query[LocationDto].join(query[LocationHabDto]).on(_.id == _.locationId).filter(_._1.id == lift(id))}).headOption
                    case LocationType.MINE =>
                        loc = run(quote{query[LocationDto].join(query[LocationMineDto]).on(_.id == _.locationId).filter(_._1.id == lift(id) )}).headOption
                    case LocationType.SHOP =>
                        loc = run(quote{query[LocationDto].join(query[LocationShopDto]).on(_.id == _.locationId).filter(_._1.id == lift(id) )}).headOption
                }
            case None =>
        }

        loc match {
            case Some((loc,data)) => data match {
                case open:LocationOpenDto => Some(new LocationOpen(loc.id,loc.name,open.src,loc.width,loc.height))
                case hab:LocationHabDto =>Some(new LocationHab(loc.id,loc.name,hab.area,loc.width,loc.height))
                case mine:LocationMineDto =>Some(new LocationMine(loc.id,loc.name,GameClass.withName(mine.`class`) ,mine.level,MineType.withName(mine.`type`) ,loc.width,loc.height))
                case shop:LocationShopDto =>Some(new LocationShop(loc.id,loc.name,shop.shopId,loc.width,loc.height))
                case _ => None
            }
            case None => None
        }
    }
}
