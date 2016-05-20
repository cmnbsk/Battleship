import java.util.Random;

public class AI_randomGenerator {
	
	Random generator;
	
	AI_randomGenerator(){		
		generator = new Random();
	}
		
	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast){
		for(int i=0; i<amountOf_1_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
		}
		
		return ai_board;
	}
	
	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast, int amountOf_2_mast){
		for(int i=0; i<amountOf_1_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_2_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
		}		
		
		return ai_board;
	}
	
	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast, int amountOf_2_mast, int amountOf_3_mast){
		for(int i=0; i<amountOf_1_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_2_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_3_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
		}		
		
		return ai_board;
	}
	
	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast, int amountOf_2_mast, int amountOf_3_mast, int amountOf_4_mast){
		for(int i=0; i<amountOf_1_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_2_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_3_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_4_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
		}
		
		return ai_board;
	}
}
