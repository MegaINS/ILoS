package ru.megains.ilos

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.db.dao.PlayerDao
import ru.megains.ilos.player.Player
import ru.megains.ilos.utils.Logger
import ru.megains.ilos.world.location.Locations

import scala.collection.mutable

class PlayerList(server: IloSServer) extends Logger[PlayerList] {


    val playerDao: PlayerDao = server.daoFactory.getPlayerDao
    val players = new mutable.HashMap[Int, Player]()

    def initializeConnectionToPlayer(session: String, client: SocketIOClient): Option[Player] = {
        log.info(s"Start initialize player session=$session")

        log.info(s"Load player")

        playerDao.getBySession(session) match {
            case Some((authDto, playerDto)) =>
                log.info(s"Load player id=${authDto.name}")
                var player:Player = null
                if (players.contains(authDto.id)) {
                    player = players(authDto.id)
                    player.client = client
                    player.sendLocationInfo()
                    log.info(s"Player online")
                } else {
                    player = new Player(authDto.name,client, playerDto)
                    Locations.getLocation(playerDto.location).enter(player)
                    players += player.id -> player
                    log.info(s"Player offline")
                }

                player.sendPlayerInfo()
                Some(player)
            case None =>
                log.info(s"Not session=$session")
                None
        }

    }


    def update(time: Double): Unit = {
        players.values.foreach(_.update(time))
    }


}
