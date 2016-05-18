
public class Battleship {

	public static void main(String[] args) {
		System.out.println("siedzialem nad tym caly dzien");
		
		Board gracz = new Board();
		gracz.addShip(0,0); 		//0<=x,y<=9 !!!!
		gracz.addShip(9, 9, 9, 6); 
		gracz.addShip(0, 8, 0, 9);
		gracz.printBoard();
		System.out.println();
		
		gracz.shoot(2, 2);
		if(gracz.shoot(9,9)==1)
			System.out.println("trafiony");
		if(gracz.shoot(5,0)==0)
			System.out.println("pud³o");
		if(gracz.shoot(4,5)==2)
			System.out.println("zatopiony");
		
		gracz.printBoard();
	}

}
