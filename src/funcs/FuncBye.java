package funcs;

import castle.Game;

public class FuncBye extends Funcsrc {
	
	public FuncBye(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
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
