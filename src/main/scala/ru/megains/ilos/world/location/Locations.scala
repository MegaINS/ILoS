package ru.megains.ilos.world.location


import ru.megains.ilos.database.DBLocation

import scala.collection.mutable

object Locations {

    val locations = new mutable.HashMap[Int,Location]()

    def getLocation(id:Int): Location ={
        locations.getOrElseUpdate(id,DBLocation.loadLocation(id))
    }

}
