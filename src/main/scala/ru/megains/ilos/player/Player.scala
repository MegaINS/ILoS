package ru.megains.ilos.player

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.inventory.PlayerInventory
import ru.megains.ilos.network.packet.server._
import ru.megains.ilos.utils.Logger
import ru.megains.ilos.world.location.Location


class Player(val id: Int, val name: String) extends Logger[Player] {



    var client: SocketIOClient = _

    var posX = 0
    var posY = 0
    var level: Int = 0
    var health:Int = 0
    var healthMax:Int = 0
    var energy:Int =0
    var energyMax:Int = 0
    var fightMaxDamage:Int = 0
    var fightMinDamage:Int = 0
    var workMaxDamage:Int = 0
    var workMinDamage:Int = 0
    var power:Int = 0
    var intellect:Int = 0
    var concentration:Int = 0
    var stamina:Int = 0
    var money:Float = 0f

    var location:Location = _


    var plannedAction: () => Unit = _
    var plannedActionTime:Double = _
    var plannedActionAvailable:Boolean = _
    var tick:Int = 0


    var inventory:PlayerInventory = new PlayerInventory(this)


    def update(time:Double): Unit ={
        if(plannedActionAvailable){
            if(time>plannedActionTime){
                activatePlannedAction()
            }
        }

        tick +=1
        if(tick == 10){
            tick = 0
            if(health<healthMax){
                health+=1
                if(health>healthMax){
                    health=healthMax
                }
                sendPacket(new PacketPlayerInfo(this))
            }
            if(energy<energyMax){
                energy+=2
                if(energy>energyMax){
                    energy=energyMax
                }
                sendPacket(new PacketPlayerInfo(this))
            }


        }




    }


    def activatePlannedAction(): Unit ={
        plannedAction()
        plannedAction = null
        plannedActionAvailable = false
    }


    def setPlannedAction(action: () => Unit,time:Double): Unit = {
        plannedAction = action
        plannedActionTime = time
        plannedActionAvailable = true
    }




    def sendPlayerInfo(): Unit ={
        sendPacket(new PacketPlayerInfo(this))
        sendPacket(new PacketPlayerInventory(this))
    }


    def sendPacket(packet: Packet): Unit = {
        if(client!= null) client.sendEvent(packet.name, packet.data)
    }

    def sendData(): Unit ={
        location.sendData(this)
        location.sendPlayerList(this)
    }

}
