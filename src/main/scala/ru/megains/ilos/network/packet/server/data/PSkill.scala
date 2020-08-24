package ru.megains.ilos.network.packet.server.data

import scala.beans.BeanProperty

class PSkill(@BeanProperty val name:String,
             @BeanProperty val exp:Int,
             @BeanProperty val expMax:Int,
             @BeanProperty val level:Int,
             @BeanProperty val skillType:String) {

}
