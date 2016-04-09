package cells

class Item {
    private var name = ""
    private var get = false
    private var num = 1

    constructor(name: String) : super() {
        this.name = name
    }

    constructor(name: String, num: Int) {
        this.name = name
        this.num = num
    }

    //	public void getNumOf(int num) {
    //		this.num -= num;
    //	}

    fun get() {
        get = true
    }

    fun check(): Boolean {
        return get
    }

    @Override
    fun toString(): String {
        return name
    }

    fun setNum(num: Int) {
        this.num = num
    }
}
