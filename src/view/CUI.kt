package view

import castle.Game

import java.util.Scanner

/**
 * 这个是针对没有GUI的OS的CUI版
 * Created by asus1 on 2016/1/31.
 */
open class CUI constructor() : Game() {

    override fun echo(words: String) {
        print(words)
    }

    override fun echoln(words: String) {
        echo(words + '\n')
    }

    override fun closeScreen() {
        System.exit(0)
    }

    protected fun onResume() {
        var line: String
        var loop = true
        val `in` = Scanner(System.`in`)
        while (loop) {
            echoln("")
            line = `in`.nextLine()
            loop = HandleMessage(line)
        }
        `in`.close()
    }

}
