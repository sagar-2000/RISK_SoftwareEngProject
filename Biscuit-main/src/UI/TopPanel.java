package UI;
/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TopPanel extends JPanel implements ActionListener {
	
	private JPanel p;
	
	private JButton cards,player1,player2;
	private JLabel lab;
	
	public TopPanel()
	{
		
		p = new JPanel();
		p.setBounds(250,20,90,40);
		p.setBackground(Color.white);
		setPreferredSize(new Dimension(100,100));
		setBackground(new Color(65,43,21));
	
		
		
		cards = new JButton("Cards");
		player1 = new JButton("player1");
		player2 = new JButton("player2");
		cards.setBounds(390,20,80,40);
		player1.setBounds(10,20,90,40);
		player2.setBounds(120,20,90,40);
		player1.setBackground(Color.red);
		player2.setBackground(Color.blue);
		player1.setFocusable(false);
		player2.setFocusable(false);
		
		
		
		cards.addActionListener(this);
		//add(cards,BorderLayout.EAST);
		setLayout(null);
		
		lab = new JLabel("Action");
		
		
		
		//p.setSize(200,200);
		//p.setBounds(0, 0, 100, 100);
		add(p);
		add(player1);
		add(player2);
		add(cards);
		p.add(lab);
		
		 	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cards) {
			//frame.dispose();
			new cardsWindow();
		}
		
	} 
				
	}


	
	
	
	


