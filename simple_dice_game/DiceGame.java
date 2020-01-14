import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class DiceGame extends JFrame implements ActionListener {
	// create a container for the objects 
	private Container container;
	// create a button
	private JButton button;
	private JButton betOne;
	private JButton betFive;
	private JButton betTen;
	private JButton betTwentyFive;
	private JButton betHundred;
	// create a textfield
	private JTextField textfield;
	private int balance;
	private JLabel showBetTotal;
	private JLabel showRule;
	private JLabel showBalance;
	private ImageIcon[] dices;
	private ImageIcon one;
	private ImageIcon five;
	private ImageIcon ten;
	private ImageIcon twentyFive;
	private ImageIcon hundred;
	
	private int betTotal;

	public DiceGame() {
		// Container to store everything needed for the frame
		container = getContentPane();
		// set out the layout
		container.setLayout(new FlowLayout());
		balance = 1000;
		// creat label for chip balance
		showBalance = new JLabel("                Chip Balance: $" + balance + "               ");
		// set text color
		showBalance.setForeground(Color.WHITE);
		showBalance.setFont(new Font("Default", Font.CENTER_BASELINE, 20));
		// add it to the container
		container.add(showBalance);
		// create a label
		showBetTotal = new JLabel("                        Total Bet: $" + betTotal + "                     ");
		// set text color
		showBetTotal.setForeground(Color.WHITE);
		showBetTotal.setFont(new Font("Default", Font.CENTER_BASELINE, 20));
		// add it to the container
		container.add(showBetTotal);
		
		dices = new ImageIcon[6];
		dices[0] = new ImageIcon("diceOne.png");
		dices[1] = new ImageIcon("diceTwo.png");
		dices[2] = new ImageIcon("diceThree.png");
		dices[3] = new ImageIcon("diceFour.png");
		dices[4] = new ImageIcon("diceFive.png");
		dices[5] = new ImageIcon("diceSix.png");
		
		one = new ImageIcon("chipOne.png");
		five = new ImageIcon("chipFive.png");
		ten = new ImageIcon("chipTen.png");
		twentyFive = new ImageIcon("chipTwentyFive.png");
		hundred = new ImageIcon("chipHundred.png");
		
		betOne = new JButton(one);
		betFive = new JButton(five);
		betTen = new JButton(ten);
		betTwentyFive = new JButton(twentyFive);
		betHundred = new JButton(hundred);
		
		betOne.setSize(3000, 300);
		betOne.setVisible(true);
		
		betOne.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(balance < 1)
		    		JOptionPane.showMessageDialog(null, "You don'thave enough chips!");
		    	else {
		    		betTotal += 1;
			    	balance -= 1;
			    	// refresh texts
			    	showBetTotal.setText("                        Total Bet: $" + betTotal + "                     ");
			    	showBalance.setText("                Chip Balance: $" + balance + "               ");
		    	}
		    }
		});
		
		betFive.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(balance < 5)
		    		JOptionPane.showMessageDialog(null, "You don'thave enough chips!");
		    	else {
		    		betTotal += 5;
			    	balance -= 5;
			    	// refresh texts
			    	showBetTotal.setText("                        Total Bet: $" + betTotal + "                     ");
			    	showBalance.setText("                Chip Balance: $" + balance + "               ");
		    	}
		    }
		});
		
		betTen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(balance < 10)
		    		JOptionPane.showMessageDialog(null, "You don'thave enough chips!");
		    	else {
		    		betTotal += 10;
		    		balance -= 10;
		    		// refresh texts
		    		showBetTotal.setText("                        Total Bet: $" + betTotal + "                     ");
		    		showBalance.setText("                Chip Balance: $" + balance + "               ");
		    	}
		    }
		});
		
		betTwentyFive.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(balance < 25)
		    		JOptionPane.showMessageDialog(null, "You don'thave enough chips!");
		    	else {
		    		betTotal += 25;
		    		balance -= 25;
		    		// refresh texts
		    		showBetTotal.setText("                        Total Bet: $" + betTotal + "                     ");
		    		showBalance.setText("                Chip Balance: $" + balance + "               ");
		    	}
		    }
		});
		
		betHundred.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(balance < 100)
		    		JOptionPane.showMessageDialog(null, "You don'thave enough chips!");
		    	else {
		    		betTotal += 100;
		    		balance -= 100;
		    		// refresh texts
		    		showBetTotal.setText("                        Total Bet: $" + betTotal + "                     ");
		    		showBalance.setText("                Chip Balance: $" + balance + "               ");
		    	}
		    }
		});
		
		betOne.setBorder(new RoundedBorder(10));
		betOne.setForeground(Color.decode("#006600"));
		betFive.setBorder(new RoundedBorder(10));
		betFive.setForeground(Color.decode("#006600"));
		betTen.setBorder(new RoundedBorder(10));
		betTen.setForeground(Color.decode("#006600"));
		betTwentyFive.setBorder(new RoundedBorder(10));
		betTwentyFive.setForeground(Color.decode("#006600"));
		betHundred.setBorder(new RoundedBorder(10));
		betHundred.setForeground(Color.decode("#006600"));
		
		container.add(betOne);
		container.add(betFive);
		container.add(betTen);
		container.add(betTwentyFive);
		container.add(betHundred);
		
		betTotal = 0;
		
		showRule = new JLabel("          (7 or 11 Pays 2 to 1)          ");
		// set text color
		showRule.setForeground(Color.WHITE);
		showRule.setFont(new Font("Default", Font.CENTER_BASELINE, 20));
		// add it to the container
		container.add(showRule);
		
		// create a new button
		button = new JButton("Roll The Dice");
		button.addActionListener(this);
		button.setFont(new Font("Default", Font.CENTER_BASELINE, 14));
		button.setForeground(Color.DARK_GRAY);
		button.setPreferredSize(new Dimension(150, 50));
		// add the button to the container
		container.add(button);
		
	}

	// Method in the actionlistener interface
	public void actionPerformed(ActionEvent a) {
		// generate random numbers from 1 to 6
		int dice1 = 1 + (int) (Math.random() * 6);
		int dice2 = 1 + (int) (Math.random() * 6);
		
		if(betTotal == 0)
    			JOptionPane.showMessageDialog(null, "Place your bet first!");
		else if((dice1 + dice2) == 7 || (dice1 + dice2) == 11) {
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, dices[dice1-1]);
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, dices[dice2-1]);
			JOptionPane.showMessageDialog(null, dice1 + " + " + dice2 + " = " + (dice1 + dice2) + "\n" + "You Just Won $" + (betTotal * 3), "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
			balance += betTotal * 3;
		}
		else {
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, dices[dice1-1]);
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, dices[dice2-1]);
			JOptionPane.showMessageDialog(null, dice1 + " + " + dice2 + " = " + (dice1 + dice2) + "\n" + "You Lost the bet, Sorry!", "Unlucky!", JOptionPane.INFORMATION_MESSAGE);
		}
		betTotal = 0;
		showBalance.setText("                Chip Balance: $" + balance + "               ");
		showBetTotal.setText("                        Total Bet: $" + betTotal + "                     ");		
		if(balance == 0) {
			JOptionPane.showMessageDialog(null, "Game Over!");
			balance = 1000;
			showBalance.setText("                Chip Balance: $" + balance + "               ");
		}
	}
	
	class RoundedBorder implements Border {
	    private int radius;

	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }

	    public boolean isBorderOpaque() {
	        return true;
	    }

	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}

	public static void main(String [] args) {
		// create a object
		DiceGame diceGame = new DiceGame();
		// set the title of the frame
		diceGame.setTitle("Dice Game");   
		// set the background color
		diceGame.getContentPane().setBackground(Color.decode("#006600"));
		// set the size of the frame
		diceGame.setSize(500, 270);
		// set the frame to be visible
		diceGame.setVisible(true);
		// set the way to close the frame
		diceGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
}
