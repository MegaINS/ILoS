package ru.megains.ilos

import com.corundumstudio.socketio.{Configuration, SocketIOServer}
import ru.megains.ilos.db.dao.DaoFactory
import ru.megains.ilos.db.daoquill.QuillDaoFactory
import ru.megains.ilos.network.packet.client.data.{ChatObject, PacketDataAction, PacketDataInventoryAction}
import ru.megains.ilos.network.packet.client.{PacketAction, PacketChatEvent, PacketConnect, PacketInventoryAction}
import ru.megains.ilos.utils.Logger

class IloSServer(config:Configuration) extends Logger[IloSServer]{


    val socketServer = new SocketIOServer(config)
    var daoFactory:DaoFactory = QuillDaoFactory
    var isActive = true
    var playerList:PlayerList = new PlayerList(this)
    var gameLogicHandler:GameLogicHandler  = new GameLogicHandler(this)
    val timer: Timer = new Timer(10)

    def start(): Unit = {

        log.info("Start IloSServer")
        daoFactory.installDao()

        log.info("Start GameLogicHandler")

        gameLogicHandler.start()
        log.info("Start NetworkSystem")



        socketServer.addConnectListener(new PacketConnect(this))

        socketServer.addEventListener("action", classOf[PacketDataAction], new PacketAction(this))

        socketServer.addEventListener("chatevent", classOf[ChatObject], new PacketChatEvent(this))

        socketServer.addEventListener("inventoryAction", classOf[PacketDataInventoryAction], new PacketInventoryAction(this))


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
