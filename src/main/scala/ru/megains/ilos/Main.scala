package ru.megains.ilos

import com.corundumstudio.socketio.Configuration


object Main extends App {




//    case class Auth(id:Int,name:String,email:String,password:String,session:String)
//    val Players = quote(query[Auth])
//
//   println(run(Players))

    val config = new Configuration
    config.setHostname("localhost")
    config.setPort(9040)
    val iloSServer = new IloSServer(config)
    iloSServer.start()


}
