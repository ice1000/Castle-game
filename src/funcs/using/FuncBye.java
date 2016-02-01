package funcs.using;

import castle.Game;
import funcs.FuncSrc;

public class FuncBye extends FuncSrc {
	
	public FuncBye(Game game) {
		super(game);
	}

	private boolean Bye() {
		return true;
	}

	@Override
	public void DoFunc(String cmd) {
		game.saveData();
		Bye();
	}

}
