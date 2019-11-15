/** Author: Diego "Max" Rivera 
 * This is the class that makes the grid of tile objects and populates them based on the users choices.
 * right now you must call the makeboard method after object creation, but I think i'm going to put this in
 * the constructor for future improvements to streamline operation.
 * */
import java.util.ArrayList;

public class BOARDMAKER{
  //This is the main board object. A 2D array of TILE object
  public TILE[][] BOARD;
  //This represents the difficulty, it can only be one of the following(hard, medium, easy)
  public String difficulty;
  //for now numMines is linked to difficulty, being either (99,40,10)
  public int numMines;
  
  //the default constructor is easy
  public BOARDMAKER(){
    this.difficulty = "easy";
    this.mineCalc(this.difficulty);
  }
  public BOARDMAKER(String difficulty){
    this.difficulty = difficulty;
    this.mineCalc(this.difficulty);
  }
  public void setDifficulty(String difficulty){this.difficulty = difficulty;}
  public String getDifficulty(){return this.difficulty;}
  
  //This tells you how many mines there are based on the difficulty. We probably can cut this from future versions
  public void mineCalc(String difficulty){
    if(difficulty.equals("easy")){
      this.numMines = 10;
    }
    else if (difficulty.equals("medium")){
      this.numMines = 40;
    }
    else if (difficulty.equals("hard")){
      this.numMines = 99;
    }
    else
      numMines = 10;
  }
  
  /** This method is the main method of boardmaker, it makes the board size based on the difficulty then filles it
    * with clear tile objects,afterwards, it replaces some of the clear tiles with bombs that it gets the
    * locations from randomNumGen class.
    * */
  public void makeBoard(){
    //Hard doesn't work right now
    if(difficulty.equals("hard")){
      BOARD = new TILE[16][36];
      for(int i = 0; i < 16; i++){
        for(int j = 0; j < 36; j++){
          BOARD[i][j] = new TILE();
        }
      }
      int[] mines = this.mineLocationCalc(difficulty);
      for(int i = 0; i < mines.length; i++){
        BOARD[mines[i]/16][mines[i]%36].setISBOMB(true);
      } 
    }
    
    else if(difficulty.equals("medium")){
      BOARD = new TILE[16][16];
      for(int i = 0; i < 16; i++){
        for(int j = 0; j < 16; j++){
          BOARD[i][j] = new TILE();
        }
      }
      int[] mines = this.mineLocationCalc(difficulty);
      for(int i = 0; i < mines.length; i++){
        BOARD[mines[i]/16][mines[i]%16].setISBOMB(true);
      } 
    }
    
    else{
      BOARD = new TILE[8][8];
      this.difficulty = "easy";
      for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          BOARD[i][j] = new TILE();
        }
      }
      int[] mines = this.mineLocationCalc(difficulty);
      for(int i = 0; i < mines.length; i++){
        BOARD[mines[i]/8][mines[i]%8].setISBOMB(true);
      } 
    }
  }
  
  //this will return an array of integers representing locations for the bombs that it gets from randomNumGen class
  public int[] mineLocationCalc(String difficulty){
    if(difficulty.equals("hard")){
      RandomNumGen gen = new RandomNumGen(0,575,99);
      return gen.numGen();
     
    }
    
    else if(difficulty.equals("medium")){
     RandomNumGen gen = new RandomNumGen(0,255,40);
     return gen.numGen();
    }
    
    else{
      RandomNumGen gen = new RandomNumGen(0,63,10);
     return gen.numGen();
    }
  }
  
  @Override
  public String toString(){
      String boardString ="";
      for(int i = 0; i < BOARD.length; i++){
        for(int j = 0; j < BOARD[i].length; j++){
          //boardString+= BOARD.get(i).get(j).toString();
          boardString += BOARD[i][j].toString();
        }
        boardString+= "\n";
      }
    return boardString;
  }
}