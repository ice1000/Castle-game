package cells

import funcs.using.FuncSleep
import util.Echoer

//import java.util.Scanner;

class Boss(name: String, blood: Int, strike: Int, defence: Int, experience: Int) : Player(name, blood, strike, defence) {
    //	和玩家一样，有血、攻防
    private var dieText = ""
    private var survive = true
    private var getItem = true

    constructor(name: String, blood: Int, strike: Int, defence: Int, experience: Int, dieText: String) : this(name, blood, strike, defence, experience) {
        this.dieText = dieText
    }

    init {
        this.experience = experience
        dieText = name + "跪着向你哀求，不过你残忍地！"
    }

    fun fight(player: Player, echoer: Echoer): Player {

        val stringBuffer = StringBuilder()
        val bloodSave = this.blood
        var bloodSave2 = player.blood
        var beBeat = this.strike - player.defence
        val Beat = player.strike - this.defence

        if (beBeat <= 0)
            beBeat = 0
        //			打不过
        if (Beat <= 0) {
            player.setBlood(player.blood - 10)
            stringBuffer.append("你的攻击力小于").append(this.name).append("的防御力！\n落荒而逃！损失10点体力值！\n")
        } else {
            while (survive) {
                //					互相扣血
                this.setBlood(this.blood - Beat)
                player.setBlood(player.blood - beBeat)
                //					判断
                if (player.blood <= 0) {

                    bloodSave2 -= 5
                    player.setBlood(bloodSave2)

                    this.setBlood(bloodSave)
                    stringBuffer.append("以你现有的体力值无法打倒").append(this.name).append("！\n落荒而逃！损失5点体力值！\n")
                    break
                }
                if (this.blood <= 0) {
                    //						先把血补回去
                    this.setBlood(bloodSave)
                    stringBuffer.append(dieText).append("\n胜利而归！你还剩").append(player.blood).append("点体力值！\n").append("本次战斗获得了").append(player.win(experience, echoer)).append("点经验值！\n")
                    survive = false
                    getItem = false
                    stringBuffer.append("战斗结束")
                    stringBuffer.append("\n")
                }
            }
        }
        echoer.echo(stringBuffer.toString())
        survive = true
        return player
    }

    override fun toString(): String {
        return super.name
    }

    fun ifGet(): Boolean {
        return getItem
    }

    fun setGetItem(getItem: Boolean) {
        this.getItem = getItem
    }

    fun getExperience(echoer: Echoer): Int {
        if (getItem) {
            echoer.echoln("Boss挑战成功，获得挑战奖励和额外5点经验奖励！")
            return this.experience + 5
        } else
            return this.experience
    }

    fun toNPC(chat: String): NPC {
        return NPC(name, chat)
    }
}
