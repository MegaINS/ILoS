package ru.megains.ilos.db.daoquill

import ru.megains.ilos.db.dao.ResGenDao
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._
import ru.megains.ilos.world.location.ResGen

class ResGenDaoQuill extends ResGenDao{

    case class ResourceLocation(locationId:Int,resourceId:Int)
    implicit val resSchemaMeta: ctx.SchemaMeta[ResGen] = schemaMeta[ResGen]("resource")

    override def getById(id: Int): Option[ResGen] = {
        run(quote{query[ResGen].filter(_.id==lift(id))}).headOption
    }

    override def getListIdByLocId(id: Int): List[Int] = {
        run(quote{query[ResourceLocation].filter(_.locationId==lift(id))}).map(_.resourceId)
    }
}
