package util

/**
 * 命名器
 * Created by asus1 on 2016/1/29.
 */
class NameGenerator {
    companion object {
        private val names = arrayOf("金木研", "赤羽业", "泉新一", "千里冰封", "奶茶", "3A", "无", "SpiderKing", "Direction.D.", "Timothy")

        fun generate(): String {
            val i = Math.random()
            return names[(names.size * i).toInt()]
        }
    }
}
