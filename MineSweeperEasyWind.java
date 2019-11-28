import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MineSweeperEasyWind extends JFrame implements ActionListener {
  private JLabel score;
  private JButton button;
  private JTextField textfield;
  private JButton[][] buttons =  new JButton[8][8];
  //constructor  
  public MineSweeperEasyWind() {
    setLayout(new FlowLayout());
    
    score = new JLabel("000");
    //score.setLocation(20,20);
    //label.setOpaque(false);
    add(score);
    
    //textfield = new JTextField(15);
    //label.setOpaque(false);
    //add(textfield);
    
    button = new JButton("Start");
    add(button);
    
    //code for boxes  
    JPanel gamePan = new JPanel();
    
    GridLayout layout = new GridLayout(9,9);
    
    
    layout.setHgap(0);
    layout.setVgap(0);
    
    gamePan.setLayout(layout);
    gamePan.setBackground(Color.GRAY);
    
    for(int i = 0;i<8;i++){
      for(int j= 0;j<8;j++){
        buttons[i][j]=new JButton();
        buttons[i][j].setPreferredSize(new Dimension(48, 48));;
        //buttons[i][j].setBackground(Color.BLACK);
        buttons[i][j].setForeground(Color.RED);
        //buttons[i][j].setOpaque(true);
        
        gamePan.add(buttons[i][j]);
        
      }
      
    }
    //buttons[1][1].setVisible(false);
    //buttons[1][1] = new JButton("4");
    
    this.getContentPane().add(gamePan);
    
    this.getContentPane().setBackground(Color.GRAY);
    
  }
  
  public void actionPerformed(ActionEvent ae) {}
  
  
}
