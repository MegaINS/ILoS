package ru.megains.ilos.world.location


import scala.collection.mutable

object Locations {

    val locations = new mutable.HashMap[Int,Location]()

    def getLocation(id:Int): Location ={
        locations(id)
        //getOrElse(id,default = LocationNone)
    }

    def addLocation(location:Location): Int ={
        locations += locations.size -> location
        locations.size-1
    }


}
