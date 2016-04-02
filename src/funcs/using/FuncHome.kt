package funcs.using

import castle.Game
import funcs.FuncSrc

/**
 * 回城堡
 * Created by asus1 on 2016/2/1.
 */
class FuncHome(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        game.echoln("您与女仆的契约发动。回到了旅馆。")
        game.map.currentRoom = game.map.home
        game.echoln(game.map.currentRoom.prompt)
    }
}
