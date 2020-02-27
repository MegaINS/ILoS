package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType

import scala.beans.BeanProperty

class PLocationOpen(id:Int,
                    name:String,
                    @BeanProperty val  src: String,
                    locationType: LocationType,
                    weight:Int,
                    height:Int,
                    warps: Array[PWarp])  extends PLocation(id,name,locationType,weight,height,warps) {

}
