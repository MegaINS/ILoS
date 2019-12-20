package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.PPlayerInventory
import ru.megains.ilos.player.Player

class PacketPlayerInventory(player:Player) extends Packet {

    override val name: String = "loadPlayerInventory"
    override val data: AnyRef ={
        new PPlayerInventory(player)
    }
}
