package ru.megains.ilos.db.dao

import ru.megains.ilos.world.warp.Warp

trait WarpDao {

    def getWarps: Map[Int,Warp]

    def getWarpById(id:Int): Option[Warp]
}
