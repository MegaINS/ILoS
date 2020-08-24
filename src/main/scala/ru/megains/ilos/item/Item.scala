package ru.megains.ilos.item

import ru.megains.ilos.item.ItemAction.ItemAction
import ru.megains.ilos.item.ItemSlot.ItemSlot
import ru.megains.ilos.item.ItemType.ItemType

case class Item(id:Int, name:String, level: Int, weight:Int, src:String,itemAction:ItemAction,itemType:ItemType,itemSlot:ItemSlot) {


}
