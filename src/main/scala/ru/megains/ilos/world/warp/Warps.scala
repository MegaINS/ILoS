package ru.megains.ilos.world.warp

import ru.megains.ilos.db.dao.WarpDao


object Warps {


    var warpDao:WarpDao = _
    lazy val warps: Map[Int, Warp] = warpDao.getWarps

    def getWarp(id: Int): Warp = {
        warps(id)
    }

    def getWarpsWithLocId(id: Int): Array[Warp] = {
        warps.values.filter(w => w.locId == id).toArray
    }

}
