package ru.megains.ilos.database

import anorm.SQL
import ru.megains.ilos.world.warp.Warp

object DBWarp extends Database {



    def loadWarps(): Map[Int,Warp]  ={
        withConnection { implicit c =>
            SQL(s"SELECT * FROM warp").as(Parsers.warp.*).map(w=> w.id -> w)(collection.breakOut)
        }
    }

    def loadWarp(id:Int): Warp ={
        withConnection { implicit c =>
            SQL(s"SELECT * FROM warp WHERE id='$id'").as(Parsers.warp.single)
        }
    }

}
