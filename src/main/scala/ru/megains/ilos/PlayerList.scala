package ru.megains.ilos

import anorm.SQL
import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.database.{Database, Parsers}
import ru.megains.ilos.player.Player
import ru.megains.ilos.utils.Logger
import ru.megains.ilos.world.location.Locations

import scala.collection.mutable

class PlayerList(server: IloSServer) extends Logger[PlayerList] with Database {

    val players = new mutable.HashMap[Int, Player]()

    def initializeConnectionToPlayer(session: String,client: SocketIOClient): Player = {
        log.info(s"Start initialize player session=$session")
        var player: Player = null
        withConnection(implicit c => {
            log.info(s"Load player")
            val playerOpt = SQL(s"SELECT * FROM player_auth WHERE session='$session'").as(Parsers.player.singleOpt)
            playerOpt match {
                case Some(value) =>
                    log.info(s"Load player id=${value.name}")
                    if (!players.contains(value.id)) {
                        player = value
                        player.client = client
                        log.info(s"Player offline")
                        players += value.id -> player
                       // val info = SQL(s"SELECT * FROM player_info WHERE id='${player.id}'").as(Parsers.playerInfo.single)
                        Locations.getLocation(0).enter(player)
                    } else {
                        player = players(value.id)
                        player.client = client
                        player.sendData()
                        log.info(s"Player online")
                    }

                case None =>
                    log.info(s"Not session=$session")
            }
        })
        if(player!= null){
            player.sendPlayerInfo()

        }


        player
    }


    def update(time:Double): Unit ={
        players.values.foreach(_.update(time))
    }


}
