package ru.megains.ilos.world.location
import ru.megains.ilos.world.location.LocationType.LocationType

class LocationHab(id:Int,name:String,val area:String ,width:Int,height:Int ) extends Location(id,name,width,height){

    var locationType: LocationType = LocationType.HAB

    override def correctCoordinate(x: Int, y: Int): Boolean = {
        x >= 0 && x < width && y >= 0 && y < height
    }
}
