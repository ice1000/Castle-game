package cells

import util.Echoer

open class Player//	在玩家中，经验表示拥有的经验，在怪物中表示打败后得到的经验。
(name: String, blood: Int, strike: Int, defence: Int) : Cell(name) {

    var blood = 0
        internal set
    var strike = 0
        internal set
    var defence = 0
        internal set
    var level = 0
        private set
    var experience = 0
        internal set
    private val limit = intArrayOf(5, 10, 30, 50, 80, 120, 160, 200, 250, 320, 400, 480, 560, 640, 720, 800, 900, 1000, 1120, 1240, 1380, 1520, 1680, 1840, 2000, 2200, 2400, 2600, 2800, 3200, 3600, 4000, 99999999, 99999999)

    init {
        this.blood = blood
        this.strike = strike
        this.defence = defence
    }

    fun setBlood(blood: Int){
        this.blood = blood
    }
    //	public Player(){
    //		database = new Database();
    //		loadState();
    //	}

    fun setValues(name: String, blood: Int, strike: Int, defence: Int, level: Int, experience: Int) {
        this.name = name
        this.blood = blood
        this.strike = strike
        this.defence = defence
        this.level = level
        this.experience = experience
    }

    fun stateToString(): String {
        return "等级：" + (level + 1) +
                "\n经验值：" + experience +
                "/" + limit[level] +
                "\n姓名：" + name +
                "\n攻击：" + strike +
                "\n防御：" + defence +
                "\n体力值：" + blood
    }

    override fun toString(): String {
        return super.name
    }

    internal fun win(experience: Int, echoer: Echoer): Int {
        this.experience += experience
        if (this.experience >= limit[level]) {
            this.experience -= limit[level]
            level++
            strike += level * 2
            defence += level * 2
            blood += level * 20
            echoer.echoln("恭喜您升级啦~\\(≧▽≦)/~啦啦啦\n各种属性加成哦~")
        }
        return experience
    }

    fun treat(): Boolean {
        if (blood <= 120) {
            blood = 120
            return true
        } else
            return false
    }

    fun rename(newName: String) {
        this.name = newName
    }

    //	public void saveState(){
    //		database.saveState(
    //				this.name + "\r\n" +
    //				this.blood + "\r\n" +
    //				this.strike + "\r\n" +
    //				this.defence + "\r\n" +
    //				this.level + "\r\n" +
    //				this.experience + "\r\n"
    //		);
    //	}

}
