package ru.megains.ilos.network.packet.client

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.listener.ConnectListener
import ru.megains.ilos.IloSServer
import ru.megains.ilos.network.NetHandler
import ru.megains.ilos.network.packet.client.data.ChatObject

class PacketConnect(server:IloSServer) extends ConnectListener{


    override def onConnect(client: SocketIOClient): Unit = {
        println("onConnect")
        val cookie: Map[String, String] =   client.getHandshakeData.getHttpHeaders.get("Cookie").split(";").map(c => (c.split("=")(0).trim , c.split("=")(1).trim)).toMap

        cookie.get("GAME_SESSION") match {
            case Some(session) =>
                println("session")

                val playerOpt = server.playerList.initializeConnectionToPlayer(session,client)

                playerOpt match {
                    case Some(player) =>
                        val netHandler = new NetHandler(server,player)
                        client.set("player",netHandler)
                        client.sendEvent("chatevent",new ChatObject("SERVER","Добро пожаловать в игру "+player.name))
                        server.socketServer.getAllClients.stream().filter(c => c!= client).forEach(c => c.sendEvent("chatevent",new ChatObject("SERVER","Игрок "+player.name+ " вошел в игру")))
                    case None =>
                        println("player not found")
                        client.disconnect()
                }
            case _ =>  println("not session")
        }
    }
}
