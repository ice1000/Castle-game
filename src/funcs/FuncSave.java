package funcs;

import castle.Game;

public class FuncSave extends Funcsrc{

	public FuncSave(Game game) {
		super(game);
	}
	
	@Override
	public void DoFunc(String cmd) {
		game.saveData();
	}

}
