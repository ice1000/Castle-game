package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncHelp(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        game.echoln("迷路了吗？你可以做的命令有：")
        val strings = game.funcs
        for (s in strings) {
            game.echoln(s)
        }
        game.echoln("有些需要参数的命令请按如下格式输入：")
        game.echoln("命令 [参数]")
        game.echoln("如：go east")
        game.echoln("如：rename 冰封")
    }
}
