package ru.megains.ilos.world.location.shop

import scala.collection.mutable

object Shops {

    val shops = new mutable.HashMap[Int,LocationShop]()

    def getShop(id:Int): LocationShop={
        shops(id)
    }

    def addShop(shop:LocationShop): Int ={
        shops += shops.size -> shop
        shops.size-1
    }

}
