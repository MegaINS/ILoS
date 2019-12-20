package ru.megains.ilos.network.packet.server.data

class PItem(id:Int,amount:Int, itemClass:Int, weight:Int) {

    def getId:Int = id
    def getAmount:Int = amount
    def getItemClass:Int = itemClass
    def getWeight:Int = weight

}
