package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.Action.Action

class PPlayerSpawn(action:Action,var x:Int,var y:Int) {

    def getAction: String = action.toString
    def getX: Int = x
    def getY: Int = y
}
