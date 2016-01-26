package things;

public class Item {
	private String name = "";
	private boolean get = false;
	
	public Item(String name) {
		super();
		this.name = name;
	}

//	public void getNumOf(int num) {
//		this.num -= num;
//	}

	public void get() {
		get = true;
	}
	
	public boolean check() {
		return get;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	
}
