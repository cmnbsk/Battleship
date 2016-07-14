import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DiagnosticLayout extends JFrame implements ActionListener{
	
	JTextField[][] textFieldsTable1;
	JTextField[][] textFieldsTable2;
	GridLayout gridL;
	FlowLayout flowL;
	JLabel title, tura;
	JTextField xField, yField;
	JButton shoot;
	
	DiagnosticLayout(){
		//setSize(500,500);
		
		gridL = new GridLayout(1,2);
		flowL = new FlowLayout(FlowLayout.CENTER);
		
		setLayout(gridL);
		
		JPanel frame = new JPanel();
		//frame.setLayout(new GridLayout(3,2));
		frame.setLayout(new GridLayout(3,1));
		
		JPanel header = new JPanel();		
		header.setLayout(new FlowLayout(FlowLayout.CENTER));
		title = new JLabel();
		title.setText("Tura gracza: ");
		header.add(title);		
		
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(1,2,10,0));
		
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
		
		JPanel footer = new JPanel();
		footer.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel xLabel = new JLabel("X:");
		JLabel yLabel = new JLabel("Y:");
		tura = new JLabel("Tura gracza: ");
		xField = new JTextField(4);
		yField = new JTextField(4);
		shoot = new JButton("Strza³");
		shoot.addActionListener(this);
		footer.add(tura);		
		footer.add(xLabel);
		footer.add(xField);
		footer.add(yLabel);
		footer.add(yField);
		footer.add(shoot);
		
				
		//frame.add(header);
		frame.add(body);
		frame.add(footer);
		add(frame);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		
		pack();
		setVisible(true);
	}
	
	int [] getCoordinates(){
		try{
			int x = Integer.parseInt(xField.getText());
			int y = Integer.parseInt(yField.getText());			
			int[] table = {x,y};
			return table;
		}catch (Exception ex){
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		return null;
	}
	
	void setRound(int tura){		
		if(tura==1){
			this.tura.setText("Tura gracza: 1");
		}else if(tura==2){
			this.tura.setText("Tura gracza: 2");
		}else
			this.tura.setText("B³¹d!");
	}
	
	void nextRound(){
		if(tura.getText()=="Tura gracza: 1"){
			tura.setText("Tura gracza: 2");
		}else{
			tura.setText("Tura gracza: 1");
		}
	}
	
	void refreshFirstBoard(Board board){
		int[][] table = board.getBoard();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable1[i][j].setText(String.valueOf(table[j][i]));
			}
		}	
	}
	void refreshSecondBoard(Board board){
		int[][] table = board.getBoard();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				textFieldsTable2[i][j].setText(String.valueOf(table[j][i]));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Battleship.nextAiRound();
		
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
