package map;

import castle.Game;
import util.S;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 地图类
 * Created by asus1 on 2016/1/27.
 */
public class GameMap {

	private ArrayList<Room> theRooms;
	private Room currentRoom;

	public GameMap() {
		theRooms = new ArrayList<>();
		//	构造地图结构
        /*0*/theRooms.add(new Room("城堡外","英俊的小偷头目",
				200,25,10,8,"小偷头目的钱全掉出来了！"));
        /*1*/theRooms.add(new Room("一楼大堂","礼貌的大堂经理",
				100,15,12,5,"大堂经理的帐算错了！"));
        /*2*/theRooms.add(new Room("小酒吧","潇洒的酒吧流氓",
				150,10,5,3,"酒吧流氓喝醉了！"));
        /*3*/theRooms.add(new Room("书房","优雅的读书人",
				100,7,5,2,"读书人的书掉出来了！"));
        /*4*/theRooms.add(new Room("宾馆","可爱的女仆",
				10,6,3,1,"女仆被你推倒了！"));
        /*5*/theRooms.add(new Room("二楼睡房","公主的管家",
				300,20,5,15,"管家扑街、公主被你推倒了！"));
        /*6*/theRooms.add(new Room("负一楼","奇怪的男人",
				200,30,15,25,"男人身边站出来一名浑身是伤的女孩。。"));
        /*7*/theRooms.add(new Room("负二楼","穿着霸气的绅士",
				100,50,35,35,"绅士的衣服脏了！"));
        /*8*/theRooms.add(new Room("负三楼","身穿铠甲的战士",
				300,30,25,45,"战士被自己绊倒了！"));
        /*9*/theRooms.add(new Room("负四楼","持剑的骑士",
				400,40,35,60,"骑士的剑断了！"));
        /*10*/theRooms.add(new Room("三楼阳台"));
        /*11*/theRooms.add(new Room("城堡顶部瞭望塔"));
        /*null*/theRooms.add(new Room("神秘空间","冰封",
				1000,100,100,200,"冰封继续开发中。。。"));

		setExitWithoutDirection(0, 1, S.EAST, S.WEST );
		setExitWithoutDirection(0, 3, S.SOUTH,S.WEST );
		setExitWithoutDirection(0, 2, S.WEST, S.EAST );
		setExitWithoutDirection(3, 4, S.EAST, S.WEST );
		setExitWithoutDirection(1, 5, S.UP,   S.DOWN );
		setExitWithoutDirection(1, 6, S.DOWN, S.UP );
		setExitWithoutDirection(6, 7, S.DOWN, S.UP );
		setExitWithoutDirection(7, 8, S.DOWN, S.UP );
		setExitWithoutDirection(8, 9, S.DOWN, S.UP );
		setExitWithoutDirection(10,5, S.DOWN, S.UP );
		setExitWithoutDirection(11,10,S.DOWN, S.UP );
		setExitWithoutDirection(1, 4, S.NORTH,S.SOUTH );

		// 从女仆那里开始
		currentRoom = theRooms.get(4);
	}

	private void setExitWithoutDirection(int index_a, int index_b, S a2b, S b2a){
		theRooms.get(index_a).setExit(String.valueOf(a2b), index_b);
		theRooms.get(index_b).setExit(String.valueOf(b2a), index_a);
	}

	public void setCurrentRoom(Room room){
		currentRoom = room;
	}

	public boolean goRoom(String direction){
		if( currentRoom.checkExit(direction) ) {
			currentRoom = theRooms.get(currentRoom.showRoomId(direction));
			return true;
		}
		else
			return false;
	}

	public boolean isRoomExists(String roomName){
		for (Room room : theRooms) {
			if(room.equals(roomName)){
				return true;
			}
		}
		return false;
	}

	public void setRoomsState(char[] state){
//		for (int i1 = 0; i1 < state.length; i1++) {
//			System.out.println("state[" + i1 + "] = " + state[i1]);
//		}
		for (int i = 0; i < theRooms.size(); i++) {
			char c;
			try{
				c = state[i];
			} catch (Exception e){
				c = 1;
			}
			theRooms.get(i).setBossGetItem(c == '1');
		}
	}

	public void loadRoom(String room_){
		for (Room room : theRooms) {
			if(room.equals(room_)){
				currentRoom = room;
				break;
			}
		}
	}

	public char[] getRoomsState(){
		char[] roomsState = new char[theRooms.size()];
		for (int i = 0; i < theRooms.size(); i++)
			roomsState[i] = theRooms.get(i).isBossGetItem() ? '1' : '0';
		return roomsState;
	}

	public String wildRoom(){
		int index = (int) (Math.random()*2000);
		index %= theRooms.size();
		currentRoom = theRooms.get(index);
		return currentRoom.getPrompt();
	}

	public void fightBoss(Game game){
		game.setPlayer(currentRoom.fightBoss(game.getPlayer(), game));
	}

	public String getRoomData(){
		return currentRoom.toString();
	}

	/**
	 * 返回BOSS是否被打败过
	 * @return BOSS是否被打败过
	 */
	public boolean BossGetItem() {
		return currentRoom.isBossGetItem();
	}

	public boolean treatRoomCheck(){
		return currentRoom.toString().matches("宾馆|卧室");
	}

	public String getCurrentRoomPrompt(){
		return currentRoom.getPrompt();
	}
}
