package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PItem(@BeanProperty val id:Int,
            @BeanProperty val name:String,
            @BeanProperty val amount:Int,
            @BeanProperty val itemClass:Int,
            @BeanProperty val weight:Int,
            @BeanProperty val scr:String) {


}
