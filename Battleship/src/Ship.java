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

	Ship(int[] coordinates){
		if(isVertically(coordinates)){
			this.size=coordinates[3]-coordinates[1]+1;
			for(int i=0; i<this.size; i++)
				board[coordinates[0]][coordinates[1]+i]=1;
		}
		else{
			this.size=coordinates[2]-coordinates[0]+1;
			for(int i=0; i<this.size; i++)
				board[coordinates[0]+i][coordinates[1]]=1;
		}
		ship_id = new int [2];
		ship_id[0]=coordinates[0];
		ship_id[1]=coordinates[1];
	}
	
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
