package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.PPlayerInfo
import ru.megains.ilos.player.Player

class PacketPlayerInfo(player:Player) extends Packet {

    override val name: String = "loadPlayerInfo"
    override val data: AnyRef ={
        new PPlayerInfo(player)
    }
}
