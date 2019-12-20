package ru.megains.ilos.network.packet.client

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.IloSServer
import ru.megains.ilos.network.NetHandler
import ru.megains.ilos.network.packet.client.data.PacketDataAction

class PacketAction(server:IloSServer) extends Packet[PacketDataAction](server){


    override def processPacket(client: SocketIOClient, data: PacketDataAction): Unit = {
        println("action")
        println(data.toString)

        client.get[NetHandler]("player").processPacketAction(data)

    }
}
