package ru.megains.ilos.db.daoquill

import ru.megains.ilos.db.dao.ItemDao
import ru.megains.ilos.item.Item

import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._

class ItemDaoQuill extends ItemDao{

    override def getById(id: Int): Option[Item] = {
        run(quote{query[Item].filter(_.id==lift(id))}).headOption
    }
}
