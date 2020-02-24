package ru.megains.ilos.world.warp

import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.{Location, Locations}

case class Warp(id:Int, name:String,locId:Int, x:Int, y:Int, outId:Int){



    lazy val loc:Location = Locations.getLocation(locId)
    lazy val outWarp:Warp = Warps.getWarp(outId)


    def out(player: Player): Unit = {
        player.posX = x
        player.posY = y
        loc.enter(player)
    }

    def in(player: Player): Unit = {
        loc.exit(player)
        outWarp.out(player)
    }
}
