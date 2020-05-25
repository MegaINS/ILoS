package ru.megains.ilos.db.dao

import ru.megains.ilos.db.dto.{AuthDto, PlayerDto}

trait PlayerDao {
    def getBySession(session:String): Option[(AuthDto, PlayerDto)]
}

