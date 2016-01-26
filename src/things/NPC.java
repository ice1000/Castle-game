package things;

import java.util.ArrayList;

public class NPC extends Cell {

	private String chat = "";
	private ArrayList<Item> items = new ArrayList<Item>();

	public NPC(String name,String chat) {
		super(name);
		this.chat = chat;
	}


	public void Itemget(String name,int num){
		items.add(new Item(name));
	}

//	public void Itemgive(int index,int num){
//		items.get(index).getNumOf(num);
//	}

	public void Talk(){
		System.out.println(chat);
	}

}
