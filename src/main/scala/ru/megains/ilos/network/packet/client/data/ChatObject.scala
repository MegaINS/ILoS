package ru.megains.ilos.network.packet.client.data

import scala.beans.BeanProperty

class ChatObject() {
    @BeanProperty var userName: String = _
    @BeanProperty var message: String = _
    def this(userNameIn: String, messageIn: String ){
        this()
        userName = userNameIn
        message = messageIn
    }

    override def toString = s"ChatObject($userName, $message)"
}
