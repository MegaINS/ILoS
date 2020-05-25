package ru.megains.ilos.world.location


import ru.megains.ilos.db.dao.ResGenDao

import scala.collection.mutable

object ResGens {


    var resGenDao:ResGenDao = _
    val resources = new mutable.HashMap[Int,ResGen]()


    def getResGen(id:Int):ResGen ={
        resources.getOrElseUpdate(id,resGenDao.getById(id).get)
    }
    def getResGensWithLocId(id:Int):Array[ResGen] ={
        val resLoc:List[Int] = resGenDao.getListIdByLocId(id)
        resLoc.map(getResGen).toArray
    }
}
