package ru.megains.ilos
import ru.megains.ilos.item.Items
import ru.megains.ilos.utils.Logger
import ru.megains.ilos.world.location._
import ru.megains.ilos.world.location.shop.{Group, LocationShop, Shops, Type}
import ru.megains.ilos.world.warp.Warps

object Bootstrap extends Logger[IloSServer]{



   def init(){
       log.info("Load Items")
       Items.load()

       log.info("Load Warps")
       Warps.load()
       log.info("Locations init")
       initLocations()
       log.info("Shop init")
       initShop()
    }

    def initLocations(): Unit ={


        val warps0 = Warps.getWarpsWithLocId(0)
        val warps1 = Warps.getWarpsWithLocId(1)
        val warps2 = Warps.getWarpsWithLocId(2)
        val warps3 = Warps.getWarpsWithLocId(3)
        val warps4 = Warps.getWarpsWithLocId(4)
        val warps5 = Warps.getWarpsWithLocId(5)
        val warps6 = Warps.getWarpsWithLocId(6)
        val antiria = new LocationOpen(0,"antiria",warps0)

        antiria.src = "antiria"

        Locations.addLocation(antiria)



        val hab1 = new LocationHab(1,"hab mine",warps1,"mine")
        val hab2 = new LocationHab(5,"hab forest",warps5,"forest")
        val hab3 = new LocationHab(6,"hab meadow",warps6,"meadow")
        Locations.addLocation(hab1)
                Locations.addLocation(hab2)
                Locations.addLocation(hab3)

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
        Locations.addLocation(mine1)
        Locations.addLocation(forest1)
        Locations.addLocation(meadow1)
    }
    private def  initShop(): Unit ={
        val warps1 = Warps.getWarpsWithLocId(7).last
        val shop0 = new LocationShop(
            7,
            "Первый магазин",
            warps1,
            Array(
                new Group(
                    "Книги",
                    "books",

                    Array(
                        new Type(
                            "Книги",
                            "book",
                            Array(
                               Items.createItemStack(Items.getItem(0),10)
                            )
                        )
                    )
                ),
                new Group(
                    "Инструменты",
                    "tools",
                    Array(
                        new Type(
                            "Инструмент добычи",
                            "craft_forging",
                            Array(
                                Items.createItemStack(Items.getItem(1),20)
                            )
                        ),
                        new Type(
                            "Инструмент создания",
                            "mine",
                            Array(
                                Items.createItemStack(Items.getItem(0),5),
                                Items.createItemStack(Items.getItem(1),15)
                            )
                        )
                    )
                )
            )
        )

        Locations.addLocation(shop0)
        Shops.addShop(shop0)

    }
}

