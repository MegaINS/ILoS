package ru.megains.ilos.player

import ru.megains.ilos.network.packet.client.data.ChatObject
import ru.megains.ilos.network.packet.server.{PacketChat, PacketPlayerSkills}
import ru.megains.ilos.player.SkillClass.SkillClass

import scala.collection.mutable

class Skills(player: Player) {


    def addSkillPoints(skillClass: SkillClass, i: Int): Unit = {

        skillsMap.get(skillClass) match {
            case Some(value) =>
                value.addPoints(i)
                player.sendPacket(new PacketChat(new ChatObject("Skill", s"Навык $skillClass повышен на $i")))
            case None =>
        }
        player.sendPacket(new PacketPlayerSkills(player))
    }


    val skillsMap: mutable.HashMap[SkillClass, Skill] = new mutable.HashMap[SkillClass, Skill]()


    skillsMap += SkillClass.daggers -> new Skill("Knife", 4, 10, 2646, SkillType.attack)
    skillsMap += SkillClass.axes -> new Skill("Axe", 1, 123, 150, SkillType.attack)

    skillsMap += SkillClass.weapon -> new Skill("Blacksmith", 12, 1356, 5020, SkillType.production)
    skillsMap += SkillClass.alchemy -> new Skill("Alchemist", 120, 1245, 2500, SkillType.production)


    def learnSkill(mine: SkillClass): Boolean = {
        skillsMap.get(mine) match {
            case Some(value) =>
                false
            case None =>
                mine match {
                    case SkillClass.mine =>
                        skillsMap += SkillClass.mine -> new Skill("Шахтер", 1, 0, 250, SkillType.mine)
                    case SkillClass.forest =>
                        skillsMap += SkillClass.forest -> new Skill("Дровосек", 1, 0, 250, SkillType.mine)
                    case SkillClass.meadow =>
                        skillsMap += SkillClass.meadow -> new Skill("Охотник", 1, 0, 250, SkillType.mine)
                    case SkillClass.weapon =>
                    case SkillClass.armor =>
                    case SkillClass.jewelry =>
                    case SkillClass.alchemy =>
                    case SkillClass.swords =>
                    case SkillClass.daggers =>
                    case SkillClass.axes =>
                    case SkillClass.hands =>
                }
                player.sendPacket(new PacketPlayerSkills(player))
                player.sendPacket(new PacketChat(new ChatObject("Skill", s"Навык $mine изучен!")))
                true
        }
    }

}
