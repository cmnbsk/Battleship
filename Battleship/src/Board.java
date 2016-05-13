//plansza 10x10 zawieraj�ca informacje o po�o�eniu statk�w
//(false - puste pole, true - pole ze statkiem)
public class Board {
	
	boolean[][] board;
	
	Board(){
		board = new boolean[10][10];
	}
	
	public int shoot(int x, int y){			//0-pud�o, 1-tylko trafiony, 2-trafiony i zatopiony
		if(board[x][y]==true){
			board[x][y]=false;
			if(isShipDestroyed(x,y))	return 2;
			else	return 1;
		}
		else	return 0;		
	}
	
	
	//DO POPRAWY!!! je�li uderzymy tr�jmasztowca w �rodek to po uderzeniu 
		//w jedn� z pozosta�ych cz�sci funcja zwr�ci true
	private boolean isShipDestroyed(int x, int y){	//true-zatopiony false-niezatopiony
		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y+1]==true 
				|| board[x][y+1]==true || board[x][y-1]==true ||
				board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true){
			return false;
		}
		else return true;
	}
	
	public void addShip(int x, int y){ //add single ship
		board[x][y]=true;		
	}
	
	public void addShip(int firstX, int firstY, int lastX, int lastY){  //add multiple ship
		if(firstX>lastX){  	//sortowanie wspo�rz�dnych X
			int temp = firstX;
			firstX = lastX;
			lastX = temp;
		}
		if(firstY>lastY){  	//sortowanie wspo�rz�dnych Y
			int temp = firstY;
			firstY = lastY;
			lastY = temp;
		}
		if(firstX==lastX){ 	//dzi�ki temu wiemy �e statek jest postawiony pionowo (sta�a X)
			for(int i=firstY; i<=lastY; i++)
								board[firstX][i]=true;
		}
		else if(firstY==lastY){ //statek jest postawiony poziomo (sta�a Y)
			for(int i=firstX; i<=lastX; i++)
								board[i][firstY]=true;
		}
		else System.out.println("Ship can not be created diagonally!");		
	}
	
	public void printBoardStdOut(){
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				if(board[j][i]==true)
					System.out.print("X ");
				else System.out.print("0 ");
			}
			System.out.println("");
		}
	}
	
	
	
}
