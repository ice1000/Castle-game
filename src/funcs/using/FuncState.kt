package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncState(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        game.echoln(game.player.stateToString())
    }

}
