package ru.megains.ilos.world.location

import ru.megains.ilos.database.DBResGen

import scala.collection.mutable

object ResGens {



   val resources = new mutable.HashMap[Int,ResGen]()


    def getResGen(id:Int):ResGen ={
        resources.getOrElseUpdate(id,DBResGen.loadResGen(id))
    }
    def getResGensWithLocId(id:Int):Array[ResGen] ={
        val resLoc:List[Int] = DBResGen.loadResGens(id)
        resLoc.map(getResGen).toArray
    }
}
