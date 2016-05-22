
public class Battleship {

	public static void main(String[] args) {
		System.out.println("siedzialem nad tym caly dzien");
		
		AI_randomGenerator generator = new AI_randomGenerator();
		
		Board komputer = new Board();
		generator.getRandomBoard(komputer, 4, 3, 2, 1);
		
		System.out.println("Wygenerowano plansza komputera");
		komputer.printBoard();
		
		Board gracz = new Board();
		generator.getRandomBoard(gracz, 4, 3, 2, 1);
		
		System.out.println("Wygenerowano plansza gracza");
		gracz.printBoard();
		
		Board.startGame();
		
		System.out.println("Plansza gracz");
		gracz.printBoard();
		System.out.println("Plansza komputer");
		komputer.printBoard();
		
		for(int i=0; i<99; i++){
			System.out.println("i = "+i);
			switch(gracz.shoot(generator.getRandomShoot(), generator.getRandomShoot())){
				case -1: System.out.println("Gracz: b³¹d podczas strzalu."); break;
				case 0: System.out.println("Gracz: pud³o."); break;
				case 1: System.out.println("Gracz: trafiony."); break;
				case 2: System.out.println("Gracz: trafiony i zatopiony."); break;
			}
			switch(komputer.shoot(generator.getRandomShoot(), generator.getRandomShoot())){
				case -1: System.out.println("Komputer: b³¹d podczas strzalu."); break;
				case 0: System.out.println("Komputer: pud³o."); break;
				case 1: System.out.println("Komputer: trafiony."); break;
				case 2: System.out.println("Komputer: trafiony i zatopiony.");break;
			}
		}
		
		System.out.println("Plansza gracz");
		gracz.printBoard();
		System.out.println("Plansza komputer");
		komputer.printBoard();
	}

}
