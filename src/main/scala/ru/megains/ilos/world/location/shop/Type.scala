package ru.megains.ilos.world.location.shop

import ru.megains.ilos.database.DBShop
import ru.megains.ilos.item.ItemStack

class Type(id:Int, val name: String,val  src:String) {

    val items:List[ItemStack] = DBShop.loadTypeItems(id)
}
