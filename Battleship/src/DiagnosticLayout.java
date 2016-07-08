import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiagnosticLayout extends JFrame{
	
	JTextField[][] textFieldsTable1;
	JTextField[][] textFieldsTable2;
	GridLayout gridL;
	FlowLayout flowL;
	
	DiagnosticLayout(){
		//setSize(500,500);
		
		gridL = new GridLayout(3,2);
		flowL = new FlowLayout(FlowLayout.CENTER);
		
		setLayout(gridL);
		
		JPanel frame = new JPanel();
		//frame.setLayout(new GridLayout(3,2));
		frame.setLayout(new FlowLayout());
		
//		JPanel header = new JPanel();		
//		header.setLayout(new FlowLayout(FlowLayout.CENTER));
//		frame.add(header);
		
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(1,2,10,10));
		
		JPanel firstBoard = new JPanel();
		JPanel secondBoard = new JPanel();
		
		firstBoard.setLayout(new GridLayout(10,10));
		secondBoard.setLayout(new GridLayout(10,10));
		
		
		
		textFieldsTable1 = new JTextField[10][10];		
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable1[i][j] = new JTextField(2);
				firstBoard.add(textFieldsTable1[i][j]);
			}
		}
		
		textFieldsTable2 = new JTextField[10][10];		
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable2[i][j] = new JTextField(2);
				secondBoard.add(textFieldsTable2[i][j]);
			}
		}
		body.add(firstBoard);
		body.add(secondBoard);
		
		frame.add(body);
		add(frame);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		
		pack();
		setVisible(true);
	}
	
	void refreshFirstBoard(Board board){
		int[][] table = board.getBoard();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable1[i][j].setText(String.valueOf(table[i][j]));
			}
		}	
	}
	void refreshSecondBoard(Board board){
		int[][] table = board.getBoard();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable2[i][j].setText(String.valueOf(table[i][j]));
			}
		}
	}
	
	void refreshAll(Board board1, Board board2){
		int[][] table1 = board1.getBoard();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable2[i][j].setText(String.valueOf(table1[i][j]));
			}
		}
		int[][] table2 = board2.getBoard();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable2[i][j].setText(String.valueOf(table2[i][j]));
			}
		}
	}
	
// 	private void createBoard(){
//		textFieldsTable = new JTextField[10][10];		
//		for(int i=0; i<10; i++){
//			for(int j=0; j<10; j++){
//				textFieldsTable[i][j] = new JTextField();
//			}
//		}	
//	}
	
}
