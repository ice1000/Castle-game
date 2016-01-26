package funcs;

import castle.Game;

public class FuncFight extends Funcsrc {
	
	public FuncFight(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DoFunc(String cmd) {
		// 调用打怪函数。
		game.Fight();
	}

}
