package ru.megains.ilos.database

import anorm.SQL
import ru.megains.ilos.item.Item

object DBItem extends Database {


    def loadItem(id:Int): Item ={
        withConnection { implicit c =>
            SQL(s"SELECT * FROM item WHERE id='$id'").as(Parsers.item.single)
        }
    }

}
