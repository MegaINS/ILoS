package ru.megains.ilos.network.packet.client

import com.corundumstudio.socketio.listener.DataListener
import com.corundumstudio.socketio.{AckRequest, SocketIOClient}
import ru.megains.ilos.IloSServer

abstract class Packet[T](server:IloSServer) extends DataListener[T]{

    override def onData(client: SocketIOClient, data: T, ackSender: AckRequest): Unit = {
        server.gameLogicHandler.addPacketToProcess(()=>{this.processPacket(client,data)})
    }

    def processPacket(client: SocketIOClient, data: T): Unit
}
