package ru.megains.ilos.database

import anorm.SqlParser.get
import anorm.{RowParser, ~}
import ru.megains.ilos.player.Player

object Parsers {



    val player: RowParser[Player] = {
        get[Int]("id") ~
                get[String]("name") map{
            case id~name =>new Player(id,name)
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

//    val itemBase: RowParser[ItemBase] = {
//        get[Int]("id") ~
//                get[String]("name") ~
//                get[String]("img") ~
//                get[Int]("level") ~
//                get[Int]("cost") ~
//                get[Boolean]("weight") ~
//                get[Boolean]("private")~
//                get[String]("action")~
//                get[String]("slot")~
//                get[Boolean]("stack")map{
//            case id~name~img~level~cost~weight~privat~action~slot~stack => new ItemBase(id,name,img,level,cost,weight,privat,ItemAction.withName(action),SlotType.withName(slot),stack )
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
