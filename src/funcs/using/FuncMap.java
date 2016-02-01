package funcs.using;

import castle.Game;
import funcs.FuncSrc;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 显示地图
 * Created by asus1 on 2016/2/1.
 */
public class FuncMap extends FuncSrc{

	public FuncMap(Game game) {
		super(game);
	}

	@Override
	public void DoFunc(String cmd) {
//		.
		JFrame frame = new JFrame("地图");
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
//				ImageIcon icon = new ImageIcon("." + File.separator + "drawable" + File.separator + "map.png");
				ImageIcon icon = new ImageIcon("C:\\Users\\asus1\\Desktop\\城堡游戏\\drawable\\map.png");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(),
						icon.getIconHeight(), icon.getImageObserver());
				frame.setSize(icon.getIconWidth(), icon.getIconHeight());
			}
		};
		frame.add(panel);
	//	frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}
}
