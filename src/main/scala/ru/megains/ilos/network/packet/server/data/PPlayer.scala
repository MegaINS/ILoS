package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PPlayer( @BeanProperty val id:Int,
               @BeanProperty val name:String,
               @BeanProperty val level:Int) {

}
