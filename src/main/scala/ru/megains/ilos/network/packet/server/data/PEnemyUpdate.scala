package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.Action.Action

class PEnemyUpdate(action:Action,id:Int, x:Int, y:Int) {

    def getAction: String = action.toString
    def getId: Int = id
    def getX: Int = x
    def getY: Int = y

}
