package funcs.using

import castle.Game
import cells.NPC
import funcs.FuncSrc

/**
 * 与NPC对话
 * Created by asus1 on 2016/1/30.
 */
class FuncTalk(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        val npc = game.map.currentRoom.isNPCExists(cmd)
        if (npc != null) {
            game.echoln(npc.chat)
        } else {
            game.echoln("你指定的名字不存在。注：Boss要在被打败之后才能对话。")
        }
    }
}
