package castle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import database.Database;
import funcs.*;
import cells.*;
import map.GameMap;

public class Game {

	private HashMap<String, FuncSrc> funcs = new HashMap<>();
	private String[] funcsString ;
	private GameMap map;
	private ArrayList<Item> theItems = new ArrayList<>();
	private Player player;
	private Database database;
//	public final String savePath_1 = "D:"+File.separator+"save"+File.separator+"player.ice";
//	public final String savePath_2 = "D:"+File.separator+"save"+File.separator+"envi.ice";

	//    构造方法
	public Game(){
		map = new GameMap();
		createItems();
		database = new Database();
		funcsString = new String[]{
				"help",
				"go",
				"wild",
				"exit",
				"state",
				//"pack",
				"fight",
				"sleep",
				"save"
		};

		funcs.put(funcsString[0], new FuncHelp(this));
		funcs.put(funcsString[1], new FuncGo(this));
		funcs.put(funcsString[2], new FuncWild(this));
		funcs.put(funcsString[3], new FuncBye(this));
		funcs.put(funcsString[4], new FuncState(this));
		funcs.put(funcsString[5], new FuncFight(this));
		funcs.put(funcsString[6], new FuncSleep(this));
		funcs.put(funcsString[7], new FuncSave(this));
//      funcs.put(funcsString[8], new FuncPack(this));

	}

	public String[] getFuncs(){
		return funcsString;
	}

	private void createItems() {
		Item wilder;
		theItems.add(wilder = new Item("传送门"));
	}

	private void printWelcome() {
		System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超复古的CUI游戏。");
        System.out.println("最新版本和源代码请见https://github.com/ice1000/Castle-game");
//        System.out.println("不过在经过了冰封的改造后，你会觉得这个很有意思。");
		if(!Database.isFileExists()){
			System.out.println("请键入你的名字：");
			Scanner name = new Scanner(System.in);
			player = new Player(name.nextLine(),200,10,5);
			saveData();
//	        name.close();
		}
		else {
			player = new Player(null,-1,-1,-1);
			database.loadState(player);
			map.loadRoom(database.loadMap(map,"宾馆"));
			System.out.println("检测到存档。");
		}
		System.out.println("你好"+player);
		System.out.println("如果需要帮助，请输入 '\\help' 。\n");
		System.out.print("现在");
		System.out.println(map.getCurrentRoomPrompt());
	}

	/**
	 * 到达
	 */
	public void goRoom(String direction){
		if(!map.goRoom(direction))
			System.out.println("没有这个出口。");
		System.out.println(map.getCurrentRoomPrompt());
	}
	/**
	 * 随机传送
	 */
	public void WildRoom(){
		System.out.println(map.wildRoom());
	}
	/**
	 * 战斗函数
	 */
	public void Fight() {
		map.fightBoss(this);
		System.out.println(map.getCurrentRoomPrompt());
	}
	public void setPlayer(Player player){
//    	减血赋值给原来的
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}
	/**
	 * 指定数量的补血
	 */
	public void Treat(int bloodMore) {
		player.blood += bloodMore;
	}
	/**
	 * 补血
	 */
	public boolean Treat() {
		return player.treat();
	}
	/**
	 * 检查是否可以睡觉
	 */
	public boolean TreatRoomCheck() {
		return map.treatRoomCheck();
	}
	/**
	 * 显示玩家数据
	 * @return 玩家数据
	 */
	public String playerToString() {
		return player.stateToString();
//    	return player;
	}
	/**
	 * 返回BOSS是否被打败过
	 * @return BOSS是否被打败过
	 */
	public boolean isBossGetItem() {
		return map.BossGetItem();
	}

	public void saveData(){
		try {
			database.saveState(player);
			database.saveMap(map);
			System.out.println("保存成功。");
		} catch (IOException e){
			System.out.println("保存失败，请检查是否有管理员权限！");
		}
	}
	//	    游戏运行，接受指令
	private void gameRun() {
		String line;
		Scanner in = new Scanner(System.in);
		while ( true ) {

			System.out.print("\\");
			line = in.nextLine();
			String[] words = line.split(" ");
			FuncSrc func = funcs.get(words[0]);
			String value2 = "";

			if( words.length > 1 )
				value2 = words[1];

//			如果找到了该指令
			if( func != null ){
				func.DoFunc(value2);
				if( func.isGameEnded() ){
//					退出指令特殊处理
					saveData();
					break;
				}
			}
			else
				System.out.println("对不起，输入指令错误！");
		}
		in.close();
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.printWelcome();
		game.gameRun();

		System.out.println("退出游戏。再见！");
	}

}
