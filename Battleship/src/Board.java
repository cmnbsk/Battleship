//plansza 10x10 zawieraj�ca informacje o po�o�eniu statk�w
//(false - puste pole, true - pole ze statkiem)
public class Board {
	
	boolean[][] board;
	
	Board(){
		board = new boolean[10][10];
	}
	
//	public boolean isFree(int x, int y){ //to jest sprawdzane podczas dodawania statku
//		if(board[x][y]==false)
//			return true;
//		else return false;
//	} 
	
	public int shoot(int x, int y){			//0-pud�o, 1-tylko trafiony, 2-trafiony i zatopiony
		if(board[x][y]==true){
			board[x][y]=false;
//			if(isShipDestroyed(x,y))	return 2;
//			else	return 1;
			return 1;
		}
		else	return 0;		
	}
	
	
	//DO POPRAWY!!! je�li uderzymy tr�jmasztowca w �rodek to po uderzeniu 
		//w jedn� z pozosta�ych cz�sci funcja zwr�ci true
//	private boolean isShipDestroyed(int x, int y){	//true-zatopiony false-niezatopiony
//		if(czyJestStatekWOkolicy(x,y))
//			return false;	
//		else return true;
//	}
	
	private boolean czyJestStatekWOkolicy(int x, int y){
		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y+1]==true 
			|| board[x][y+1]==true || board[x][y-1]==true ||
			board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true)
			return true;
		else return false;
	}
	
	private boolean czyMoznaPostawicStatek(int x, int y){
		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y-1]==true 
				|| board[x][y+1]==true || board[x][y] || board[x][y-1]==true || 
				board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true)
			return false;
		else return true;
	}
	
	
	//DOKO�CZY�
//	private boolean czyMoznaPostawicKolejnyMaszt(int x, int y, int poprzedniX, int poprzedniY){
//		
//		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y-1]==true 
//				|| board[x][y+1]==true || board[x][y] || board[x][y-1]==true || 
//				board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true)
//			return false;
//		else return true;
//	}
	
	public boolean addShip(int x, int y){ //add single ship; true-success, false-failure
		if(!czyMoznaPostawicStatek(x, y)){
			board[x][y]=true;
			return true;
		}
		else return false;
	}
	
	//niedokonczone sprawdzanie, trzeba dokonczyc metode czyMoznaPostawicKolejnyMaszt() i j� tu wykorzystac
	public boolean addShip(int firstX, int firstY, int lastX, int lastY){  //add multiple ship; true-success, false-failure
		
		boolean isSuccess = false;
		
		if(firstX>lastX){  		//sortowanie wspo�rz�dnych X
			int temp = firstX;
			firstX = lastX;
			lastX = temp;
		}
		else if(firstY>lastY){ 	//sortowanie wspo�rz�dnych Y
			int temp = firstY;
			firstY = lastY;
			lastY = temp;
		}
		if(firstX==lastX){ 	//dzi�ki temu wiemy �e statek jest postawiony pionowo (sta�a X)
			for(int i=firstY; i<=lastY; i++){
	//				board[firstX][i]=true;
					if(board[firstX][i]==false){
						board[firstX][i]=true;
						isSuccess = true;
					}
					else return false;
			}
		}
		else if(firstY==lastY){ //statek jest postawiony poziomo (sta�a Y)
			for(int i=firstX; i<=lastX; i++){
//				board[i][firstY]=true;
				if(board[i][firstY]==false){
					board[i][firstY]=true;
					isSuccess = true;
				}
				else return false;
			}				
		}		
		return isSuccess;
	}
	
	public void printBoard(){
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
