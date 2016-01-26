package funcs;

import castle.Game;

public class FuncSleep extends Funcsrc {

	public FuncSleep(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public FuncSleep() {}

	@Override
	public void DoFunc(String cmd) {
		// TODO Auto-generated method stub
//		int bloodMore = Integer.parseInt(cmd);
		if( game.TreatRoomCheck() ){
			if( !game.BossGetItem() ){
				System.out.print("女仆顺从地送你进入梦乡。睡觉中");
			    for(int i = 0; i < 8; i ++ ) {
			    	SleepTime(50);
			    }
			    System.out.print("\n已经睡觉，体力");
				if( game.Treat() )
					System.out.println("恢复至120.");
				else
					System.out.println("超过120不用恢复的~");
			}
			else
				System.out.println("睡觉需要女仆服侍，然而她看起来不大愿意啊。。。");
		}
		else
			System.out.println("只有宾馆或卧室能睡觉。");
	}
	
	public void SleepTime(int time) {
		try{   
		    Thread.currentThread();
			Thread.sleep(time);  
	    }  
	    catch(Exception e){}
		System.out.print("。");
	}

}
