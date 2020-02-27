package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.Action.Action

import scala.beans.BeanProperty

class PPlayerSpawn(action:Action, @BeanProperty val  x:Int, @BeanProperty val  y:Int) {

    def getAction: String = action.toString
}
