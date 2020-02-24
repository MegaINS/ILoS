package ru.megains.ilos.network.packet.server

import ru.megains.ilos.Action.Action
import ru.megains.ilos.network.packet.server.data.PPlayerSpawn
import ru.megains.ilos.player.Player

class PacketPlayerUpdate(action:Action,player:Player) extends Packet{

    override val name: String = "playerUpdate"
    override val data: AnyRef = {

        new PPlayerSpawn(action,player.posX,player.posY)
    }
}
