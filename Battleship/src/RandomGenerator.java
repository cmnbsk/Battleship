import java.util.Random;

public class RandomGenerator {
	
	private static Random generator = new Random();
		
	public static Board getRandomBoard(Board board, int amountOf_1_mast, int amountOf_2_mast, int amountOf_3_mast, int amountOf_4_mast){
		boolean isSuccess=false;
		int firstX,firstY;
		boolean verticalShip;
		for(int i=0; i<amountOf_1_mast; i++){
			while(!board.addShip(generator.nextInt(10), generator.nextInt(10)));
		}
		for(int i=0; i<amountOf_2_mast; i++){
			isSuccess=false;
			while(!isSuccess){
				firstX=generator.nextInt(10);
				firstY=generator.nextInt(10);
				verticalShip=generator.nextBoolean();   //true-ship vertical  false-ship horizontal
				if(verticalShip){
					if(board.addShip(firstX, firstY, firstX, firstY+1))
						isSuccess=true;
				}
				else{
					if(board.addShip(firstX, firstY, firstX+1, firstY))
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
					if(board.addShip(firstX, firstY, firstX, firstY+2))
						isSuccess=true;
				}
				else{
					if(board.addShip(firstX, firstY, firstX+2, firstY))
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
					if(board.addShip(firstX, firstY, firstX, firstY+3))
						isSuccess=true;
				}
				else{
					if(board.addShip(firstX, firstY, firstX+3, firstY))
						isSuccess=true;
				}
			}
		}
		
		return board;
	}

	public static int getRandomShoot(){
		return generator.nextInt(10);
	}
	
	public static int getChoice(){
		return generator.nextInt(4);
	}
}

