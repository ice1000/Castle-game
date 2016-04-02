package view

import castle.Game
import util.Echoer

import javax.swing.*
import java.awt.*
import java.awt.event.*
import java.io.File

/**
 * 视图
 * Created by asus1 on 2016/1/31.
 */
class GUI : Game(), Echoer {

    private val textField: JTextField
    private val textArea: JTextArea
    private val frame: JFrame
    private val scrollPane: JScrollPane
    private val scrollBar: JScrollBar

    init {
        frame = JFrame("城堡游戏   by 千里冰封")
        textField = JTextField("在这里输入指令")
        textField.registerKeyboardAction({ e ->
            HandleMessage(textField.text)
            textField.text = ""
        },
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED)
        textArea = JTextArea()
        textArea.addMouseListener(object : MouseListener {
            override fun mouseClicked(e: MouseEvent) {
            }
            override fun mousePressed(e: MouseEvent) {
            }
            override fun mouseReleased(e: MouseEvent) {
            }
            override fun mouseEntered(e: MouseEvent) {
            }
            override fun mouseExited(e: MouseEvent) {
            }
        })
        textArea.background = Color(12, 29, 39)
        textArea.foreground = Color(203, 212, 188)
        textArea.isEditable = false
        frame.iconImage = Toolkit.getDefaultToolkit().createImage(
                "." + File.separator + "src" + File.separator + "drawable" + File.separator + "ic_launcher.png")
        frame.setSize(FRAME_X, FRAME_Y)
        // 绝对布局
        // frame.setLayout(null);
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.add(textField, BorderLayout.SOUTH)
        scrollPane = JScrollPane(textArea)
        scrollBar = scrollPane.verticalScrollBar
        frame.add(scrollPane, BorderLayout.CENTER)
        frame.isResizable = false
        frame.setLocation(FRAME_X / 8, FRAME_Y / 8)
        frame.isVisible = true
    }

    override fun echo(words: String) {
        //		System.out.print(words);
        textArea.append(words)
        val i = textArea.text.length
        val MAX_LENGTH = 10000
        if (i > MAX_LENGTH) {
            textArea.text = textArea.text.substring(
                    i - MAX_LENGTH, i)
        }
        //		scrollBar.setValue(scrollBar.getMaximum() - 20);
        // 滚动到最底下
        val height = 10
        val p = Point()
        p.setLocation(0, this.textArea.lineCount * height)
        this.scrollPane.viewport.viewPosition = p
    }

    override fun echoln(words: String) {
        echo(words + "\n")
    }

    override fun closeScreen() {
        frame.dispose()
    }

    companion object {

        private val FRAME_X = 500
        private val FRAME_Y = 500

		@JvmStatic fun main(args: Array<String>) {
            val game = GUI()
            game.onStart()
        }
    }

}
