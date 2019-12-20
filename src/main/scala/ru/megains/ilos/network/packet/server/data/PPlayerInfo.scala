package ru.megains.ilos.network.packet.server.data


import ru.megains.ilos.player.Player

import scala.beans.BeanProperty


class PPlayerInfo(player: Player) {

    @BeanProperty val name: String = player.name

    @BeanProperty val level: Int = player.level

    @BeanProperty val health: Int = player.health
    @BeanProperty val healthMax: Int = player.healthMax

    @BeanProperty val energy: Int = player.energy
    @BeanProperty val energyMax: Int = player.energyMax

    @BeanProperty val money: Float = player.money

    @BeanProperty val power: Int = player.power
    @BeanProperty val intellect: Int = player.intellect
    @BeanProperty val concentration: Int = player.concentration
    @BeanProperty val stamina: Int = player.stamina







}
