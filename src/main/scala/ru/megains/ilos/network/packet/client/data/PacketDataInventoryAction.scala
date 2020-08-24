package ru.megains.ilos.network.packet.client.data

import ru.megains.ilos.LocationAction
import ru.megains.ilos.LocationAction.LocationAction

class PacketDataInventoryAction() {

    var action:LocationAction = _
    var id:Int = _

    def setAction(actionIn:String): Unit ={
        action = LocationAction.withName(actionIn)
    }

    def setId(idIn:Int): Unit ={
        id = idIn
    }


    override def toString = s"PacketInventoryAction($action, $id)"
    //override def toString = s"PacketAction($action, ${if(data!= null)  ("" /: data)(_ + " " + _) })"
}