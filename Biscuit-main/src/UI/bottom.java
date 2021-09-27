package UI;

/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ENGINE.GameManager;
import UI.log;

public class bottom extends JPanel {

    final int FIELD_WIDTH = 50;
    static JPanel b;
    public JTextField MoveField;
    public static String Move;

    public GameManager GM;
    public log lg;

    public bottom(Graphics g, GameManager gm) {
    	this.GM = gm;
        init(g);

    }
    public void init(Graphics g){

        b = new JPanel();
      
        lg = new log(g, GM);


        b.setBackground(Color.black);
        b.setBounds(0,0,100,50);

        setLayout(new GridBagLayout());

        JLabel MoveLabel = new JLabel("command: ");
        MoveField = new JTextField(FIELD_WIDTH);

        add(lg);
        add(MoveLabel);
        add(MoveField);

        JButton button = createButton();
        add(button);



    }

    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.RED);

    }


    class AddInterestListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
            GM.playCommand(MoveField.getText().toString());
            
            
        }
    }
    private JButton createButton() {
        JButton button = new JButton("go");
        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);

        return button;
    }
}

