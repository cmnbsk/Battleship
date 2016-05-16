import java.util.ArrayList;

public class Ship extends Board{
	
	int size;
	int[] ship_id;  //[0] - X  [1] -Y
	static ArrayList<Ship> ships;
	
	Ship(int x, int y){
		this.size=1;
		board[x][y]=1;
		ship_id = new int [2];
		ship_id[0]=x;
		ship_id[1]=y;
	}
	
// @not Implemented YETI
//	Ship(int size, int firstX, int firstY, int lastX, int lastY){
//		this.size=size;
//		board[x][y]=true;
//		ship_id++;
//	}
	
	boolean isDestroyed(){
		if(size>0)
			return false;
		else return true;		
	}
	
	static Ship findShip(int x, int y){		
		for( Ship s : ships){
			if(s.ship_id[0]==x && s.ship_id[1]==y)
				return s;			
		}
		return null;
	}
}
