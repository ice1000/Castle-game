package funcs;

import castle.Game;

public class FuncState extends FuncSrc {
	
	public FuncState(Game game) {
		super(game);
	}

	@Override
	public void DoFunc(String cmd) {
		game.echo(game.playerToString());
	}

}
