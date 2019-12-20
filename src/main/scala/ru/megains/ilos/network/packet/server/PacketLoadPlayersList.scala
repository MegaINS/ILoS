package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.{PPlayer, PPlayerList}
import ru.megains.ilos.player.Player

import scala.collection.mutable.ArrayBuffer

class PacketLoadPlayersList(players:ArrayBuffer[Player]) extends Packet {


    override val name: String = "loadPlayersList"
    override val data: AnyRef = {
        new PPlayerList( players.map(p => new PPlayer(p.id,p.name)).toArray)
    }
}
