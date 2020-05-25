package ru.megains.ilos.item

case class ItemStack(id:Int, item:Item, var amount:Int) {


    def this(id:Int, itemId:Int, amount:Int)={
        this(id,Items.getItem(itemId),amount)
    }

}
