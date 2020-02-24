package ru.megains.ilos.database

import anorm.SQL
import ru.megains.ilos.player.Player

object DBPlayer extends Database {



    def loadPlayerFromSession(session: String): Option[Player] = {
        withConnection(implicit c => {
            SQL(s"SELECT * FROM auth a JOIN player p ON p.player_id = a.id WHERE a.session='$session'").as(Parsers.player.singleOpt)
        })
    }


}
