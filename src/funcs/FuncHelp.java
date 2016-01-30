package funcs;

import castle.Game;

public class FuncHelp extends FuncSrc {

	public FuncHelp(Game game) {
		super(game);
	}

	@Override
	public void DoFunc(String cmd) {
		game.echoln("迷路了吗？你可以做的命令有：");
		String[] strings = game.getFuncs();
		for(String s : strings){
			game.echoln(s);
		}
		game.echoln("如：go east");
	}
}
