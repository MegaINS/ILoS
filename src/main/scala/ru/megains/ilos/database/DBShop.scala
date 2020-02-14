package ru.megains.ilos.database

import anorm.SQL
import ru.megains.ilos.item.ItemStack
import ru.megains.ilos.world.location.shop.{Group, Type}

object DBShop  extends Database {
    def loadShopGroups(id: Int): List[Group] = {
        withConnection { implicit c =>
            SQL(s"SELECT * FROM shop_group WHERE shopid=$id").as(Parsers.shopGroup.*)
        }
    }

    def loadGroupTypes(id: Int): List[Type] = {
        withConnection { implicit c =>
            SQL(s"SELECT * FROM shop_type WHERE groupid=$id").as(Parsers.groupType.*)
        }
    }


    def loadTypeItems(id: Int): List[ItemStack] = {
        withConnection { implicit c =>
            SQL(s"SELECT * FROM shop_item WHERE typeid=$id").as(Parsers.shopItem.*)
        }
    }


}
