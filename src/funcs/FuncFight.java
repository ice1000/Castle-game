package funcs;

import castle.Game;

public class FuncFight extends FuncSrc {
	
	public FuncFight(Game game) {
		super(game);
	}

	@Override
	public void DoFunc(String cmd) {
		game.Fight();
	}

}
