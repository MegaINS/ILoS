package ru.megains.ilos.db.daoquill

import ru.megains.ilos.db.dao.WarpDao
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._
import ru.megains.ilos.world.warp.Warp

class WarpDaoQuill() extends WarpDao {

    def getWarps: Map[Int,Warp]  ={
        run(quote{query[Warp]}).map(w=> w.id -> w).toMap
    }

    def getWarpById(id:Int): Option[Warp] ={
        run(quote{query[Warp].filter(_.id == lift(id))}).headOption
    }
}
