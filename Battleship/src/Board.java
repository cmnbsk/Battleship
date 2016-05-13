//plansza 10x10 zawieraj�ca informacje o po�o�eniu statk�w
//(false - puste pole, true - pole ze statkiem)
public class Board {
	
	boolean[][] board;
	
	Board(){
		board = new boolean[10][10];
	}
	
	public boolean shoot(int x, int y){
		if(board[x][y]==true){
			board[x][y]=false;
			return true;
		}
		else return false;		
	}
	public boolean isShipDestroyed(int x, int y){
		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y+1]==true 
				|| board[x][y+1]==true || board[x][y-1]==true ||
				board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true){
			return false;
		}
		else return true;
			
	}
}
