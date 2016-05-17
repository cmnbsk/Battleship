import java.util.ArrayList;

//plansza 10x10 zawieraj¹ca informacje o po³o¿eniu statków
//(false - puste pole, true - pole ze statkiem)
public class Board {
	
	int[][] board;  // 0-nie klikniête, nie ma statku; 
					//1 - nie klikniête, jest statek; 
					//2-klikniête, pud³o; 
					//3-klikniête, trafiony
	
	
	Board(){		
		board = new int[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				board[i][j]=0;
			}
		}
		Ship.ships = new ArrayList<Ship>();
	}
	
//	public boolean isFree(int x, int y){ //to jest sprawdzane podczas dodawania statku
//		if(board[x][y]==false)
//			return true;
//		else return false;
//	} 
	
	public int shoot(int x, int y){			//-1: pole by³o klikniête!; 0: pud³o, 1: tylko trafiony, 2: trafiony i zatopiony
		if(board[x][y]==1){
			board[x][y]=3;
			Ship s = Ship.findShip(x, y);
			s.size--;
			if(s.isDestroyed()) return 2;			
			else 				return 1;			
		}
		else if(board[x][y]==0){
			board[x][y]=2;
			return 0;
		}
		else return -1;
	}
	
//	private boolean czyJestStatekWOkolicy(int x, int y){
//		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y+1]==true 
//			|| board[x][y+1]==true || board[x][y-1]==true ||
//			board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true)
//			return true;
//		else return false;
//	}
	
	private int[] coordinatesToArray(int x1, int y1, int x2, int y2){
		
		int[] coordinates = {x1,y1,x2,y2};
		
		if(x1>x2){  		//sortowanie wspo³rzêdnych X
			int temp = x1;
			x1 = x2;
			x2 = temp;
			coordinates[0]=x1;
			coordinates[2]=x2;
		}
		if(y1>y2){ 			//sortowanie wspo³rzêdnych Y
			int temp = y1;
			y1 = y2;
			y2 = temp;
			coordinates[1]=y1;
			coordinates[3]=y2;
		}
		return coordinates;
	}
	
	private boolean isVertically(int[] coordinates){  //zwraca prawde jeœli statek jest pionowo (x1=x2)
		if(coordinates[0]==coordinates[2])
			return true;
		else return false;
	}
	
	private boolean czyMoznaPostawicStatek(int x, int y){
			
		if(x==0 && y!=0 && y!=9){ //lewa krawedz, bez rogow
			if(board[x][y+1]==1 || board[x][y]==1 || board[x][y-1]==1 
					|| board[x+1][y+1]==1 || board[x+1][y]==1 || board[x+1][y-1]==1)
				return false;
		}
		else if(x==0 && y==0){  //lewa górny róg
			if(board[x][y+1]==1 || board[x][y]==1 
					|| board[x+1][y+1]==1 || board[x+1][y]==1)
				return false;
		}
		else if(x==0 && y==9){ //lewy dolny róg
			if(board[x][y-1]==1 || board[x][y]==1 
					|| board[x+1][y-1]==1 || board[x+1][y]==1)
				return false;
		}
		else if(x==9 && y!=0 && y!=9){ //prawa krawedz bez rogów
			if(board[x-1][y+1]==1 || board[x-1][y]==1 || board[x-1][y-1]==1 
					|| board[x][y+1]==1 || board[x][y]==1 || board[x][y-1]==1)
				return false;
		}
		else if(x==9 && y==0){  //prawy górny róg
			if(board[x][y]==1 || board[x][y+1]==1 
					|| board[x-1][y]==1 || board[x-1][y+1]==1)
				return false;
		}
		else if(x==9 && y==9){  //prawy dolny róg
			if(board[x][y]==1 || board[x][y-1]==1 
					|| board[x-1][y]==1 || board[x-1][y-1]==1)
				return false;
		}
		else if(y==0 && x!=0 && x!=9){  //górna krawedz bez rogów
			if(board[x-1][y]==1 || board[x][y]==1 || board[x+1][y]==1 
					|| board[x-1][y+1]==1 || board[x][y+1]==1 || board[x+1][y+1]==1)
				return false;
		}
		else if(y==9 && x!=0 && x!=9){  // dolna krawêdz bez rogów
			if(board[x-1][y]==1 || board[x][y]==1 || board[x+1][y]==1 
					|| board[x-1][y-1]==1 || board[x][y-1]==1 || board[x+1][y-1]==1)
				return false;
		}		
		else{
			if(board[x-1][y+1]==1 || board[x-1][y]==1 || board[x-1][y-1]==1 
					|| board[x][y+1]==1 || board[x][y]==1 || board[x][y-1]==1 
					|| board[x+1][y+1]==1 || board[x+1][y]==1 || board[x+1][y-1]==1)
				return false;			
		}
		return true;
	}
	
	private boolean czyMoznaPostawicStatek1(int[] coordinates){
		
		if(coordinates[0]>0 && coordinates[2]<9 && coordinates[1]>0 && coordinates[3]<9){ //jesli true statek nie jest ustawiony na rogu 
			if(isVertically(coordinates)){
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else{
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]-1]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
		}
		else{
			if(coordinates[0]==0 && coordinates[3]>0 && coordinates[3]<9){
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+2; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[0]==9 && coordinates[3]>0 && coordinates[3]<9){
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+2; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]-1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[1]==0 && coordinates[2]>0 && coordinates[2]<9){
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
			else if(coordinates[1]==9 && coordinates[2]>0 && coordinates[2]<9){
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]-1]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
				}
			}
			////// poni¿ej 8 warunkow na rogi (na ka¿dym rogu statek mo¿e byæ poziomo i pionowo)
			else if(coordinates[0]==0 && coordinates[2]==0 && coordinates[1]==0){ //Left Up Vertical
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+1; i++){					
					if(board[coordinates[0]][coordinates[1]+i]==1)
						return false;
					else if(board[coordinates[0]+1][coordinates[1]+i]==1)
						return false;
				}
			}
			else if(coordinates[0]==0 && coordinates[2]==0 && coordinates[3]==9){  //L D V
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+1; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				}
			} //TU SKONCZYLEM!!!!!!!!!!!!!!!!!!
			else if(coordinates[1]==0 && coordinates[2]>0 && coordinates[2]<9){
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
			else if(coordinates[1]==9 && coordinates[2]>0 && coordinates[2]<9){
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]-1]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
				}
			}
			if(coordinates[0]==0 && coordinates[3]>0 && coordinates[3]<9){
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+2; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[0]==9 && coordinates[3]>0 && coordinates[3]<9){
				int size = coordinates[3]-coordinates[1]+1;
				for(int i = 0; i<size+2; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1)
						return false;
					else if(board[coordinates[0]-1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[1]==0 && coordinates[2]>0 && coordinates[2]<9){
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
			else if(coordinates[1]==9 && coordinates[2]>0 && coordinates[2]<9){
				int size = coordinates[2]-coordinates[0]+1;
				for(int i = 0; i<size+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]-1]==1)
						return false;
					else if(board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
				}
			}
		}
		return true;
	}
	
	
	//DOKOÑCZYÆ
