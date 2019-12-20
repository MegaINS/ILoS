package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType

class PLocationOpen(id:Int, name:String, src: String, locationType: LocationType,warps: Array[PWarp]) {

    def getName: String = name
    def getSRC: String = src
    def getId: Int = id
    def getLocationType:String = locationType.toString
    def getWarps: Array[PWarp] = warps

}
