package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.PLocUpdate

class PacketLocUpdate(x:Int,y:Int) extends Packet {
    override val name: String = "locUpdate"
    override val data: AnyRef = {
        new PLocUpdate(x,y)
    }
}
