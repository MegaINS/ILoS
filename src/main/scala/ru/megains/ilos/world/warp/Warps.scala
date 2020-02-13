package ru.megains.ilos.world.warp

import ru.megains.ilos.database.DBWarp

object Warps {

    val warps: Map[Int, Warp] = DBWarp.loadWarps()

    def getWarp(id: Int): Warp = {
        warps(id)
    }

    def getWarpsWithLocId(id: Int): Array[Warp] = {
        warps.values.filter(w => w.locId == id).toArray
    }

}
