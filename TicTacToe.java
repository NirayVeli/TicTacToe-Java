import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

	Random random = new Random(); 
	JFrame frame = new JFrame();
	JPanel panelTitle = new JPanel();
	JPanel panelButton = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean P1_turn;
	boolean P2_turn;
	
	TicTacToe(){
		
		frame.setSize(700,700);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		textfield.setBackground(new Color(30,30,30));
		textfield.setForeground(new Color (30,255,30));
		textfield.setFont(new Font("Dialog",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		panelTitle.setLayout(new BorderLayout());
		panelTitle.setBounds(0,0,900,100);
		
		panelButton.setLayout(new GridLayout(3,3));
		panelButton.setBackground(new Color(125,125,125));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			panelButton.add(buttons[i]);
			buttons[i].setFont(new Font("Serif",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		panelTitle.add(textfield);
		frame.add(panelTitle,BorderLayout.NORTH);
		frame.add(panelButton);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			
			if(e.getSource()== buttons[i]) {
				if(P1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setText("X");
						buttons[i].setForeground(Color.BLUE);
						P1_turn = false;
						P2_turn = true;
						textfield.setText("Player 2 turn");
						check();
					}
				}
				else if(P2_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setText("O");
						buttons[i].setForeground(Color.RED);
						P1_turn = true;
						P2_turn = false;
						textfield.setText("Player 1 turn");
						check();
					}
				}
			}	
		}
	}
	
	public void firstTurn() {
		
		disabledButtons();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		enabledButtons();
		
		if(random.nextInt(2) == 0) {
			P1_turn = true;
			P2_turn = false;
			textfield.setText("Player 1 (X) turn");
		}
		
		else {
			P1_turn = false;
			P2_turn = true;
			textfield.setText("Player 2 (O) turn");
		}
	}
	
	// End the game
	
	public void disabledButtons() {
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
	}
	
	// Start the game
	
	public void enabledButtons() {
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(true);
		}
	}
	
	public void check() {
		
		//check if X wins
		
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
		        (buttons[2].getText()=="X")
				) {
			xWins(0,1,2); 
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
		        (buttons[5].getText()=="X")
				) {
			xWins(3,4,5); 
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
		        (buttons[8].getText()=="X")
				) {
			xWins(6,7,8); 
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
		        (buttons[6].getText()=="X")
				) {
			xWins(0,3,6); 
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
		        (buttons[7].getText()=="X")
				) {
			xWins(1,4,7); 
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
		        (buttons[8].getText()=="X")
				) {
			xWins(2,5,8); 
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
		        (buttons[8].getText()=="X")
				) {
			xWins(0,4,8); 
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
		        (buttons[6].getText()=="X")
				) {
			xWins(2,4,6); 
		}
		
		// Check if O wins
		
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
		        (buttons[2].getText()=="O")
				) {
			oWins(0,1,2); 
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
		        (buttons[5].getText()=="O")
				) {
			oWins(3,4,5); 
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
		        (buttons[8].getText()=="O")
				) {
			oWins(6,7,8); 
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
		        (buttons[6].getText()=="O")
				) {
			oWins(0,3,6); 
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
		        (buttons[7].getText()=="O")
				) {
			oWins(1,4,7); 
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
		        (buttons[8].getText()=="O")
				) {
			oWins(2,5,8); 
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
		        (buttons[8].getText()=="O")
				) {
			oWins(0,4,8); 
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
		        (buttons[6].getText()=="O")
				) {
			oWins(2,4,6); 
		}
}
	
	public void xWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		disabledButtons();
		textfield.setText("Player 1 (X) wins");
	}
	
	public void oWins(int a, int b, int c) {
			
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		disabledButtons();
		textfield.setText("Player 2 (O) wins");
	}
	
}

/*
 * Add tie condition
 * Maybe add like reset button or something
 * Add Scoreboard
 */

