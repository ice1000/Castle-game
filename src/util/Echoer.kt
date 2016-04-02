package util

/**
 * 用于传递echo方法，控制反转
 * Created by asus1 on 2016/1/29.
 */
interface Echoer {
    fun echo(words: String)
    fun echoln(words: String)
    fun closeScreen()
}
