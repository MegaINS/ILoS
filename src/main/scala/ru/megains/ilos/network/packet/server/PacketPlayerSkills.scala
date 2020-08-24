package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.PPlayerSkills
import ru.megains.ilos.player.Player

class PacketPlayerSkills(player:Player) extends Packet {
    override val name: String = "loadPlayerSkills"
    override val data: AnyRef = {
        new PPlayerSkills(player)
    }
}
