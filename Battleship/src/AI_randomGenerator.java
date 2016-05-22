import java.util.Random;

public class AI_randomGenerator {
	
	Random generator;
	
	AI_randomGenerator(){		
		generator = new Random();
	}
		
//	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast){
//		for(int i=0; i<amountOf_1_mast; i++){
//			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
//		}
//		
//		return ai_board;
//	}
//	
//	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast, int amountOf_2_mast){
//		for(int i=0; i<amountOf_1_mast; i++){
//			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
//		}
//		for(int i=0; i<amountOf_2_mast; i++){
//			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
//		}		
//		
//		return ai_board;
//	}
//	
//	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast, int amountOf_2_mast, int amountOf_3_mast){
//		for(int i=0; i<amountOf_1_mast; i++){
//			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
//		}
//		for(int i=0; i<amountOf_2_mast; i++){
//			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
//		}
//		for(int i=0; i<amountOf_3_mast; i++){
//			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10), generator.nextInt(10), generator.nextInt(10)));
//		}		
//		
//		return ai_board;
//	}
	
	public Board generateRandomBoard(Board ai_board, int amountOf_1_mast, int amountOf_2_mast, int amountOf_3_mast, int amountOf_4_mast){
		boolean isSuccess=false;
		int firstX,firstY;
		boolean verticalShip;
		for(int i=0; i<amountOf_1_mast; i++){
			while(!ai_board.addShip(generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_2_mast; i++){
			isSuccess=false;
			while(!isSuccess){
				firstX=generator.nextInt(10);
				firstY=generator.nextInt(10);
				verticalShip=generator.nextBoolean();   //true-ship vertical  false-ship horizontal
				if(verticalShip){
					if(ai_board.addShip(firstX, firstY, firstX, firstY+1))
						isSuccess=true;
				}
				else{
					if(ai_board.addShip(firstX, firstY, firstX+1, firstY))
						isSuccess=true;
				}
			}
		}
		for(int i=0; i<amountOf_3_mast; i++){
			isSuccess=false;
			while(!isSuccess){
				firstX=generator.nextInt(10);
				firstY=generator.nextInt(10);
				verticalShip=generator.nextBoolean();   //true-ship vertical  false-ship horizontal
				if(verticalShip){
					if(ai_board.addShip(firstX, firstY, firstX, firstY+2))
						isSuccess=true;
				}
				else{
					if(ai_board.addShip(firstX, firstY, firstX+2, firstY))
						isSuccess=true;
				}
			}
		}
		for(int i=0; i<amountOf_4_mast; i++){
			isSuccess=false;
			while(!isSuccess){
				firstX=generator.nextInt(10);
				firstY=generator.nextInt(10);
				verticalShip=generator.nextBoolean();   //true-ship vertical  false-ship horizontal
				if(verticalShip){
					if(ai_board.addShip(firstX, firstY, firstX, firstY+3))
						isSuccess=true;
				}
				else{
					if(ai_board.addShip(firstX, firstY, firstX+3, firstY))
						isSuccess=true;
				}
			}
		}
		
		return ai_board;
	}
}
