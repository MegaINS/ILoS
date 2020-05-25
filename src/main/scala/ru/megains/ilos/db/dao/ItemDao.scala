package ru.megains.ilos.db.dao

import ru.megains.ilos.item.Item

trait ItemDao {
    def getById(id: Int):  Option[Item]
}
