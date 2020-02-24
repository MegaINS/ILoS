package ru.megains.ilos.world.location

import ru.megains.ilos.world.location.LocationType.LocationType

class LocationOpen(id:Int,name:String, val src:String, width: Int, height: Int) extends Location(id,name, width, height) {

    var locationType:LocationType = LocationType.OPEN

    override def correctCoordinate(x: Int, y: Int): Boolean = {
        x >= 0 && x < width && y >= 0 && y < height
    }



}
