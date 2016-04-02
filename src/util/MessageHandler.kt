package util

/**
 * 消息处理器接口
 * Created by asus1 on 2016/1/31.
 */
interface MessageHandler {
    fun HandleMessage(msg: String): Boolean
}
