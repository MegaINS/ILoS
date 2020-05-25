package ru.megains.ilos.world.location.shop



case class Group(id:Int, shopId:Int, name: String, src:String) {

    val  types:List[Type] = Shops.getGroupTypesByGroupId(id)
}
