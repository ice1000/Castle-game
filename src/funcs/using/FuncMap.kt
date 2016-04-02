package funcs.using

import castle.Game
import funcs.FuncSrc

import javax.swing.*
import java.awt.*
import java.io.File

/**
 * 显示地图
 * Created by asus1 on 2016/2/1.
 */
class FuncMap(game: Game) : FuncSrc(game) {

    override fun DoFunc(cmd: String) {
        val frame = JFrame("地图")
        val panel = JPanel()
        val label = JLabel()
        val image = Toolkit.getDefaultToolkit().getImage(
                "." + File.separator + "drawable" + File.separator + "map.png")
        val icon = ImageIcon(image)
        label.icon = icon
        frame.setSize(icon.iconWidth, icon.iconHeight)
        panel.add(label)
        frame.contentPane = panel
        frame.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        frame.isVisible = true
    }
}
