package ru.megains.ilos.network.packet.client.data

class ChatObject() {
    var userName: String =_
    var message: String =_

    def this(userName: String, message: String){
        this()
        this.userName = userName
        this.message = message
    }

    def getUserName: String = userName

    def setUserName(userName: String): Unit = {
        this.userName = userName
    }

    def getMessage: String = message

    def setMessage(message: String): Unit = {
        this.message = message
    }


    override def toString = s"ChatObject($userName, $message)"
}
