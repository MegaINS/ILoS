package ru.megains.ilos.world.location

import ru.megains.ilos.GameClass.GameClass
import ru.megains.ilos.network.packet.client.data.ChatObject
import ru.megains.ilos.network.packet.server.{PacketChat, PacketLocUpdate, PacketPlayerUpdate}
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.location.MineType.MineType
import ru.megains.ilos.{Action, Timer}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class LocationMine(id: Int, name: String, gameClass: GameClass, level: Int, val mineType: MineType, width: Int, height: Int) extends Location(id, name, width, height) {

    override var locationType: LocationType = LocationType.MINE


    val lvl = 1
    val resGens: Array[ResGen] = ResGens.getResGensWithLocId(id)
    val tileGrounds: Array[Int] = new Array(width * height)
    val resources: ArrayBuffer[Resource] = new ArrayBuffer[Resource]()

    createMine()

    override def correctCoordinate(x: Int, y: Int): Boolean = {
        x >= 0 && x < width && y >= 0 && y < height
    }

    def createMine(): Unit = {
        for (i <- tileGrounds.indices) {
            if (Random.nextInt(5) != 0) {
                tileGrounds(i) = 20 * lvl + Random.nextInt(10 + 10 * lvl)
            }

        }

        warps.foreach(w => tileGrounds(w.x + w.y * height) = 0)

        resGens.foreach(_.generate(this))


    }

    override def click(player: Player, dX: Int, dY: Int): Unit = {
        if (isCorrectDis(dX, dY)) {
            val x = player.posX + dX
            val y = player.posY + dY
            if (tileGrounds(x + y * height) > 0) {
                player.setPlannedAction(() => {excavate(player, dX, dY)}, Timer.getTime(1))
            } else {
                super.click(player, dX, dY)
            }
        }
    }

    def excavate(player: Player, dX: Int, dY: Int): Unit = {
        val x = player.posX + dX
        val y = player.posY + dY
        tileGrounds(x + y * height) -= player.workMinDamage
        player.sendPacket(new PacketChat(new ChatObject("Location", s"На клетке х:$x у:$y удалено ${player.workMinDamage} породы, осталось ${tileGrounds(x + y * height)}")))
        player.sendPacket(new PacketPlayerUpdate(Action.MOVE, player))
        if (tileGrounds(x + y * height) <= 0) {
            tileGrounds(x + y * height) = 0
            resources.find(r => r.x == x && r.y == y) match {
                case Some(resource) =>
                    resources -= resource
                    player.sendPacket(new PacketChat(new ChatObject("Location", s"На клетке х:$x у:$y добыт   ${resource.item.name} в колличестве ${resource.amount} шт")))
                    player.inventory.addItem(resource.item, resource.amount)
                case None =>
            }
            players.foreach(_.sendPacket(new PacketLocUpdate(x, y)))
        }
    }


}
