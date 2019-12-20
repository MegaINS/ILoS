package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PResource(@BeanProperty val scr:String,
                @BeanProperty val amount:Int,
                @BeanProperty val x:Int,
                @BeanProperty val y:Int) {

}
