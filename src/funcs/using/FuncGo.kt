package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncGo(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        // 调用移动。
        game.goRoom(cmd)
    }

}
