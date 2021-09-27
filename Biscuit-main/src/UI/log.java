package UI;

import javax.swing.*;

import ENGINE.GameManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
public class log extends JPanel {


    static JPanel p;
    public JTextArea log_area;

    final static int ROWS = 10; // Lines of text
    final static int COLUMNS = 50; // Characters in each row
    
    public GameManager gm;
    public log(Graphics g, GameManager gm) {
    	this.gm = gm;
        init(g);
    }

  
    
    public void init(Graphics g){

        p = new JPanel();
        p.setBackground(Color.red);


        setLayout(new FlowLayout());



        log_area = new JTextArea(ROWS, COLUMNS);

        log_area.setBackground(Color.black);
        if(gm.currentPlayer() != null) {setForeground(gm.currentPlayer().color);}else {setForeground(Color.white);}
        
        log_area.setEditable(false);

        add(log_area);

    }

    public void updateText(String s){
    	
    	log_area.setForeground(gm.currentPlayer().color);
    	log_area.append(s+"\n");
    }
}



