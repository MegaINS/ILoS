package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType

import scala.beans.BeanProperty

class PLocationHab(id:Int,
                   name:String,
                   locationType: LocationType,
                   weight:Int,
                   height:Int,
                   warps:Array[PWarp],
                   @BeanProperty val area:String) extends PLocation(id,name,locationType,weight,height,warps){

}
