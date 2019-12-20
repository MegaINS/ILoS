package ru.megains.ilos.world.location

import ru.megains.ilos.GameClass
import ru.megains.ilos.item.Items
import ru.megains.ilos.world.warp.Warps

import scala.collection.mutable

object Locations {



    val locations = new mutable.HashMap[Int,Location]()

    def getLocation(id:Int): Location ={
        locations(id)
        //getOrElse(id,default = LocationNone)
    }

    def load(): Unit ={


        val warps0 = Warps.getWarpsWithLocId(0)
        val warps1 = Warps.getWarpsWithLocId(1)
        val warps2 = Warps.getWarpsWithLocId(2)
        val warps3 = Warps.getWarpsWithLocId(3)
        val warps4 = Warps.getWarpsWithLocId(4)
        val warps5 = Warps.getWarpsWithLocId(5)
        val warps6 = Warps.getWarpsWithLocId(6)
        val antiria = new LocationOpen(0,"antiria",warps0)

        antiria.src = "antiria"

        locations += antiria.id -> antiria


        val hab1 = new LocationHab(1,"hab mine",warps1,"mine")
        val hab2 = new LocationHab(5,"hab forest",warps5,"forest")
        val hab3 = new LocationHab(6,"hab meadow",warps6,"meadow")
        locations += hab1.id -> hab1
        locations += hab2.id -> hab2
        locations += hab3.id -> hab3

        val resGen1 = Array(
            new ResGen(Items.getItem(0),1,5,10),
            new ResGen(Items.getItem(1),1,3,5),
            new ResGen(Items.getItem(2),1,2,1)
        )
        val resGen2 = Array(
            new ResGen(Items.getItem(6),1,5,10),
            new ResGen(Items.getItem(7),1,3,5),
            new ResGen(Items.getItem(8),1,2,1)
        )
        val resGen3 = Array(
            new ResGen(Items.getItem(3),1,5,10),
            new ResGen(Items.getItem(4),1,3,5),
            new ResGen(Items.getItem(5),1,2,1)
        )

        val mine1 = new LocationMine(2,"mine 1",GameClass.CLASS_0,1,MineType.MINE,warps2,resGen1)
        val forest1 = new LocationMine(3,"forest 1",GameClass.CLASS_0,1,MineType.FOREST,warps3,resGen2)
        val meadow1 = new LocationMine(4,"meadow 1",GameClass.CLASS_0,1,MineType.MEADOW,warps4,resGen3)


        mine1.createMine()
        forest1.createMine()
        meadow1.createMine()
        locations += mine1.id -> mine1
        locations += forest1.id -> forest1
        locations += meadow1.id -> meadow1
    }

}
