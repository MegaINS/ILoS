package ru.megains.ilos.player

import ru.megains.ilos.world.location.MineType
import ru.megains.ilos.world.location.MineType.MineType

import scala.language.implicitConversions

object SkillClass extends Enumeration {
    type SkillClass = Value

    val

    mine,
    forest,
    meadow,

    weapon,
    armor,
    jewelry,
    alchemy,

    swords,
    daggers,
    axes,
    hands


    = Value

   implicit def getSkillForMine(mineType: MineType): SkillClass ={
        mineType match {
            case MineType.MINE => mine
            case MineType.FOREST => forest
            case MineType.MEADOW => meadow
        }
    }
}

