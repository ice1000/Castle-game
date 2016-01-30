package funcs;

import castle.Game;

public class FuncSleep extends FuncSrc {

	public FuncSleep(Game game) {
		super(game);
	}

	public FuncSleep() {}

	@Override
	public void DoFunc(String cmd) {
//		int bloodMore = Integer.parseInt(cmd);
		if( game.TreatRoomCheck() ){
			if( !game.isBossGetItem() ){
				game.echo("女仆顺从地送你进入梦乡。睡觉中");
				for(int i = 0; i < 8; i ++ ) {
					SleepTime(50);
				}
				game.echo("\n已经睡觉，体力");
				if( game.Treat() )
					game.echoln("恢复至120.");
				else
					game.echoln("超过120不用恢复的~");
			}
			else
				game.echoln("睡觉需要女仆服侍，然而她看起来不大愿意啊。。。");
		}
		else
			game.echoln("只有宾馆或卧室能睡觉。");
	}

	public void SleepTime(int time) {
		try{
			Thread.currentThread();
			Thread.sleep(time);
		}
		catch(Exception e){}
		game.echo("。");
	}

}
