package ru.megains.ilos.world.location

import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.warp.Warp

class LocationOpen(id:Int,name:String, val src:String) extends Location(id,name) {

    var locationType:LocationType = LocationType.OPEN
    var height:Int = _
    var width:Int = _

    override def correctCoordinate(x: Int, y: Int): Boolean = {
        x >= 0 && x < width && y >= 0 && y < height
    }



}
