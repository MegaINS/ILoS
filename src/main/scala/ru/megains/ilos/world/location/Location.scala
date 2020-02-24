package ru.megains.ilos.world.location

import ru.megains.ilos.network.packet.server._
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.warp.{Warp, Warps}
import ru.megains.ilos.{Action, Timer}

import scala.collection.mutable.ArrayBuffer

abstract class Location(val id: Int, val name: String,  val width: Int, val height: Int) {


    var locationType: LocationType
    val warps: Array[Warp] = Warps.getWarpsWithLocId(id)
    val players: ArrayBuffer[Player] = new ArrayBuffer[Player]()


    def getWarp(player: Player): Option[Warp] = {
        warps.find(w => w.x == player.posX && w.y == player.posY)
    }


    def enterObject(player: Player): Unit = {
        getWarp(player) match {
            case Some(warp) =>
                warp.in(player)
            case None =>
        }
    }


    def enter(player: Player): Unit = {


        player.location = this
        sendData(player)

        val packet = new PacketAddPlayerList(player)
        val packet1 = new PacketEnemyUpdate(Action.SPAWN, player)
        players.foreach(p => {
            p.sendPacket(packet)
            p.sendPacket(packet1)
        })
        players += player
        sendPlayerList(player)
    }

    def sendData(player:Player): Unit ={
        player.sendPacket(new PacketLocation(this))
        player.sendPacket(new PacketPlayerUpdate(Action.SPAWN, player))
    }

    def exit(player: Player): Unit = {
        players -= player
        val packet = new PacketRemovePlayer(player)
        val packet1 = new PacketEnemyUpdate(Action.REMOVE, player)
        players.foreach(p => {
            p.sendPacket(packet)
            p.sendPacket(packet1)
        })
    }

    def isCorrectDis(player: Player, x: Int, y: Int): Boolean = {Math.abs(player.posX - x) == 0 || Math.abs(player.posX - x) == 1 &&  Math.abs(player.posY - y) == 0 || Math.abs(player.posY - y) == 1}


    def click(player: Player, x: Int, y: Int): Unit = {
        if (isCorrectDis(player, x, y)) {
            player.setPlannedAction(() => {move(player, x, y)}, Timer.getTime(1))
        }

    }

    def correctCoordinate(x: Int, y: Int): Boolean

    def move(player: Player, x: Int, y: Int): Unit = {
        player.posX = x
        player.posY = y
        player.sendPacket(new PacketPlayerUpdate(Action.MOVE, player))
        val packet = new PacketEnemyUpdate(Action.MOVE, player)
        players.filter(_ != player).foreach(_.sendPacket(packet))
    }


    def sendPlayerList(player: Player): Unit = {
        player.sendPacket(new PacketLoadPlayersList(players))
        players.filter(_ != player).foreach(p => {
            player.sendPacket(new PacketEnemyUpdate(Action.SPAWN, p))
        })
    }

}
