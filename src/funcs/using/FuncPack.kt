package funcs.using

import castle.Game
import cells.Item
import funcs.FuncSrc

class FuncPack(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        game.echoln("背包中物品如下：")
        for (item in game.theItems) {
            game.echoln(item.toString())
        }
    }

}
