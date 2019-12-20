package ru.megains.ilos

import com.corundumstudio.socketio.{Configuration, SocketIOServer}
import ru.megains.ilos.item.Items
import ru.megains.ilos.network.packet.client.data.{ChatObject, PacketDataAction}
import ru.megains.ilos.network.packet.client.{PacketAction, PacketChatEvent, PacketConnect}
import ru.megains.ilos.utils.Logger
import ru.megains.ilos.world.location.Locations
import ru.megains.ilos.world.warp.Warps

class IloSServer(config:Configuration) extends Logger[IloSServer]{


    val socketServer = new SocketIOServer(config)

    var isActive = true
    var playerList:PlayerList = new PlayerList(this)
    var gameLogicHandler:GameLogicHandler  = new GameLogicHandler(this)
    val timer: Timer = new Timer(10)

    def start(): Unit = {

        log.info("Start IloSServer")
        log.info("Load Items")
        Items.load()

        log.info("Load Warps")
        Warps.load()
        log.info("Load Locations")
        Locations.load()

        log.info("Start GameLogicHandler")
        gameLogicHandler.start()
        log.info("Start NetworkSystem")

        socketServer.addConnectListener(new PacketConnect(this))

        socketServer.addEventListener("action", classOf[PacketDataAction], new PacketAction(this))

        socketServer.addEventListener("chatevent", classOf[ChatObject], new PacketChatEvent(this))

        socketServer.start()




        log.info("Timer init...")
        timer.init()


        log.info("Server started")

        run()
    }



    def run(): Unit = {
        while (isActive) {



            timer.update()


            for (_ <- 0 until timer.tick) {
                update(timer.currentTime)

            }

            Thread.sleep(50)
        }

    }

    def update(currentTime:Double): Unit ={
        playerList.update(currentTime)
    }

    def stop(): Unit ={
        socketServer.stop()
    }


}
