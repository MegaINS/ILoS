package ru.megains.ilos.inventory

import ru.megains.ilos.item.{Item, ItemStack, Items}
import ru.megains.ilos.network.packet.client.data.ChatObject
import ru.megains.ilos.network.packet.server.{PacketChat, PacketPlayerInventory}
import ru.megains.ilos.player.Player

import scala.collection.mutable.ArrayBuffer

class PlayerInventory(player:Player) extends Inventory {
    def getItem(id: Int): Option[ItemStack] = {
        items.find(_.id == id)
    }


    var items:ArrayBuffer[ItemStack] = new ArrayBuffer[ItemStack]()



    def addItem(item: Item, amount: Int): Unit = {
        items.find(_.item == item) match {
            case Some(value) =>
                value.amount += amount
                player.sendPacket(new PacketChat(new ChatObject("PlayerInventory", s"В инвентарь добавлено ${item.name} $amount шт,  всего ${item.name} ${value.amount} шт")))
                player.sendPacket(new PacketPlayerInventory( player))
            case None =>
                items += Items.createItemStack(item,amount)
                player.sendPacket(new PacketChat(new ChatObject("PlayerInventory", s"В инвентарь добавлено ${item.name} $amount шт")))
                player.sendPacket(new PacketPlayerInventory( player))
        }
    }

    def removeItem(id: Int): Unit = {
        items.find(_.id == id) match {
            case Some(itemStack) =>
                items -= itemStack
                player.sendPacket(new PacketChat(new ChatObject("PlayerInventory", s"Из инвентаря удален ${itemStack.item.name} ${itemStack.amount} шт")))
                player.sendPacket(new PacketPlayerInventory( player))
            case None =>
        }
    }
}
