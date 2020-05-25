package ru.megains.ilos.world.location



import ru.megains.ilos.db.dao.LocationDao

import scala.collection.mutable

object Locations {


    var locationDao:LocationDao = _

    val locations = new mutable.HashMap[Int,Location]()

    def getLocation(id:Int): Location ={
        locations.getOrElseUpdate(id,locationDao.getById(id).get)
    }

}
