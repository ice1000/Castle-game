package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncWild(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        // 传送
        game.WildRoom()
    }

}
