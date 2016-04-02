package cells

import java.util.ArrayList

class NPC(name: String, chat: String) : Cell(name) {

    //	public void itemGive(int index,int num){
    //		items.get(index).getNumOf(num);
    //	}

    var chat = ""
    private val items = ArrayList<Item>()

    init {
        this.chat = chat
    }

    fun itemGet(name: String, num: Int) {
        items.add(Item(name, num))
    }
}
