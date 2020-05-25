package ru.megains.ilos.db.dao

import ru.megains.ilos.world.location.Location

trait LocationDao {

    def getById(id:Int):Option[Location]
}
