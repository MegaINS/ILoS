package ru.megains.ilos.db.dto

case class PlayerDto(id: Int,
                     posX: Int,
                     posY: Int,
                     level: Int,
                     health: Int,
                     healthMax: Int,
                     energy: Int,
                     energyMax: Int,
                     fightMaxDamage: Int,
                     fightMinDamage: Int,
                     workMaxDamage: Int,
                     workMinDamage: Int,
                     power: Int,
                     intellect: Int,
                     concentration: Int,
                     stamina: Int,
                     money: Float,
                     location: Int)


