package ru.megains.ilos.database

import anorm.SqlParser.get
import anorm.{RowParser, ~}
import ru.megains.ilos.GameClass
import ru.megains.ilos.item.{Item, ItemStack}
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.location._
import ru.megains.ilos.world.location.shop.{Group, LocationShop, Type}
import ru.megains.ilos.world.warp.Warp

object Parsers {


    val player : RowParser[Player] = {
        get[Int]("id")~
        get[String]("name")~
        get[Int]("level")~
        get[Int]("location")~
        get[Int]("pos_x")~
        get[Int]("pos_y")~
                get[Int]("health")~
                get[Int]("healthMax")~
                get[Int]("energy")~
                get[Int]("energyMax")~
                get[Int]("fightMinDamage")~
                get[Int]("fightMaxDamage")~
                get[Int]("workMinDamage")~
                get[Int]("workMaxDamage")~
                get[Int]("power")~
                get[Int]("intellect")~
                get[Int]("concentration")~
                get[Int]("stamina")~
        get[Float]("money")map{
            case id~name~level~location~posX~posY~health~healthMax~energy~energyMax~fightMinDamage~fightMaxDamage~workMinDamage~workMaxDamage~power~intellect~concentration~stamina~money =>{
                val player =  new Player(id,name)
                player.posX = posX
                player.posY = posY
                player.money = money
                player.level = level
                player.location =  Locations.getLocation(location)
                player.health = health
                player.healthMax = healthMax
                player.energy =energy
                player.energyMax = energyMax
                player.fightMinDamage = fightMinDamage
                player.fightMaxDamage = fightMaxDamage
                player.workMinDamage = workMinDamage
                player.workMaxDamage = workMaxDamage
                player.power = power
                player.intellect = intellect
                player.concentration = concentration
                player.stamina = stamina
                player
            }
        }
    }


    val shopGroup : RowParser[Group] = {
        get[Int]("id")~
                get[String]("name")~
                get[String]("src")map{
            case id~name~src => new Group(id,name,src)
        }
    }

    val groupType: RowParser[Type] = {
        get[Int]("id")~
                get[String]("name")~
                get[String]("src")map{
            case id~name~src => new Type(id,name,src)
        }
    }

    val shopItem: RowParser[ItemStack]  = {
        get[Int]("id")~
                get[Int]("itemid")~
                get[Int]("amount")map{
            case id~itemId~amount => new ItemStack(id,itemId,amount)
        }
    }


    val resourceId: RowParser[Int] = {
        get[Int]("resourceid")
    }

    val resource: RowParser[ResGen]  = {
        get[Int]("itemid")~
                get[Int]("min")~
                get[Int]("max")~
                get[Float]("chance") map{
            case itemid~min~max~chance => new ResGen(itemid,min,max,chance)
        }
    }


    val item: RowParser[Item] = {
        get[Int]("id") ~
                get[String]("name") ~
                get[String]("src") ~
                get[Int]("level") ~
                get[Int]("weight")map{
            case id~name~src~level~weight => new Item(id,name,level,weight,src)
        }
    }


    val location : RowParser[(Int,LocationType)] = {
        get[Int]("id") ~
                get[String]("type")map{
            case id~typeName =>(id,LocationType.withName(typeName) )
        }
    }
    val locationOpen: RowParser[LocationOpen] = {
        get[Int]("id") ~
                get[String]("name")~
                get[String]("src")~
                get[Int]("width")~
                get[Int]("height")map{
            case id~name~src~width~height =>new LocationOpen(id,name,src,width,height)
        }
    }
    val locationHab: RowParser[LocationHab] = {
        get[Int]("id") ~
                get[String]("name")~
                get[String]("area")~
                get[Int]("width")~
                get[Int]("height")map{
            case id~name~area~width~height =>new LocationHab(id,name,area,width,height)
        }
    }

