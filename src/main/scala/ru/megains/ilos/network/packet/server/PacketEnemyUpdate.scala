package ru.megains.ilos.network.packet.server

import ru.megains.ilos.Action.Action
import ru.megains.ilos.network.packet.server.data.PEnemyUpdate
import ru.megains.ilos.player.Player

class PacketEnemyUpdate(action:Action, player:Player) extends Packet{

    override val name: String = "enemyUpdate"
    override val data: AnyRef = {

        new PEnemyUpdate(action,player.id,player.posX,player.posY)
    }
}

