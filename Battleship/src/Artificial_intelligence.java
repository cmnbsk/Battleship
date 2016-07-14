
public class Artificial_intelligence {

	int[] lastHit = new int [2];
	boolean isLastHit = false;
	boolean twoHits = false;
	int[] secondHit = new int [2];
	
	public int shoot(Board board){
		boolean isSuccess = false;
		
		if(isLastHit){
			while(!isSuccess){			
				switch(nextShoot(board)){
				case -1: isSuccess=false;
						break;
				case 0: return 0;
				case 1: isLastHit=true; return 1;
				case 2: isLastHit=false; return 2;
				}
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
	
	private int nextShoot(Board board){
		if(twoHits){
			if(lastHit[0]==secondHit[0]){
				if(lastHit[1]>secondHit[1]){
					switch(board.shoot(lastHit[0], lastHit[1]+1)){
					case 1: lastHit[1]=lastHit[1]+1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					switch(board.shoot(lastHit[0], secondHit[1]-1)){
					case 1: secondHit[1]=secondHit[1]-1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					return -1;
				}
				else{
					switch(board.shoot(lastHit[0], lastHit[1]-1)){
					case 1: lastHit[1]=lastHit[1]-1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					switch(board.shoot(lastHit[0], secondHit[1]+1)){
					case 1: secondHit[1]=secondHit[1]+1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					return -1;
				}
			}else if(lastHit[1]==secondHit[1]){
				if(lastHit[0]>secondHit[0]){
					switch(board.shoot(lastHit[0]+1, lastHit[1])){
					case 1: lastHit[0]=lastHit[0]+1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					switch(board.shoot(secondHit[0]-1, lastHit[1])){
					case 1: secondHit[0]=secondHit[0]-1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					return -1;
				}
				else{
					switch(board.shoot(lastHit[0]-1, lastHit[1])){
					case 1: lastHit[0]=lastHit[0]-1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					switch(board.shoot(secondHit[0]+1, lastHit[1])){
					case 1: secondHit[0]=secondHit[0]+1;
							return 1;
					case 0: return 0;
					case 2: isLastHit=false;
							twoHits=false;
							return 2;
					}
					return -1;
				}
			}
		}
		switch(RandomGenerator.getChoice()){  //kilka kombinacji (4) w które pole komputer ma uderzyæ najpierw
		case 0:	return nextShootRandomizer1(board);  //funkcje randomizer posiadaj¹ 4 ró¿ne kolejnoœci w szukaniu wolnego pola do strza³u
		case 1:	return nextShootRandomizer2(board);
		case 2:	return nextShootRandomizer3(board);
		case 3:	return nextShootRandomizer4(board);
		}
		return -1;
	}
	
	int nextShootBiggestX(Board board){
		switch(board.shoot(lastHit[0]+1, lastHit[1])){
		case 1: secondHit[0]=lastHit[0];
				secondHit[1]=lastHit[1];
				lastHit[0]=lastHit[0]+1;
				isLastHit=true;
				twoHits=true;
				return 1;
		case 0: return 0;
		case 2: isLastHit=false;
				twoHits=false;
				return 2;
		}
		return -1;
	}
	
	int nextShootSmallestX(Board board){
		switch(board.shoot(lastHit[0]-1, lastHit[1])){
		case 1: secondHit[0]=lastHit[0];
				secondHit[1]=lastHit[1];
				lastHit[0]=lastHit[0]-1;
				isLastHit=true;
				twoHits=true;
				return 1;
		case 0: return 0;
		case 2: isLastHit=false;
				twoHits=false;
				return 2;
		}
		return -1;
	}
	
	int nextShootBiggestY(Board board){
		switch(board.shoot(lastHit[0], lastHit[1]+1)){
		case 1: secondHit[0]=lastHit[0];
				secondHit[1]=lastHit[1];
				lastHit[1]=lastHit[1]+1;
				isLastHit=true;
				twoHits=true;
				return 1;
		case 0: return 0;
		case 2: isLastHit=false;
				twoHits=false;
				return 2;
		}
		return -1;
	}
	
	int nextShootSmallestY(Board board){
		switch(board.shoot(lastHit[0], lastHit[1]-1)){
		case 1: secondHit[0]=lastHit[0];
				secondHit[1]=lastHit[1];
				lastHit[1]=lastHit[1]-1;
				isLastHit=true;
				twoHits=true;
				return 1;
		case 0: return 0;
		case 2: isLastHit=false;
				twoHits=false;
				return 2;
		}
		return -1;
	}
	
	int nextShootRandomizer1(Board board){
		int ret = nextShootBiggestX(board);
		if(ret != -1) return ret;
		ret = nextShootSmallestX(board);
		if(ret != -1) return ret;
		ret = nextShootBiggestY(board);
		if(ret != -1) return ret;
		ret = nextShootSmallestY(board);
		return ret;
	}
	
	int nextShootRandomizer2(Board board){
		int ret = nextShootSmallestY(board);
		if(ret != -1) return ret;
		ret = nextShootBiggestY(board);
		if(ret != -1) return ret;
		ret = nextShootSmallestX(board);
		if(ret != -1) return ret;
		ret = nextShootBiggestX(board);
		return ret;
	}
	
	int nextShootRandomizer3(Board board){
		int ret = nextShootSmallestX(board);
		if(ret != -1) return ret;
		ret = nextShootSmallestY(board);
		if(ret != -1) return ret;
		ret = nextShootBiggestX(board);
		if(ret != -1) return ret;
		ret = nextShootBiggestY(board);
		return ret;
	}
	
	int nextShootRandomizer4(Board board){
		int ret = nextShootBiggestY(board);
		if(ret != -1) return ret;
		ret = nextShootBiggestX(board);
		if(ret != -1) return ret;
		ret = nextShootSmallestY(board);
		if(ret != -1) return ret;
		ret = nextShootSmallestX(board);
		return ret;
	}
}
