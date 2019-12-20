package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.client.data.ChatObject

class PacketChat(val data: ChatObject) extends Packet {
    override val name: String = "chatevent"

}
