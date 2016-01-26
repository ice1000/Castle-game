package funcs;

import castle.Game;

public abstract class Funcsrc {
	
	protected Game game;
	protected boolean isGameEnded = false;
	
	public Funcsrc(Game game) {
		this.game = game;
	}
	
	protected Funcsrc(){
	};
	
	public boolean isGameEnded() {
		return isGameEnded;
	}

	public abstract void DoFunc(String cmd);

}
