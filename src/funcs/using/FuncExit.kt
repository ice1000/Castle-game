package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncExit(game: Game) : FuncSrc(game) {

    private fun Bye(): Boolean {
        isGameEnded = true
        return true
    }

    override fun DoFunc(cmd: String) {
        game.saveData()
        Bye()
    }

}
