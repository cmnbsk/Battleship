//statki!!!! fun 

//Jak bedzie przechowywana informacja o stanie pojedynczych czêœci statków?
//Jest zmienna, która przechowuje informacje o ogólnym stanie statku (is_destroyed),
//ale jak za³atwiæ niszczenie poszczególnych czêœci?
//Mamy te¿ plansze która pokazuje na których polach s¹ statki 
//(mo¿e by j¹ rozbudowaæ, ¿eby przechowywa³a te¿ ich stan)


public class Ship {
	
	int size;  //size of ship
	boolean is_horizontal;  //true: ship horizontal, false: ship vertical
	boolean is_destroyed;
	
	Ship(int size, int x, int y){
		this.size=size;
//		this.x=x;
//		this.y=y;
		is_destroyed=false;
	}
	
	public boolean isDestroyed(){
		return is_destroyed;
	}
	
	void trafiony(){
		size--;
		
	}
}
