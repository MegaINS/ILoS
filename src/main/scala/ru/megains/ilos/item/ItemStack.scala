package ru.megains.ilos.item

class ItemStack(val id:Int, val item:Item, var amount:Int) {


    def this(id:Int, itemId:Int, amount:Int){
        this(id,Items.getItem(itemId),amount)
    }

}
