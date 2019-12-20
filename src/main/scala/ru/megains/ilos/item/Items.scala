package ru.megains.ilos.item

import scala.collection.mutable

object Items {


    val items = new mutable.HashMap[Int,Item]()

    val itemStacks = new mutable.HashMap[Int,ItemStack]()



    def getItem(id:Int):Item = items(id)

    def load(): Unit = {

        items += 1 -> new Item(1, "Ржавае железо",0,10,"materials-35")
        items += 2 -> new Item(2, "Чугун",1,50,"materials-28")


    }

    def createItemStack(item: Item, amount:Int): ItemStack ={
        val itemStack = new ItemStack(itemStacks.size,item,amount)
        itemStacks += itemStack.id -> itemStack
        itemStack
    }


}
