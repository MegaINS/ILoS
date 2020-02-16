package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.PPlayer
import ru.megains.ilos.player.Player

class PacketRemovePlayer(player:Player) extends Packet {

    override val name: String = "removePlayer"
    override val data: AnyRef = {
        new PPlayer(player.id,player.name,player.level)
    }
}
