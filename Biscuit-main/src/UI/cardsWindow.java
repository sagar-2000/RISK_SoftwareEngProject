package UI;
/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class cardsWindow {
	JFrame frame = new JFrame("Cards");
	JButton Action = new JButton("Action");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	cardsWindow(){
		
		Action.setBounds(150,280,100,40);
		Action.setFocusable(false);
		Action.setBackground(new Color(169,169,140));
		Action.setFont(new Font("Comic Sans",Font.ITALIC,15));
		panel1.setBounds(50,40,135,200);
		panel1.setBackground(new Color(150,150,150));
		panel2.setBounds(220,40,135,200);
		panel2.setBackground(new Color(150,150,150));
		frame.getContentPane().setBackground(new Color(65,43,21));
		frame.add(panel1);
		frame.add(panel2);
		frame.add(Action);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

}
