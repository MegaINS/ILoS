package ru.megains.ilos.item

import ru.megains.ilos.database.DBItem

import scala.collection.mutable

object Items {


    val items = new mutable.HashMap[Int,Item]()

    val itemStacks = new mutable.HashMap[Int,ItemStack]()

    def getItem(id:Int):Item = {
        items.getOrElseUpdate(id, DBItem.loadItem(id))

    }


    def createItemStack(item: Item, amount:Int): ItemStack ={
        val itemStack = new ItemStack(itemStacks.size,item,amount)
        itemStacks += itemStack.id -> itemStack
        itemStack
    }


}
