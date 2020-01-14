package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PGroup(@BeanProperty val name: String,
             @BeanProperty val src: String,
             @BeanProperty val types: Array[PType]) {

}
