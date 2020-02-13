package ru.megains.ilos.world.location

import ru.megains.ilos.GameClass.GameClass
import ru.megains.ilos.Timer
import ru.megains.ilos.network.packet.client.data.ChatObject
import ru.megains.ilos.network.packet.server.{PacketChat, PacketLocUpdate}
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.location.MineType.MineType

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class LocationMine(id: Int, name: String, gameClass: GameClass, level:Int, val mineType: MineType) extends Location(id, name) {

    override var locationType: LocationType = LocationType.MINE


    val width = 15
    val height = 15
    val lvl = 1
    val resGens:Array[ResGen] = ResGens.getResGensWithLocId(id)
    val tileGrounds: Array[Int] = new Array(width * height)
    val resources: ArrayBuffer[Resource] = new ArrayBuffer[Resource]()

    createMine()

    override def correctCoordinate(x: Int, y: Int): Boolean = {
        x >= 0 && x < width && y >= 0 && y < height
    }

    def createMine(): Unit = {
        for (i <- tileGrounds.indices) {
            if (Random.nextInt(5) != 0) {
                tileGrounds( i) = 20 * lvl + Random.nextInt(10 + 10 * lvl)
            }

        }

        warps.foreach(w => tileGrounds(w.x + w.y * height) = 0)

        resGens.foreach(_.generate(this))



    }

    override def click(player: Player, x: Int, y: Int): Unit = {

        if(isCorrectDis(player, x, y)){
            if (tileGrounds(x + y * height) > 0) {
                player.setPlannedAction( ()=>{ excavate(player, x, y)},Timer.getTime(1) )

            } else {
                player.setPlannedAction(()=>{ move(player, x, y)},Timer.getTime(1))
            }
        }


        def excavate(player: Player, x: Int, y: Int): Unit ={
            tileGrounds(x + y * height) -= player.workDamage
            player.sendPacket(new PacketChat(new ChatObject("Location", s"На клетке х:$x у:$y удалено ${player.workDamage} породы, осталось ${tileGrounds(x + y * height)}")))
            if (tileGrounds(x + y * height) <= 0) {
                tileGrounds(x + y * height) = 0
                resources.find(r => r.x == x && r.y == y) match {
                    case Some(resource) =>
                        resources -= resource
                        player.sendPacket(new PacketChat(new ChatObject("Location", s"На клетке х:$x у:$y добыт   ${resource.item.name} в колличестве ${resource.amount} шт")))
                        player.inventory.addItem(resource.item,resource.amount)
                    case None =>
                }
                players.foreach(_.sendPacket(new PacketLocUpdate(x, y)))
            }
        }



    }

}
