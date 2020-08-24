package ru.megains.ilos.db.daoquill

import ru.megains.ilos.db.dao.ItemDao
import ru.megains.ilos.item.{Item, ItemAction, ItemSlot, ItemType}
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._
import ru.megains.ilos.item.ItemAction.ItemAction
import ru.megains.ilos.item.ItemSlot.ItemSlot
import ru.megains.ilos.item.ItemType.ItemType

class ItemDaoQuill extends ItemDao{
    implicit val decodeItemAction: MappedEncoding[String, ItemAction] = MappedEncoding[String, ItemAction](ItemAction.withName)
    implicit val decodeItemSlot: MappedEncoding[String, ItemSlot] = MappedEncoding[String, ItemSlot](ItemSlot.withName)
    implicit val decodeItemType: MappedEncoding[String, ItemType] = MappedEncoding[String, ItemType](ItemType.withName)
    override def getById(id: Int): Option[Item] = {
        run(quote{query[Item].filter(_.id==lift(id))}).headOption
    }
}
