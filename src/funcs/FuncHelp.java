package funcs;

import castle.Game;

public class FuncHelp extends FuncSrc {

	public FuncHelp(Game game) {
		super(game);
	}

	@Override
	public void DoFunc(String cmd) {
		System.out.println("迷路了吗？你可以做的命令有：");
		String[] strings = game.getFuncs();
		for(String s : strings){
			System.out.println(s);
		}
		System.out.println("如：go east");
	}
}
