package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType

class PLocationHab(id:Int, name:String, locationType: LocationType,weight:Int,height:Int,warps:Array[PWarp],area:String) {

    def getId: Int = id
    def getName: String = name
    def getLocationType:String = locationType.toString
    def getWeight: Int = weight
    def getHeight: Int = height
    def getWarps: Array[PWarp] = warps
    def getArea: String = area
}
