package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.player.Player

class PPlayerInventory(player:Player) {

    def getItems:Array[PItem] = player.inventory.items.map(is=> new PItem(is.id,is.amount,is.item.itemClass ,is.item.weight)).toArray
}