    val locationMine: RowParser[LocationMine] = {
        get[Int]("id") ~
                get[String]("name")~
                get[String]("class")~
                get[Int]("level")~
                get[String]("type")~
                get[Int]("width")~
                get[Int]("height")map{
            case id~name~gameClass~level~mineType~width~height =>new LocationMine(id,name,GameClass.withName(gameClass),level,MineType.withName(mineType),width,height)
        }
    }

    val locationShop: RowParser[LocationShop] = {
        get[Int]("id") ~
                get[Int]("shopid") ~
                get[String]("name")~
                get[Int]("width")~
                get[Int]("height")map{
            case id~shopId~name~width~height =>new LocationShop(id,shopId,name,width,height)
        }
    }

    val warp: RowParser[Warp] = {
        get[Int]("id") ~
                get[String]("name")~
                get[Int]("locId")~
                get[Int]("x")~
                get[Int]("y")~
                get[Int]("outId")map{
            case id~name~locId~x~y~outId => Warp(id,name,locId,x,y,outId)
        }
    }
    //    var loc_object : RowParser[(Int,String,String,Int)] = {
//
//                get[Int]("loc_id") ~
//                get[String]("name") ~
//                get[String]("object_type") ~
//                get[Int]("object_id") map{
//            case locId~name~objectType~objectId =>(locId,name,objectType,objectId)
//        }
//    }
//    val playerInfo: RowParser[(Int,Int)] = {
//        get[Int]("id") ~
//        get[Int]("location") map{
//            case id~loc =>(id,loc)
//        }
//    }
//
//    val location: RowParser[Location] = {
//        get[Int]("id") ~
//                get[String]("name") map{
//            case id~name =>new Location(id,name)
//        }
//    }


//    val itemUser: RowParser[ItemUser]={
//        get[Int]("id")~
//                get[Int]("item_id")~
//                get[Int]("amount")map{
//            case id~baseId~amount => new ItemUser(id,baseId,amount)
//        }
//    }
//
//    val itemParam : RowParser[(ItemParam,Int)] = {
//        get[String]("param") ~
//                get[Int]("value")  map{
//            case param~value =>(ItemParam.withName(param) ,value)
//        }
//    }


//    val storeStoreTab: RowParser[(Int,Int)] = {
//        get[Int]("store_id") ~
//                get[Int]("store_tab_id")  map{
//            case storeId~tabId =>(storeId,tabId)
//        }
//    }
//
//    var storeTabItemBase : RowParser[(Int,Int)] = {
//        get[Int]("store_tab_id") ~
//                get[Int]("item_base_id")  map{
//            case tabId~iremId =>(tabId,iremId)
//        }
//    }
//    val storeTab: RowParser[StoreTab] = {
//        get[Int]("id")~
//                get[String]("name") map{
//            case id~name => new StoreTab(id,name)
//        }
//    }
//
//    val store: RowParser[Store] = {
//        get[Int]("id")~
//                get[String]("name")map{
//            case id~name => new Store(id,name)
//        }
//    }
//
//    val playerSlot: RowParser[Map[SlotType, Int]] ={
//
//        get[Int]("slot_1") ~
//                get[Int]("slot_2") ~
//                get[Int]("slot_3") ~
//                get[Int]("slot_4") ~
//                get[Int]("slot_5") ~
//                get[Int]("slot_6") ~
//                get[Int]("slot_7") ~
//                get[Int]("slot_8") ~
//                get[Int]("slot_9") ~
//                get[Int]("slot_10") map{
//
//            case  item1~item2~item3~item4~item5~item6~item7~item8~item9~item10 =>
//
//                HashMap[SlotType,Int](
//                    SlotType.elixir1 ->item1,
//                    SlotType.elixir2 ->item2,
//                    SlotType.elixir3 ->item3,
//                    SlotType.elixir4 ->item4,
//                    SlotType.elixir5 ->item5,
//                    SlotType.elixir6 ->item6,
//                    SlotType.elixir7 ->item7,
//                    SlotType.elixir8 ->item8,
//                    SlotType.elixir9 ->item9,
//                    SlotType.elixir10 ->item10
//                )
//        }
//
//
//    }
}
