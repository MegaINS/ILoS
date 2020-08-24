package ru.megains.ilos.network.packet.client

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.IloSServer
import ru.megains.ilos.network.NetHandler
import ru.megains.ilos.network.packet.client.data.PacketDataInventoryAction

class PacketInventoryAction(server:IloSServer) extends Packet[PacketDataInventoryAction](server){


    override def processPacket(client: SocketIOClient, data: PacketDataInventoryAction): Unit = {
        println("InventoryAction")
        println(data.toString)

        client.get[NetHandler]("player").processPacketInventoryAction(data)

    }
}