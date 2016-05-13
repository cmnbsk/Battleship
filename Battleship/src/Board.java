//plansza 10x10 zawieraj¹ca informacje o po³o¿eniu statków
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
