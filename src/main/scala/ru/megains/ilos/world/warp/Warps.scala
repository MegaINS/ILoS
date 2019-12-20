package ru.megains.ilos.world.warp

import scala.collection.mutable

object Warps {

    val warps = new mutable.HashMap[Int, Warp]()

    def getWarp(id: Int): Warp = {
        warps(id)
    }

    def getWarpsWithLocId(id: Int): Array[Warp] = {
        warps.values.filter(w => w.locId == id).toArray
    }

    def load(): Unit = {


        val warp1 = Warp(0, "in Hab mine", 0, 3, 1, 1)
        val warp2 = Warp(1, "in Antiria", 1, 2, 1, 0)

        val warp7 = Warp(6, "in Hab meadow", 0, 11, 7, 5)
        val warp6 = Warp(5, "in Antiria", 5, 2, 1, 6)


        val warp8 = Warp(7, "in Antiria", 6, 2, 1, 4)
        val warp5 = Warp(4, "in Hab forest", 0, 1, 7, 7)


        val warp3 = Warp(2, "in Mine", 1, 3, 2, 3)
        val warp4 = Warp(3, "in Hab", 2, 1, 1, 2)


        val warp9 = Warp(8, "in Forest", 5, 3, 2, 9)
        val warp10 = Warp(9, "in Hab", 3, 1, 1, 8)


        val warp11 = Warp(10, "in Meadow", 6, 3, 2, 11)
        val warp12 = Warp(11, "in Hab", 4, 1, 1, 10)


        warps += (
                warp1.id -> warp1,
                warp2.id -> warp2,
                warp3.id -> warp3,
                warp4.id -> warp4,

                warp5.id -> warp5,
                warp6.id -> warp6,
                warp7.id -> warp7,
                warp8.id -> warp8,

                warp9.id -> warp9,
                warp10.id -> warp10,
                warp11.id -> warp11,
                warp12.id -> warp12
        )
    }

}
