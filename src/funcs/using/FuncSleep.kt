package funcs.using

import castle.Game
import funcs.FuncSrc

class FuncSleep : FuncSrc {

    constructor(game: Game) : super(game) {
    }

    constructor() {
    }

    override fun DoFunc(cmd: String) {
        //		int bloodMore = Integer.parseInt(cmd);
        if (game.map.currentRoom.toString().matches("宾馆|卧室".toRegex())) {
            if (!game.map.currentRoom.isBossGetItem) {
                game.echo("女仆顺从地送你进入梦乡。睡觉中")
                for (i in 0..7) {
                    try {
                        Thread.sleep(50)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
                game.echo("\n已经睡觉，体力")
                if (game.player.treat())
                    game.echoln("恢复至120.")
                else
                    game.echoln("超过120不用恢复的~")
            } else
                game.echoln("睡觉需要女仆服侍，然而她看起来不大愿意啊。。。")
        } else
            game.echoln("只有宾馆或卧室能睡觉。")
    }

}
