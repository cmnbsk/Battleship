import java.util.ArrayList;

public class Ship{
	
	int size;
	int[] ship_id;  //[0] - X  [1] -Y
	static ArrayList<Ship> ships;
	
	Ship(int x, int y){
		this.size=1;
		//board[x][y]=1;
		ship_id = new int [2];
		ship_id[0]=x;
		ship_id[1]=y;
	}

	Ship(int[] coordinates){
		if(Board.isVertically(coordinates)){
			size=coordinates[3]-coordinates[1]+1;
			ship_id = new int [size*2];	
			int j=0;
			for(int i=0; i<size*2; i+=2){
				ship_id[i]=coordinates[0];
				ship_id[i+1]=coordinates[1]+j;
				j++;
			}
		}
		else{
			size=coordinates[2]-coordinates[0]+1;
			ship_id = new int [size*2];
			int j=0;
			for(int i=0; i<size*2; i+=2){				
				ship_id[i]=coordinates[0]+j;
				ship_id[i+1]=coordinates[1];
				j++;
			} 
		}
	}
	
	boolean isDestroyed(){
		if(size>0)
			return false;
		else return true;		
	}
	
	public int[] getCoordinates(){
		return ship_id;
	}
	
	static Ship findShip(int x, int y){		
		for( Ship s : ships){
			for (int i=0; i < s.ship_id.length; i+=2){
				if(s.ship_id[i]==x && s.ship_id[i+1]==y)
					return s;
			}
		}
		return null;
	}
}
