package view;

/**
 * Created by asus1 on 2016/4/9.
 *
 */
public class CUIRunner extends CUI {
	public static void main(String[] args) {
		CUI game = new CUI();
		game.onStart();
		game.onResume();
	}
}
