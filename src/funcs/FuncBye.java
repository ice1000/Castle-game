package funcs;

import castle.Game;

public class FuncBye extends FuncSrc {
	
	public FuncBye(Game game) {
		super(game);
	}

	public boolean Bye() {
		isGameEnded = true;
		return isGameEnded;
	}

	@Override
	public void DoFunc(String cmd) {
		game.saveData();
		Bye();
	}

}
