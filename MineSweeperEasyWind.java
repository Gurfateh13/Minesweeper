import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MineSweeperEasyWind extends JFrame implements ActionListener {
  private JLabel score;
  private JLabel time;
  private JButton startBt;
  private JButton resetBt;
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
    
    startBt = new JButton("Start");
    add(startBt);
    
    resetBt = new JButton("Reset");
    add(resetBt);
    
    time = new JLabel("000");
    add(time);
    
    //code for boxes  
    JPanel gamePan = new JPanel();
    
    GridLayout layout = new GridLayout(9,9);
    
    
    layout.setHgap(0);
    layout.setVgap(0);
    
    gamePan.setLayout(layout);
    gamePan.setBackground(Color.GRAY);
    
    //this part is taken from the BOARDMAKER class
    RandomNumGen gen = new RandomNumGen(0,63,10);
    BOARDMAKER board = new BOARDMAKER("easy");
    board.makeBoard();
    board.appointNum();
    board.appointCornerNum();
    board.appointEdgeNum();
    
    //this creates the board and sets values to the JButtons
    for(int i = 0;i<8;i++){
      for(int j= 0;j<8;j++){
        if(board.getTile(i,j).getISBOMB()== true){
          buttons[i][j]=new JButton("BOMB");
        }
        else{
          Integer num = new Integer(board.getTile(i,j).getNumTouch());
          buttons[i][j]=new JButton(num.toString());

        }

        buttons[i][j].setPreferredSize(new Dimension(48, 48));;
        
        //buttons[i][j].setBackground(Color.BLACK);
        buttons[i][j].setForeground(Color.WHITE);
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
