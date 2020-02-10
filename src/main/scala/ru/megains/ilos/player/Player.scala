package ru.megains.ilos.player

import com.corundumstudio.socketio.SocketIOClient
import ru.megains.ilos.inventory.PlayerInventory
import ru.megains.ilos.network.packet.server._
import ru.megains.ilos.utils.Logger
import ru.megains.ilos.world.location.Location


class Player(val id: Int, val name: String) extends Logger[Player] {




    var client: SocketIOClient = _

    var x = 4
    var y = 4



    var level: Int = 10

    var health:Int = 1
    var healthMax:Int = 50
    var energy:Int = 1
    var energyMax:Int = 100
    var workDamage = 10


    var power = 11
    var intellect = 22
    var concentration = 33
    var stamina = 44
    var money:Float = 56.5f

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
