package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncSave(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        game.saveData()
    }

}
