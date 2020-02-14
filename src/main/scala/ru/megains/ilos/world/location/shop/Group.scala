package ru.megains.ilos.world.location.shop

import ru.megains.ilos.database.DBShop

class Group(id:Int,val name: String, val src:String) {

    val  types:List[Type] = DBShop.loadGroupTypes(id)
}
