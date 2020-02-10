package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.player.Player

class PPlayerInventory(player:Player) {

    def getItems:Array[PItem] = player.inventory.items.map(is=> new PItem(is.id,is.item.name,is.amount,is.item.level ,is.item.weight,is.item.src)).toArray
}
