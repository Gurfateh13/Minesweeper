import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MineSweeperEasyWind extends JFrame implements ActionListener{
  JLabel score;
  JLabel time;
  JButton startBt;
  JButton resetBt;
  int count = 0;
  //private JTextField textfield;
  Timer timer  = new Timer();
  JButton[][] buttons =  new JButton[8][8];
  //constructor  
  public MineSweeperEasyWind() {
    setLayout(new FlowLayout());
    
    score = new JLabel("000");
    add(score);
    
    
//creates the start button
    startBt = new JButton("Start");
    startBt.addActionListener(new ActionListener(){
      //uses a timer to update the time label starting from 0 when the button is pushed to 999 seconds
      @Override
      public void actionPerformed(ActionEvent e){
        timer.schedule(new TimerTask() {
          @Override public void run() {
            if(count<999){
              count++;
              time.setText(String.format("%03d", count));
            }
          }
        }, 0L, 1000L);
        
        
      }
    });
    add(startBt);
    
    
    resetBt = new JButton("Reset");
    resetBt.addActionListener(new ActionListener(){
//stops and resets the timer and count
      @Override
      public void actionPerformed(ActionEvent e){
        timer.cancel();
        timer.purge();
        count=0;
        time.setText(String.format("%03d", count));
        assignValues();
        timer  = new Timer();
      }
    });
    add(resetBt);
    
    time = new JLabel("000");
    add(time);
    
    JPanel gamePan = new JPanel();    
    GridLayout layout = new GridLayout(9,9);   
    layout.setHgap(0);
    layout.setVgap(0);    
    gamePan.setLayout(layout);
    gamePan.setBackground(Color.GRAY);    
    
    
    //this creates the board and sets values to the JButtons
    for(int i = 0;i<8;i++){
      for(int j= 0;j<8;j++){
        buttons[i][j]=new JButton();
        buttons[i][j].setPreferredSize(new Dimension(48, 48));;        
        
        buttons[i][j].setForeground(Color.RED);
        
        gamePan.add(buttons[i][j]);        
      }      
    }   
    this.assignValues();
    this.getContentPane().add(gamePan);    
    this.getContentPane().setBackground(Color.GRAY);
    
  }
  
  //function that assigns values based on the BOARDMAKER class
  public void assignValues(){
    RandomNumGen gen = new RandomNumGen(0,63,10);
    BOARDMAKER board = new BOARDMAKER("easy");
    board.makeBoard();
    board.appointNum();
    board.appointCornerNum();
    board.appointEdgeNum();
    
    for(int i = 0;i<8;i++){
      for(int j= 0;j<8;j++){
        if(board.getTile(i,j).getISBOMB()== true){
          buttons[i][j].setText("BOMB");
          buttons[i][j].setHideActionText(true);
        }
        else{
          Integer num = new Integer(board.getTile(i,j).getNumTouch());
          buttons[i][j].setText(num.toString());
          buttons[i][j].setHideActionText(true);
        }
      }
    }
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e){}  
  
  
}