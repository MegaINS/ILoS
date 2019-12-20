package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.location.MineType.MineType

class PLocationMine(id:Int, name:String, locationType: LocationType, weight:Int, height:Int, warps:Array[PWarp],tile:Array[Int],resources:Array[PResource],mineType: MineType) {

    def getId: Int = id
    def getName: String = name
    def getLocationType:String = locationType.toString
    def getWeight: Int = weight
    def getHeight: Int = height
    def getWarps: Array[PWarp] = warps
    def getTile: Array[Int] = tile
    def getResources: Array[PResource] = resources
    def getMineType: String = mineType.toString
}
