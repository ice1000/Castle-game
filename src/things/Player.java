package things;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Player extends Cell {
	
	public int blood = 0;
	protected int strike = 0;
	protected int miss = 0;
	private int level = 0;
	protected int experience = 0;
	protected int[] limit = {
			5,
			10,
			30,
			50,
			80,
			120,
			160,
			200,
			250,
			320,
			400,
			480,
			560,
			640,
			720,
			800,
			900,
			1000,
			99999999,
	};
	private static String fileName = "";
	private static File file;
	
//	在玩家中，经验表示拥有的经验，在怪物中表示打败后得到的经验。
	public Player(String name, int blood, int strike, int miss) {
		super(name);
		this.blood = blood;
		this.strike = strike;
		this.miss = miss;
	}
	
	public Player(){
		loadState();
	}

	public int getStrike() {
		return strike;
	}
	
	public int getMiss() {
		return miss;
	}

	public static void setFileName(String fileName) {
		Player.fileName = fileName;
		file = new File(fileName);
	}

	public String stateToString() {
		return "等级：" + (level+1) +
				"\n经验值：" + experience +
				"/" + limit[level] +
				"\n姓名：" + name +
				"\n攻击：" + strike +
				"\n防御：" + miss +
				"\n体力值：" + blood;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public int win(int experience) {
		this.experience += experience;
		if( this.experience >= limit[level] ){
			this.experience -= limit[level];
			level ++;
			strike += level*2;
			miss += level*2;
			blood += level*20;
			System.out.println("恭喜您升级啦~\\(≧▽≦)/~啦啦啦\n各种属性加成哦~");
		}
		return experience;
	}
	
	public boolean treat(){
		if( blood <= 120 ){
    		blood = 120;
    		return true;
    	}
    	else
    		return false;
	}
	
	@SuppressWarnings("resource")
	public void loadState(){
		BufferedReader reader;
		try {
			if(!file.exists())
				return;
			
			reader = new BufferedReader(new FileReader(file));
			this.name = reader.readLine();
			this.blood = Integer.parseInt(reader.readLine());
			this.strike = Integer.parseInt(reader.readLine());
			this.miss = Integer.parseInt(reader.readLine());
			this.level = Integer.parseInt(reader.readLine());
			this.experience = Integer.parseInt(reader.readLine());; 
			
			reader.close();
		} catch (Exception e) {
			// e.printStackTrace();
			return ;
		}
	}

	public void saveState(){
		System.out.println("正在保存数据。。");
		BufferedWriter writer;
		try {
			if(file.exists()){
				file.delete();
			}
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));

			writer.write(name + "\r\n");
			
			writer.write(
					this.blood + "\r\n" +
					this.strike + "\r\n" +
					this.miss + "\r\n" +
					this.level + "\r\n" +
					this.experience + "\r\n" 
			);
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isFileExist(){
		return file.exists();
	}
}
