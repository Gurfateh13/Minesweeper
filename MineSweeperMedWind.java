//adds the necessary packages
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
//MineSweeperMedWind is a JFrame that implements ActionListener and MineSweeperGUI
public class MineSweeperMedWind extends JFrame implements ActionListener, MineSweeperGUI{
//variables for the gui elements
  JLabel score;
  JLabel time;
  JButton startBt;
  JButton resetBt;
  JTextField nameText = new JTextField(20);
  //variables to track the score
  int secondsCount = 0;
  int flagsCount = 0;
  int correctflagsCount = 0;
  Timer timer  = new Timer();
  String name;
  int endScore;
  //values for size and number of flags needed to win
  int HEIGHT = 16;
  int WIDTH = 16;
  int NUMFLAGSNEEDED = 40;
  JButton[][] buttons =  new JButton[HEIGHT][WIDTH];
  //these look at the status of the game and whether or not buttons can be clicked
  boolean hasStarted = false;
  boolean gameWon = false;
  BOARDMAKER board;
  //constructor for the Easy Window 
  public MineSweeperMedWind() {
    //HEIGHT = height;
    //WIDTH = width;
    //NUMFLAGSNEEDED = numBombs;
    setLayout(new FlowLayout());    
    score = new JLabel("000");
    add(score);    
//creates the start button with the timer and changes hasStarted to true, allowing the game to begin
    startBt = new JButton("Start");
    startBt.addActionListener(new ActionListener(){
      //uses a timer to update the time label starting from 0 when the button is pushed to 999 seconds
      @Override
      public void actionPerformed(ActionEvent e){
        hasStarted = true;
        timer.schedule(new TimerTask() {
          @Override public void run() {
            if(secondsCount<999){
              secondsCount++;
              time.setText(String.format("%03d", secondsCount));
            }
            else{
             gameLost(); 
            }
          }
        }, 0L, 1000L);
        
        
      }
    });
    add(startBt);
    //saves the name to a string   
    nameText.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        String name = nameText.getText();
        //System.out.println(name);
      }
    });
    add(nameText);
//code for reset button    
    resetBt = new JButton("Reset");
    resetBt.addActionListener(new ActionListener(){
//stops and resets the timer and secondsCount and the board
      @Override
      public void actionPerformed(ActionEvent e){
        timer.cancel();
        timer.purge();
        secondsCount=0;
        time.setText(String.format("%03d", secondsCount));

        resetBoard();
        gameWon = false;
        timer  = new Timer();
        hasStarted = false;
        score.setText(String.format("%03d", 0));
        correctflagsCount = 0;
        flagsCount = 0;
        endScore = 0;
      }
    });
    add(resetBt);
    
    time = new JLabel("000");
    add(time);
    
//this segment of code generates a BOARDMAKER object to draw values from    
    //RandomNumGen gen = new RandomNumGen(0,63,10);
    board = new BOARDMAKER("medium");
    board.makeBoard();

//this code creates an array of JButtons
    JPanel gamePan = new JPanel();    
    GridLayout layout = new GridLayout(HEIGHT+1,WIDTH+1);   
    layout.setHgap(0);
    layout.setVgap(0);    
    gamePan.setLayout(layout);
    gamePan.setBackground(Color.GRAY);       
