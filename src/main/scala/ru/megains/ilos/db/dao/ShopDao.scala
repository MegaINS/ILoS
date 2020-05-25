package ru.megains.ilos.db.dao

import ru.megains.ilos.item.ItemStack
import ru.megains.ilos.world.location.shop.{Group, Type}

trait ShopDao {

    def getGroupsByShopId(id: Int): List[Group]

    def getGroupTypesByGroupId(id: Int): List[Type]

    def getTypeItemsByTypeId(id: Int): List[ItemStack]

}
