package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PType(@BeanProperty val name: String,
            @BeanProperty val src: String,
            @BeanProperty val items: Array[PItem]) {

}
