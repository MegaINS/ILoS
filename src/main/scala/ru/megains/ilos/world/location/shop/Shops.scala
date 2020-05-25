package ru.megains.ilos.world.location.shop

import ru.megains.ilos.db.dao.ShopDao
import ru.megains.ilos.item.ItemStack

object Shops {


    var shopDao:ShopDao = _

    def getGroupTypesByGroupId(id: Int): List[Type] = {
        shopDao.getGroupTypesByGroupId(id)
    }

    def getGroupsByShopId(id: Int): List[Group] = {
        shopDao.getGroupsByShopId(id)
    }

    def getTypeItemsByTypeId(id: Int): List[ItemStack] = {
        shopDao.getTypeItemsByTypeId(id)
    }
}
