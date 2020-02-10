package ru.megains.ilos.database

import anorm.SQL
import ru.megains.ilos.world.location.{Location, LocationType}

object DBLocation extends Database {

    def loadLocation(id: Int): Location = {
        withConnection { implicit c =>
           val locInf = SQL(s"SELECT * FROM location WHERE id='$id'").as(Parsers.location.single)
            locInf._2 match {
                case LocationType.OPEN =>
                    SQL(s"SELECT * FROM location l JOIN location_open l_o ON l_o.locationid = l.id  WHERE l.id='${locInf._1}'").as(Parsers.locationOpen.single)
                case LocationType.HAB =>
                    SQL(s"SELECT * FROM location l JOIN location_hab l_o ON l_o.locationid = l.id  WHERE l.id='${locInf._1}'").as(Parsers.locationHab.single)
                case LocationType.MINE =>
                    SQL(s"SELECT * FROM location l JOIN location_mine l_o ON l_o.locationid = l.id  WHERE l.id='${locInf._1}'").as(Parsers.locationMine.single)
               // case ru.megains.ilos.world.location.LocationType.SHOP =>
                //    SQL(s"SELECT * FROM location WHERE id='$id'").as(Parsers.location.single)
            }

        }
    }

}
