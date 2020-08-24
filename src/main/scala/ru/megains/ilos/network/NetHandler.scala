package ru.megains.ilos.network

import ru.megains.ilos.network.packet.client.data.{ChatObject, PacketDataAction, PacketDataInventoryAction}
import ru.megains.ilos.network.packet.server.PacketChat
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.shop.LocationShop
import ru.megains.ilos.{Action, IloSServer, LocationAction}

class NetHandler(server:IloSServer,player: Player) {



    def processPacketChatEvent(data: ChatObject): Unit = {
        data.userName = player.name
        println(data.toString)
        val packet = new PacketChat(data)
        server.playerList.players.values.foreach(_.sendPacket(packet))
    }


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


    def processPacketInventoryAction(packet: PacketDataInventoryAction): Unit = {
        packet.action match {
            case LocationAction.TAKE =>

            case LocationAction.TAKEOFF =>

            case LocationAction.USE =>
                player.useItem(packet.id)
            case LocationAction.DROP =>
                player.removeItem(packet.id)
        }
    }


}
