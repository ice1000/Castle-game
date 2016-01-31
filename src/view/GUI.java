package view;

import castle.Game;
import util.Echoer;
import util.MessageHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * 视图
 * Created by asus1 on 2016/1/31.
 */
public class GUI extends Game
		implements Echoer {

	private JTextField textField;
	private JTextArea textArea;
	private JFrame frame;

	public GUI() {
		frame = new JFrame("城堡游戏   by 千里冰封");
		textField = new JTextField("在这里输入指令");
		textField.registerKeyboardAction(e -> {
					HandleMessage(textField.getText());
					textField.setText("");
				},
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
				JComponent.WHEN_FOCUSED
		);
		textArea = new JTextArea();
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage(
				"." + File.separator + "drawable" + File.separator + "ic_launcher.png"
		));
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(textField, BorderLayout.SOUTH);
		frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GUI game = new GUI();
		game.onStart();
	}

	@Override
	public void echo(String words){
//		System.out.print(words);
		textArea.append(words);
		int i = textArea.getText().length();
		int MAX_LENGTH = 10000;
		if(i > MAX_LENGTH){
			textArea.setText(textArea.getText().substring(
					i - MAX_LENGTH, i
			));
		}
	}

	@Override
	public void echoln(String words){
		echo(words + "\n");
	}

	@Override
	public void closeScreen() {
		frame.dispose();
	}

}
