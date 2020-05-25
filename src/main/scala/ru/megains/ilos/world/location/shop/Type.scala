package ru.megains.ilos.world.location.shop


import ru.megains.ilos.item.ItemStack

case class Type(id:Int, groupId:Int, name: String, src:String) {

    val items:List[ItemStack] = Shops.getTypeItemsByTypeId(id)
}
