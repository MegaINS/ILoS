package ru.megains.ilos.network

import ru.megains.ilos.Action
import ru.megains.ilos.network.packet.client.data.PacketDataAction
import ru.megains.ilos.player.Player

class NetHandler(player: Player) {



    def processPacketAction(data: PacketDataAction): Unit = {
        data.action match {
            case Action.CLICK =>
                player.location.click(player,data.data(0),data.data(1))
            case Action.ENTER =>
                player.location.enterObject(player)
            case _ =>
                println("PacketAction " + data.action)
        }
    }


}
