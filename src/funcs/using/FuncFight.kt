package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncFight(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        game.Fight()
    }

}
