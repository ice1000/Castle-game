package util;

/**
 * 字符串枚举
 * Created by asus1 on 2016/1/27.
 */
public enum  S {

	UP("up"),
	DOWN("down"),
	EAST("east"),
	WEST("west"),
	NORTH("north"),
	SOUTH("south")
	;

	String s;
	S(String s){
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}
}
