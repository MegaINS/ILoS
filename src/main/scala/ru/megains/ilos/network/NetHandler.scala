package ru.megains.ilos.network

import ru.megains.ilos.Action
import ru.megains.ilos.network.packet.client.data.PacketDataAction
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.shop.LocationShop

class NetHandler(player: Player) {



    def processPacketAction(packet: PacketDataAction): Unit = {
        packet.action match {
            case Action.CLICK =>
                player.location.click(player,packet.data(0),packet.data(1))
            case Action.ENTER =>
                player.location.enterObject(player)
            case Action.BUY_ITEM =>
                player.location match {
                    case shop: LocationShop =>
                        shop.buyItem(packet.data(0),packet.data(1),player)
                    case _ =>
                        println("PacketAction Action.BUY_ITEM Error")
                }


            case _ =>
                println("PacketAction " + packet.action)
        }
    }


}
