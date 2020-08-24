package ru.megains.ilos.player

import ru.megains.ilos.player.SkillType.SkillType

class Skill(val name:String,var level:Int,var exp:Int,var expMax:Int,val skillType:SkillType) {

    def addPoints(i: Int): Unit = {
        exp += i
        if(exp>=expMax){
            exp = 0
            expMax *= 2
            level += 1
        }
    }

}
