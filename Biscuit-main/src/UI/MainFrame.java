package UI;
/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ENGINE.GameManager;
import ENGINE.constants;

public class MainFrame extends JFrame{
	
	JFrame mainFM;
	public JPanel p1,p2,p3,p4,p5;
	public bottom userInputUI;
	public JTextField txtInput;
	public GameManager gm;
	public Map map;
	public TopPanel topPanel;
	
	public MainFrame(String title, Rectangle bounds) {
		init(title,bounds);
	}
	public MainFrame() {
		init("Title" ,new Rectangle(100,100,1500,1000));
	}
	public MainFrame(GameManager g) {
		this.gm = g;
		init("Risk" ,new Rectangle(100,100,constants.FRAME_WIDTH,constants.FRAME_HEIGHT));
	}
	
	public void SetGameManager(GameManager gm) {
		this.gm = gm;
	}
	
	public void init(String t, Rectangle bounds) {
		
		mainFM = new JFrame();
		mainFM.setTitle(t);
		mainFM.setSize(getPreferredSize());
		mainFM.setBounds(bounds);
		mainFM.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFM.setLocationRelativeTo(null);
		mainFM.setResizable(false);
	
		
		Graphics g = this.getGraphics();
		
		map = new Map(g, gm); 

		JPanel panel1 = new JPanel(); // acts as padding for now
	    topPanel = new TopPanel();
		JPanel panel2 = new JPanel(); // acts as padding for now
		JPanel panel3 = new JPanel(); // acts as padding for now
		
	    userInputUI = new bottom(getGraphics(), gm);
		JPanel panel5 = new JPanel();
		
		panel1.setBackground(Color.red);
//		panel2.setBackground(Color.green);
//		panel3.setBackground(Color.yellow);
//		panel4.setBackground(Color.magenta);
		panel5.setBackground(Color.blue);
		
		//Set Dimensions
		panel1.setPreferredSize(new Dimension(100,100));
		panel2.setPreferredSize(new Dimension(100,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel5.setPreferredSize(new Dimension(100,100));

		//adding components
		mainFM.add(topPanel, BorderLayout.NORTH);
		mainFM.add(panel2, BorderLayout.WEST);
		mainFM.add(panel3, BorderLayout.EAST);
		mainFM.add(userInputUI, BorderLayout.SOUTH);
		mainFM.add(map, BorderLayout.CENTER);
		
		mainFM.setVisible(true);
		
		
	}
	

}
