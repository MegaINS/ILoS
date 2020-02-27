package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.location.MineType.MineType

import scala.beans.BeanProperty

class PLocationMine(id:Int,
                    name:String,
                    locationType: LocationType,
                    weight:Int,
                    height:Int,
                    warps:Array[PWarp],
                    @BeanProperty val tile:Array[Int],
                    @BeanProperty val resources:Array[PResource],
                    mineType: MineType) extends PLocation(id,name,locationType,weight,height,warps) {


    def getMineType: String = mineType.toString
}
