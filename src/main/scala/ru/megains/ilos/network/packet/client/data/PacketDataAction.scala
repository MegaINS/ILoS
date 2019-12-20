package ru.megains.ilos.network.packet.client.data

import ru.megains.ilos.Action
import ru.megains.ilos.Action.Action

class PacketDataAction() {

    var action:Action = _
    var data:Array[Int] = _

    def setAction(actionIn:String): Unit ={
        action = Action.withName(actionIn)
    }

    def setData(dataIn:Array[Int]): Unit ={
        data = dataIn
    }


    override def toString = s"PacketAction($action, ${if(data!= null)  data./:("")(_ + " " + _) })"
  //override def toString = s"PacketAction($action, ${if(data!= null)  ("" /: data)(_ + " " + _) })"
}

