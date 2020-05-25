package ru.megains.ilos.db.dao

import ru.megains.ilos.world.location.ResGen

trait ResGenDao {

    def getById(id:Int): Option[ResGen]
    def getListIdByLocId(id:Int):List[Int]

}
