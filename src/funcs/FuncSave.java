package funcs;

import castle.Game;

public class FuncSave extends FuncSrc {

	public FuncSave(Game game) {
		super(game);
	}
	
	@Override
	public void DoFunc(String cmd) {
		game.saveData();
	}

}
