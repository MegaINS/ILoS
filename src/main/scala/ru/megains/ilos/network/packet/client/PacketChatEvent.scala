package ru.megains.ilos.network.packet.client

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.IloSServer
import ru.megains.ilos.network.NetHandler
import ru.megains.ilos.network.packet.client.data.ChatObject

class PacketChatEvent(server:IloSServer) extends Packet[ChatObject](server)  {
    override def processPacket(client: SocketIOClient, data: ChatObject): Unit = {
        println("chatevent")
        client.get[NetHandler]("player").processPacketChatEvent(data)
    }
}
