package ru.megains.ilos

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.database.{DBPlayer, Database}
import ru.megains.ilos.player.Player
import ru.megains.ilos.utils.Logger

import scala.collection.mutable

class PlayerList(server: IloSServer) extends Logger[PlayerList] with Database {

    val players = new mutable.HashMap[Int, Player]()

    def initializeConnectionToPlayer(session: String,client: SocketIOClient): Player = {
        log.info(s"Start initialize player session=$session")
        var player: Player = null
        log.info(s"Load player")

        val playerOpt = DBPlayer.loadPlayerFromSession(session)

        playerOpt match {
            case Some(playerLoad) =>
                log.info(s"Load player id=${playerLoad.name}")
                if (!players.contains(playerLoad.id)) {
                    player = playerLoad
                    player.client = client
                    log.info(s"Player offline")
                    players += player.id -> player
                    player.location.enter(player)
                }else {
                    player = players(playerLoad.id)
                    player.client = client
                    player.sendData()
                    log.info(s"Player online")
                }
            case None =>
                log.info(s"Not session=$session")
        }


        if(player!= null){
            player.sendPlayerInfo()
        }


        player
    }


    def update(time:Double): Unit ={
        players.values.foreach(_.update(time))
    }


}
