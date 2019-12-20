package ru.megains.ilos.network.packet.client

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.IloSServer
import ru.megains.ilos.network.packet.client.data.ChatObject
import ru.megains.ilos.network.packet.server.PacketChat
import ru.megains.ilos.player.Player

class PacketChatEvent(server:IloSServer) extends Packet[ChatObject](server)  {
    override def processPacket(client: SocketIOClient, data: ChatObject): Unit = {
        println("chatevent")
        data.setUserName(client.get[Player]("player").name)
        println(data.toString)
        val packet = new PacketChat(data)
        server.playerList.players.values.foreach(_.sendPacket(packet))
    }
}
