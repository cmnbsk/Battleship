
public class AI {

	static int[] lastHit = new int [2];
	static boolean isLastHit = false;
	
	public static int shoot(Board board){
		boolean isSuccess = false;
					
		if(isLastHit){
			switch(nextShoot(board)){
			case 0: return 0;
			case 1: return 1;
			case 2: return 2;
			}
		}
		int hitX, hitY;	
		isSuccess = false;
		while(!isSuccess){
			hitX = RandomGenerator.getRandomShoot();
			hitY = RandomGenerator.getRandomShoot();
			switch(board.shoot(hitX, hitY)){
				case -1:isSuccess=false;
						break;					
				case 0:	isLastHit=false;
						return 0;
				case 1: lastHit[0] = hitX;
						lastHit[1] = hitY;
						isLastHit = true;
						return 1;
				case 2: isLastHit=false;
						return 2;
			}
		}
		return -1;
	}
	
	private static int nextShoot(Board board){
		switch(RandomGenerator.getChoice()){  //kilka kombinacji (4) w które pole komputer ma uderzyæ najpeirw
		case 0: switch(board.shoot(lastHit[0]+1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]+1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0]-1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]-1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0], lastHit[1]+1)){
				case 1: lastHit[1]=lastHit[1]+1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0], lastHit[1]-1)){
				case 1: lastHit[1]=lastHit[1]-1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				break;
		case 1:	switch(board.shoot(lastHit[0]-1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]-1;
					isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0]+1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]+1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0], lastHit[1]+1)){
				case 1: lastHit[1]=lastHit[1]+1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0], lastHit[1]-1)){
				case 1: lastHit[1]=lastHit[1]-1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				break;
		case 2:	switch(board.shoot(lastHit[0], lastHit[1]+1)){
				case 1: lastHit[1]=lastHit[1]+1;
					isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0]-1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]-1;
					isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0]+1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]+1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0], lastHit[1]-1)){
				case 1: lastHit[1]=lastHit[1]-1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				break;
		case 3:	switch(board.shoot(lastHit[0], lastHit[1]-1)){
				case 1: lastHit[1]=lastHit[1]-1;
					isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0]-1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]-1;
					isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0]+1, lastHit[1])){
				case 1: lastHit[0]=lastHit[0]+1;
						isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				switch(board.shoot(lastHit[0], lastHit[1]+1)){
				case 1: lastHit[1]=lastHit[1]+1;
					isLastHit=true;	return 1;
				case 0: isLastHit=false;return 0;
				case 2: isLastHit=false;return 2;
				}
				break;
		}
		return -1;
	}
}
