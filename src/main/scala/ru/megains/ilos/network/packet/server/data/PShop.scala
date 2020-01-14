package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PShop(@BeanProperty val name:String,
            @BeanProperty val groups:Array[PGroup]) {

}
