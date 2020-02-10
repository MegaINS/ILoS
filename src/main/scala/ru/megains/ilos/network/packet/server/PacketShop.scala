package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.{PGroup, PItem, PShop, PType}
import ru.megains.ilos.world.location.shop.LocationShop


class PacketShop(shop:LocationShop) extends Packet {

    override val name: String = "shopLoad"
    override val data: AnyRef = {
        new PShop(shop.name,shop.groups.map(g => new PGroup(g.name,g.scr,g.types.map(t => new PType(t.name,t.scr,t.items.map(i => new PItem(i.item.id,i.item.name,i.amount,i.item.level ,i.item.weight,i.item.src)))))))
    }
}
