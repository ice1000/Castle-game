package funcs;

import castle.Game;

/**
 * 重命名
 * Created by asus1 on 2016/1/29.
 */
public class FuncRename extends FuncSrc{

	public FuncRename(Game game) {
		super(game);
	}

	@Override
	public void DoFunc(String cmd) {
		game.echoln("请问您的新名字是？");
		game.rename();
	}

}
