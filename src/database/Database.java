package database;

import cells.Player;
import map.Room;

import java.io.*;

/**
 * 封装数据库操作
 * Created by asus1 on 2016/1/28.
 */
public class Database {
	private static final String savePath = "."+ File.separator+"save.ice";
	private String playerName;
	private int blood = 0;
	private int strike = 0;
	private int defence = 0;
	private int level = 0;
	private int experience = 0;
	
	public Database() {
		File file = new File(savePath);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));

			playerName = reader.readLine();
			blood      =  Integer.parseInt(reader.readLine());
			strike     =  Integer.parseInt(reader.readLine());
			defence    =  Integer.parseInt(reader.readLine());
			level      =  Integer.parseInt(reader.readLine());
			experience =  Integer.parseInt(reader.readLine());

			reader.close();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public String getRoom(String defaultName){
		File file = new File(savePath);
		String roomName;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			roomName = reader.readLine();

		} catch (IOException e) {
			// e.printStackTrace();
			roomName = defaultName;
		}
		return roomName;
	}

	public void saveRoom(String currentRoomName) throws IOException {
		File file = new File(savePath);
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(currentRoomName);
		writer.close();

	}

	public boolean loadState(Player player){
		BufferedReader reader;
		File file1 = new File(savePath);
		try {
			if(!file1.exists())
				return false;

			reader = new BufferedReader(new FileReader(file1));

			playerName = reader.readLine();
			blood      =  Integer.parseInt(reader.readLine());
			strike     =  Integer.parseInt(reader.readLine());
			defence    =  Integer.parseInt(reader.readLine());
			level      =  Integer.parseInt(reader.readLine());
			experience =  Integer.parseInt(reader.readLine());
			
			player.setValues(
					playerName,
					blood,
					strike,
					defence,
					level,
					experience
			);

			reader.close();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	public void saveState(String data) throws IOException {
//		System.out.println("正在保存数据。。");
		File file = new File(savePath);
		BufferedWriter writer;
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		writer = new BufferedWriter(new FileWriter(file));

		writer.write(data);

		writer.close();
	}

	public static boolean isFileExists(){
		return new File(savePath).exists();
	}
}
