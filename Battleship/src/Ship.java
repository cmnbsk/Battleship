//statki!!!! fun 

//Jak bedzie przechowywana informacja o stanie pojedynczych cz�ci statk�w?
//Jest zmienna, kt�ra przechowuje informacje o og�lnym stanie statku (is_destroyed),
//ale jak za�atwi� niszczenie poszczeg�lnych cz�ci?
//Mamy te� plansze kt�ra pokazuje na kt�rych polach s� statki 
//(mo�e by j� rozbudowa�, �eby przechowywa�a te� ich stan)


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
