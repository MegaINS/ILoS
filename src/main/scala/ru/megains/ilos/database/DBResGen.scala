package ru.megains.ilos.database

import anorm.SQL
import ru.megains.ilos.world.location.ResGen

object DBResGen extends Database {



    def loadResGen(id: Int): ResGen = {
        withConnection { implicit c =>
            SQL(s"SELECT * FROM resource WHERE id=$id").as(Parsers.resource.single)
        }
    }

    def loadResGens(id: Int): List[Int] = {
        withConnection { implicit c =>
            SQL(s"SELECT * FROM resource_location WHERE locationid=$id").as( Parsers.resourceId.*)
        }
    }
}
