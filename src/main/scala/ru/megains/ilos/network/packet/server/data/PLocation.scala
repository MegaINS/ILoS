package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.world.location.LocationType.LocationType

import scala.beans.BeanProperty

class PLocation(@BeanProperty val id: Int,
                @BeanProperty val name: String,
                locationType: LocationType,
                @BeanProperty val weight: Int,
                @BeanProperty val height: Int,
                @BeanProperty val warps: Array[PWarp]) {

    def getLocationType: String = locationType.toString
}

