package ru.megains.ilos.item

import scala.collection.mutable

object Items {


    val items = new mutable.HashMap[Int,Item]()

    val itemStacks = new mutable.HashMap[Int,ItemStack]()



    def getItem(id:Int):Item = items(id)

    def load(): Unit = {

        items += 0 -> new Item(0, "Ржавае железо",0,10,"materials-30")
        items += 1 -> new Item(1, "Чугун",1,50,"materials-23")
        items += 2 -> new Item(2, "Медь",1,25,"materials-29")


        items += 3 -> new Item(3, "Кролик",0,10,"materials-18")
        items += 4 -> new Item(4, "Ольнь",1,50,"materials-92")
        items += 5 -> new Item(5, "Кабан",1,25,"materials-80")

        items += 6 -> new Item(6, "Трухлявый тополь",0,10,"materials-49")
        items += 7 -> new Item(7, "Ясень ",1,50,"materials-5")
        items += 8 -> new Item(8, "Осина",1,25,"materials-2")
    }

    def createItemStack(item: Item, amount:Int): ItemStack ={
        val itemStack = new ItemStack(itemStacks.size,item,amount)
        itemStacks += itemStack.id -> itemStack
        itemStack
    }


}