//goes through each button and adds an action depending on the corresponding tile
    for(int i = 0;i<HEIGHT;i++){
      for(int j= 0;j<WIDTH;j++){
        buttons[i][j]=new JButton();
        
//overrides the MouseListener methods
        buttons[i][j].addMouseListener(new MouseListener(){
          @Override
          public void mouseExited(MouseEvent e){}
          @Override
          public void mouseEntered(MouseEvent e){}
          @Override
          public void mouseReleased(MouseEvent e){}
          @Override
          public void mousePressed(MouseEvent e){}
          @Override
          public void mouseClicked(MouseEvent e)
          {
//checks if the game has begun
            if(hasStarted == true){
//left click action
            if (e.getButton() == MouseEvent.BUTTON1) {

              for(int i=0; i<HEIGHT; i++){
                for(int j=0; j<WIDTH; j++){
//code for if the tile is a bomb and is left clicked
                  if(e.getSource() == buttons[i][j] && board.getTile(i,j).getISBOMB()== true && buttons[i][j].getText().equals("")){
                    buttons[i][j].setText("B");
                    gameLost();
                  }
//code for if the tile has a number and is left clicked
                  else if(e.getSource() == buttons[i][j] && board.getTile(i,j).getHasNUM()==true && buttons[i][j].getText().equals("")){
                    Integer temp = new Integer(board.getTile(i,j).getNumTouch());                    
                    buttons[i][j].setText(temp.toString());
                  }
//code for if the tile is clear and is left clicked                  
                  else if(e.getSource() == buttons[i][j] && board.getTile(i,j).getHasNUM()==false && buttons[i][j].getText().equals("")){
                    board.getTile(i,j).setHIDDEN(false);
                    board.clearTiles(i,j);
//after using the clearTiles method from BOARDMAKER, ths goes through all of the tiles in board to reveal the ones
//that aren't hidden in board
                      for(int k=0; k<HEIGHT; k++){
                      for(int h=0; h<WIDTH; h++){
                        if(board.getTile(k,h).getHIDDEN() == false && board.getTile(k,h).getISBOMB()== false){
                          Integer temp = new Integer(board.getTile(k,h).getNumTouch());
                          buttons[k][h].setText(temp.toString());
                        }
                      }
                    }
                  }
                }
                
              }
            }
//middle button portion, useless, on some computers, the scrolling thing          
            else if(e.getButton() == MouseEvent.BUTTON2) {
              System.out.println("button2 clicked...");
            }
//right button portion, used for flags
            else if(e.getButton() == MouseEvent.BUTTON3) {
              for(int i=0; i<HEIGHT; i++){
                for(int j=0; j<WIDTH; j++){
//code for if the tile is a bomb and is flagged
                  if(e.getSource() == buttons[i][j] && board.getTile(i,j).getISBOMB()== true && buttons[i][j].getText().equals("")){
                    flagsCount++;
                    correctflagsCount++;
                    buttons[i][j].setText("F");
                    
                  }
//code for if the tile is a bomb and is unflagged                  
                  else if(e.getSource() == buttons[i][j] && board.getTile(i,j).getISBOMB()== true && buttons[i][j].getText().equals("F")){
                    flagsCount--;
                    correctflagsCount--;
                    buttons[i][j].setText("");
                    
                  }
//code for if the tile isn't a bomb and is flagged                   
                  else if (e.getSource() == buttons[i][j] && board.getTile(i,j).getISBOMB()!= true && buttons[i][j].getText().equals("")){
                    flagsCount++;
                    buttons[i][j].setText("F");
                  }
//code for if the tile isn't a bomb and is unflagged                  
                  else if (e.getSource() == buttons[i][j] && board.getTile(i,j).getISBOMB()!= true && buttons[i][j].getText().equals("F")){
                    flagsCount--;
                    buttons[i][j].setText("");
                  }
//updates the score label based on the amount of flags placed
        score.setText(String.format("%03d", flagsCount));
                }              
              }
            }
          }
            gameWonCheck();
        }
        });
        
        
        buttons[i][j].setPreferredSize(new Dimension(30, 30));;        
        
        buttons[i][j].setForeground(Color.RED);
        
        gamePan.add(buttons[i][j]);
        
        
      }      
    }
    
//adds the array of buttons to the panel
    this.getContentPane().add(gamePan);    
    this.getContentPane().setBackground(Color.GRAY);
    
  }
//reset method that resets the board 
  @Override
  public void resetBoard(){
    //RandomNumGen gen = new RandomNumGen(0,63,10);
    board = new BOARDMAKER("medium");
    board.makeBoard();

    for(int i = 0;i<HEIGHT;i++){
      for(int j= 0;j<WIDTH;j++){
        buttons[i][j].setText("");
        
      }
    }  
  }
//checks if the number of correct flags is equal to the number of bombs  
  public void gameWonCheck(){
    if(correctflagsCount == NUMFLAGSNEEDED && flagsCount == NUMFLAGSNEEDED){
     hasStarted = false;
     timer.cancel();
     reveal();
     endScore = secondsCount;
         //do something here with
    /*
     * name 
     * secondsCount
     * 
     * name is the name of the player and secondsCount is the score. Save this to a leaderboard
     */
     System.out.println("CONGRATULATIONS!!! YOU WON!!!");
     JOptionPane.showMessageDialog(null, "Congratulations! You have won!");
     correctflagsCount=0;
    }
  }
//method used to reveal all the tiles
  public void reveal()
  {
    for(int i = 0; i < HEIGHT; i++)
  {
     for(int j = 0; j < WIDTH; j++)
     {
       if(board.getTile(i,j).getHIDDEN() == true)
       {
         if(board.getTile(i,j).getISBOMB()== false)
         {
           board.getTile(i,j).setHIDDEN(false);
           Integer temp = new Integer(board.getTile(i,j).getNumTouch());
           buttons[i][j].setText(temp.toString());
         }
       }
     }
   } 
  }  
//method to implement if a bomb is left clicked  
  public void gameLost(){
    hasStarted = false;
    timer.cancel();
    for(int k=0; k<HEIGHT; k++){
      for(int h=0; h<WIDTH; h++){
        if(board.getTile(k,h).getISBOMB()== true){
          buttons[k][h].setText("B");
        }
      }
    }
    endScore = secondsCount;
    reveal();
    //do something here with
    /*
     * name 
     * secondsCount
     * 
     * name is the name of the player and secondsCount is the score. Save this to a leaderboard
     */
    System.out.println("Sorry you lost. Try Again?");
    JOptionPane.showMessageDialog(null, "Game Over.");
  }
  
  
//overrides the actionPerformed method for actionListener, essential so don't delete
  @Override
  public void actionPerformed(ActionEvent e){}    
}
