import java.util.ArrayList;

//plansza 10x10 zawieraj¹ca informacje o po³o¿eniu statków
//(false - puste pole, true - pole ze statkiem)
public class Board {
	
	int[][] board;  //0 -nie klikniete, nie ma statku; 
					//1 -nie klikniete, jest statek; 
					//2 -klikniete, bylo pudlo; 
					//3 -klikniete, byl trafiony
	
	
	Board(){		
		board = new int[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				board[i][j]=0;
			}
		}
		Ship.ships = new ArrayList<Ship>();
	}
	
	public int shoot(int x, int y){			//-1: pole bylo klikniete!; 0: pudlo, 1: tylko trafiony, 2: trafiony i zatopiony
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
	
	private int[] coordinatesToArray(int x1, int y1, int x2, int y2){
		
		int[] coordinates = {x1,y1,x2,y2};
		
		if(x1>x2){  		//sortowanie wspolrzednych X
			int temp = x1;
			x1 = x2;
			x2 = temp;
			coordinates[0]=x1;
			coordinates[2]=x2;
		}
		if(y1>y2){ 			//sortowanie wspolrzednych Y
			int temp = y1;
			y1 = y2;
			y2 = temp;
			coordinates[1]=y1;
			coordinates[3]=y2;
		}
		return coordinates;
	}
	
	private boolean isVertically(int[] coordinates){  //zwraca prawde jesli statek jest pionowo (x1=x2)
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
	
	private boolean czyMoznaPostawicStatek(int[] coordinates){
		
		int sizeH = coordinates[2]-coordinates[0]+1;  //size if Horizontal
		int sizeV = coordinates[3]-coordinates[1]+1;  //size if Vertical
		
		if(coordinates[0]>0 && coordinates[2]<9 && coordinates[1]>0 && coordinates[3]<9){ //jesli true statek nie jest ustawiony na rogu 
			if(isVertically(coordinates)){
				for(int i = 0; i<sizeV+2; i++){
					if(board[coordinates[0]-1][coordinates[1]-1+i]==1
							|| board[coordinates[0]][coordinates[1]-1+i]==1
							|| board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else{
				for(int i = 0; i<sizeH+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]-1]==1
							|| board[coordinates[0]-1+i][coordinates[1]]==1
							|| board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
		}
		else{
			//4 warunki na statki postawione przy scianach, ale nie na rogach
			if(coordinates[0]==0 && coordinates[3]>0 && coordinates[3]<9){
				for(int i = 0; i<sizeV+2; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1
							|| board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[0]==9 && coordinates[3]>0 && coordinates[3]<9){
				for(int i = 0; i<sizeV+2; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1
							|| board[coordinates[0]-1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[1]==0 && coordinates[2]>0 && coordinates[2]<9){
				for(int i = 0; i<sizeH+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]]==1
							|| board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
			else if(coordinates[1]==9 && coordinates[2]>0 && coordinates[2]<9){
				for(int i = 0; i<sizeH+2; i++){
					if(board[coordinates[0]-1+i][coordinates[1]-1]==1
							|| board[coordinates[0]-1+i][coordinates[1]]==1)
						return false;
				}
			}
			////// ponizej 8 warunkow na rogi (na kazdym rogu statek moze byc poziomo i pionowo)
			else if(coordinates[0]==0 && coordinates[2]==0 && coordinates[1]==0){ //Left Up Vertical
				for(int i = 0; i<sizeV+1; i++){					
					if(board[coordinates[0]][coordinates[1]+i]==1
							|| board[coordinates[0]+1][coordinates[1]+i]==1)
						return false;
				}
			}
			else if(coordinates[0]==0 && coordinates[2]==0 && coordinates[3]==9){  //L D V
				for(int i = 0; i<sizeV+1; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1
							|| board[coordinates[0]+1][coordinates[1]-1+i]==1)
						return false;
				} 
			}
			else if(coordinates[1]==0 && coordinates[3]==0 && coordinates[0]==0){  //L U H
				for(int i = 0; i<sizeH+1; i++){
					if(board[coordinates[0]+i][coordinates[1]]==1
							|| board[coordinates[0]+i][coordinates[1]+1]==1)
						return false;
				}
			}
			else if(coordinates[1]==9 && coordinates[3]==9 && coordinates[0]==0){  //L D H
				for(int i = 0; i<sizeH+1; i++){
					if(board[coordinates[0]+i][coordinates[1]]==1
							|| board[coordinates[0]+i][coordinates[1]-1]==1)
						return false;
				}
			}
			else if(coordinates[0]==9 && coordinates[2]==9 && coordinates[1]==0){  //P U V
				for(int i = 0; i<sizeV+1; i++){					
					if(board[coordinates[0]][coordinates[1]+i]==1
							|| board[coordinates[0]-1][coordinates[1]+i]==1)
						return false;
				}
			}
			else if(coordinates[0]==9 && coordinates[2]==9 && coordinates[3]==9){  //P D V
				for(int i = 0; i<sizeV+1; i++){					
					if(board[coordinates[0]][coordinates[1]-1+i]==1
							|| board[coordinates[0]-1][coordinates[1]-1+i]==1)
						return false;
				}
			}
			else if(coordinates[1]==0 && coordinates[3]==0 && coordinates[2]==9){  //P U H
				for(int i = 0; i<sizeH+1; i++){
					if(board[coordinates[0]-1+i][coordinates[1]]==1
							|| board[coordinates[0]-1+i][coordinates[1]+1]==1)
						return false;
				}
			}
			else if(coordinates[1]==9 && coordinates[3]==9 && coordinates[2]==9){  //P D H
				for(int i = 0; i<sizeH+1; i++){
					if(board[coordinates[0]-1+i][coordinates[1]]==1
							|| board[coordinates[0]-1+i][coordinates[1]-1]==1)
						return false;
				}
			}
		}
		return true;
	}
		
	public boolean addShip(int x, int y){ //add single ship; true-success, false-failure
		if(czyMoznaPostawicStatek(x, y)){
			Ship.ships.add(new Ship(x, y));
			//board[x][y]=true; // to sie robi w konstruktorze statku			
			return true;
		}
		else return false;
	}
	
	public boolean addShip(int firstX, int firstY, int lastX, int lastY){  //add multiple ship; true-success, false-failure
			
		int[] coordinates = coordinatesToArray(firstX, firstY, lastX, lastY);
		
		if(czyMoznaPostawicStatek(coordinates)){
			if(isVertically(coordinates)){
				for(int i=coordinates[1]; i<=coordinates[3]; i++)
					board[coordinates[0]][i]=1;				
				return true;
			}
			else{
				for(int i=coordinates[0]; i<=coordinates[2]; i++)
					board[i][coordinates[1]]=1;
				return true;
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
