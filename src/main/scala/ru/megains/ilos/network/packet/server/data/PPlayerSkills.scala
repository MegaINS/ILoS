package ru.megains.ilos.network.packet.server.data

import ru.megains.ilos.player.Player

class PPlayerSkills(player:Player) {

    def getSkills:Array[PSkill] = player.skills.skillsMap.values.map(s=>new PSkill(s.name,s.exp,s.expMax,s.level,s.skillType.toString())).toArray
}