//	private boolean czyMoznaPostawicKolejnyMaszt(int x, int y, int poprzedniX, int poprzedniY){
//		
//		if(board[x-1][y+1]==true || board[x-1][y]==true || board[x-1][y-1]==true 
//				|| board[x][y+1]==true || board[x][y] || board[x][y-1]==true || 
//				board[x+1][y+1]==true || board[x+1][y]==true || board[x+1][y-1]==true)
//			return false;
//		else return true;
//	}
	
	public boolean addShip(int x, int y){ //add single ship; true-success, false-failure
		if(czyMoznaPostawicStatek(x, y)){
			Ship.ships.add(new Ship(x, y));
			//board[x][y]=true; // to sie robi w konstruktorze statku			
			return true;
		}
		else return false;
	}
	
	//niedokonczone sprawdzanie, trzeba dokonczyc metode czyMoznaPostawicKolejnyMaszt() i j¹ tu wykorzystac
	public boolean addShip(int firstX, int firstY, int lastX, int lastY){  //add multiple ship; true-success, false-failure
			
		int[] coordinates = coordinatesToArray(firstX, firstY, lastX, lastY);
		
		if(czyMoznaPostawicStatek1(coordinates)){
			if(isVertically(coordinates)){
				for(int i=coordinates[1]; i<=coordinates[3]; i++)
					board[coordinates[0]][i]=1;				
				return true;
			}
			else{
				for(int i=coordinates[0]; i<=coordinates[2]; i++)
					board[i][coordinates[1]]=1;
				return false;
			}
		}
		else return false;
		
	}
	
	public void printBoard(){
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				System.out.print(board[j][i]+" ");
			}
			System.out.println("");
		}
	}
	
	
	
}
