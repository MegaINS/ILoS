package ru.megains.ilos.world.location
import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.warp.Warp

class LocationHab(id:Int,name:String,val area:String  ) extends Location(id,name){

    override var locationType: LocationType = LocationType.HAB

    val width = 5
    val height = 5

    override def correctCoordinate(x: Int, y: Int): Boolean = {
        x >= 0 && x < width && y >= 0 && y < height
    }
}
