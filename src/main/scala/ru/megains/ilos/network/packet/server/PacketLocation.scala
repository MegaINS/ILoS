package ru.megains.ilos.network.packet.server

import ru.megains.ilos.network.packet.server.data.{PLocationHab, PLocationMine, PLocationOpen, PResource, PWarp}
import ru.megains.ilos.world.location._

class PacketLocation(location:Location) extends Packet {


    override val name: String = "locationUpdate"
    override val data: AnyRef = {

        location.locationType match {
            case LocationType.OPEN =>
                new PLocationOpen(
                    location.id,
                    location.name,
                    location.asInstanceOf[LocationOpen].src,
                    location.locationType,
                    location.warps.map(w => new PWarp(w.name,w.x,w.y))
                )
            case LocationType.HAB =>
                new PLocationHab(
                    location.id,
                    location.name,
                    location.locationType,
                    location.asInstanceOf[LocationHab].width,
                    location.asInstanceOf[LocationHab].height,
                    location.warps.map(w => new PWarp(w.name,w.x,w.y)),
                    location.asInstanceOf[LocationHab].area
                )
            case LocationType.MINE =>
                new PLocationMine(
                    location.id,
                    location.name,
                    location.locationType,
                    location.asInstanceOf[LocationMine].width,
                    location.asInstanceOf[LocationMine].height,
                    location.warps.map(w => new PWarp(w.name,w.x,w.y)),
                    location.asInstanceOf[LocationMine].tileGrounds,
                    location.asInstanceOf[LocationMine].resources.map(r => new PResource(r.item.scr,r.amount,r.x,r.y)).toArray,
                    location.asInstanceOf[LocationMine].mineType
                )

        }
    }
}
