package util

/**
 * 字符串枚举
 * Created by asus1 on 2016/1/27.
 */
enum class Direction private constructor(internal var s: String) {

    UP("up"),
    DOWN("down"),
    EAST("east"),
    WEST("west"),
    NORTH("north"),
    SOUTH("south");

    override fun toString(): String {
        return s
    }
}
