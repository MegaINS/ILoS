package ru.megains.ilos

import com.corundumstudio.socketio.Configuration

object Main extends App {

    val config = new Configuration
    config.setHostname("localhost")
    config.setPort(9040)
    val iloSServer = new IloSServer(config)
    iloSServer.start()


}
