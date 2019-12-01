/** 
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
  
  
  public void appointNum(){
    for (int row = 1; row < 7; row++){
      for (int col = 1; col < 7; col++){
          TILE current_tile = BOARD[row][col];
          if(current_tile.ISBOMB == false){
            
            TILE temp_tile = BOARD[row-1][col-1];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++ ;
            }
            
            temp_tile = BOARD[row-1][col];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++ ;
            }
            
            temp_tile = BOARD[row-1][col+1];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++;
            }

            temp_tile = BOARD[row][col-1];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++;
            }
            
            temp_tile = BOARD[row][col+1];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++;
            }
            
            temp_tile = BOARD[row+1][col-1];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++;
            }
            temp_tile = BOARD[row+1][col];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++;
            }
            
            temp_tile = BOARD[row+1][col+1];
            if (temp_tile.ISBOMB == true){
              BOARD[row][col].setHasNum(true);
              BOARD[row][col].numTouch++;
          }
          else{ continue;}
          
          }
      }
    }
  }
  
  public void appointCornerNum(){
    TILE first_corner_tile = BOARD[0][0];
    if(first_corner_tile.ISBOMB == false){
      TILE temp_tile = BOARD[0][1];
      if (temp_tile.ISBOMB == true){
        BOARD[0][0].setHasNum(true);
        BOARD[0][0].numTouch++ ;
      }
      temp_tile = BOARD[1][1];
      if (temp_tile.ISBOMB == true){
        BOARD[0][0].setHasNum(true);
        BOARD[0][0].numTouch++ ;
      }
      temp_tile = BOARD[1][0];
      if (temp_tile.ISBOMB == true){
        BOARD[0][0].setHasNum(true);
        BOARD[0][0].numTouch++ ;
      }
      
      
      TILE second_corner_tile = BOARD[0][7];
      if(second_corner_tile.ISBOMB == false){
        temp_tile = BOARD[0][6];
        if (temp_tile.ISBOMB == true){
          BOARD[0][7].setHasNum(true);
          BOARD[0][7].numTouch++ ;
        }
        temp_tile = BOARD[1][6];
        if (temp_tile.ISBOMB == true){
          BOARD[0][7].setHasNum(true);
          BOARD[0][7].numTouch++ ;
        }
        temp_tile = BOARD[1][7];
        if (temp_tile.ISBOMB == true){
          BOARD[0][7].setHasNum(true);
          BOARD[0][7].numTouch++ ;
        }
      }
      TILE third_corner_tile = BOARD[7][0];
      if(third_corner_tile.ISBOMB == false){
        temp_tile = BOARD[6][0];
        if (temp_tile.ISBOMB == true){
          BOARD[7][0].setHasNum(true);
          BOARD[7][0].numTouch++ ;
        }
        temp_tile = BOARD[6][1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][0].setHasNum(true);
          BOARD[7][0].numTouch++ ;
        }
        temp_tile = BOARD[6][1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][0].setHasNum(true);
          BOARD[7][0].numTouch++ ;
        }
      }
      
      TILE fourth_corner_tile = BOARD[7][7];
      if(fourth_corner_tile.ISBOMB == false){
        temp_tile = BOARD[6][7];
        if (temp_tile.ISBOMB == true){
          BOARD[7][7].setHasNum(true);
          BOARD[7][7].numTouch++ ;
        }
        temp_tile = BOARD[6][6];
        if (temp_tile.ISBOMB == true){
          BOARD[7][7].setHasNum(true);
          BOARD[7][7].numTouch++ ;
        }
        temp_tile = BOARD[7][6];
        if (temp_tile.ISBOMB == true){
          BOARD[7][7].setHasNum(true);
          BOARD[7][7].numTouch++ ;
        }
      }
    }
  }
  
  public void appointEdgeNum(){
    for (int col = 1; col <7; col++){
      TILE current_tile = BOARD[0][col];
      if(current_tile.ISBOMB == false){
        TILE temp_tile = BOARD[0][col-1];
        if (temp_tile.ISBOMB == true){
          BOARD[0][col].setHasNum(true);
          BOARD[0][col].numTouch++ ;
        }
        temp_tile = BOARD[0][col+1];
        if (temp_tile.ISBOMB == true){
          BOARD[0][col].setHasNum(true);
          BOARD[0][col].numTouch++ ;
        }
        temp_tile = BOARD[1][col-1];
        if (temp_tile.ISBOMB == true){
          BOARD[0][col].setHasNum(true);
          BOARD[0][col].numTouch++ ;
        }
        temp_tile = BOARD[1][col];
        if (temp_tile.ISBOMB == true){
          BOARD[0][col].setHasNum(true);
          BOARD[0][col].numTouch++ ;
        }
        temp_tile = BOARD[1][col+1];
        if (temp_tile.ISBOMB == true){
          BOARD[0][col].setHasNum(true);
          BOARD[0][col].numTouch++ ;
        }
      }
    }
    for (int col = 1; col <7; col++){
      TILE current_tile = BOARD[7][col];
      if(current_tile.ISBOMB == false){
        TILE temp_tile = BOARD[7][col-1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][col].setHasNum(true);
          BOARD[7][col].numTouch++ ;
        }
        temp_tile = BOARD[7][col+1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][col].setHasNum(true);
          BOARD[7][col].numTouch++ ;
        }
        temp_tile = BOARD[6][col-1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][col].setHasNum(true);
          BOARD[7][col].numTouch++ ;
        }
        temp_tile = BOARD[6][col];
        if (temp_tile.ISBOMB == true){
          BOARD[7][col].setHasNum(true);
          BOARD[7][col].numTouch++ ;
        }
        temp_tile = BOARD[6][col+1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][col].setHasNum(true);
          BOARD[7][col].numTouch++ ;
        }
      }
    }
    
    for (int row = 1; row <7; row++){
      TILE current_tile = BOARD[row][0];
      if(current_tile.ISBOMB == false){
        TILE temp_tile = BOARD[row-1][0];
        if (temp_tile.ISBOMB == true){
          BOARD[row][0].setHasNum(true);
          BOARD[row][0].numTouch++ ;
        }
        temp_tile = BOARD[row+1][0];
        if (temp_tile.ISBOMB == true){
          BOARD[row][0].setHasNum(true);
          BOARD[row][0].numTouch++ ;
        }
        temp_tile = BOARD[row-1][1];
        if (temp_tile.ISBOMB == true){
          BOARD[row][0].setHasNum(true);
          BOARD[row][0].numTouch++ ;
        }
        temp_tile = BOARD[row][1];
        if (temp_tile.ISBOMB == true){
          BOARD[row][0].setHasNum(true);
          BOARD[row][0].numTouch++ ;
        }
        temp_tile = BOARD[row+1][1];
        if (temp_tile.ISBOMB == true){
          BOARD[row][0].setHasNum(true);
          BOARD[row][0].numTouch++ ;
        }
      }
    }
    
    for (int row = 1; row <7; row++){
      TILE current_tile = BOARD[row][7];
      if(current_tile.ISBOMB == false){
        TILE temp_tile = BOARD[row-1][7];
        if (temp_tile.ISBOMB == true){
          BOARD[row][7].setHasNum(true);
          BOARD[row][7].numTouch++ ;
        }
        temp_tile = BOARD[row+1][7];
        if (temp_tile.ISBOMB == true){
          BOARD[row][7].setHasNum(true);
          BOARD[row][7].numTouch++ ;
        }
        temp_tile = BOARD[row-1][6];
        if (temp_tile.ISBOMB == true){
          BOARD[row][7].setHasNum(true);
          BOARD[row][7].numTouch++ ;
        }
        temp_tile = BOARD[row][6];
        if (temp_tile.ISBOMB == true){
          BOARD[row][7].setHasNum(true);
          BOARD[row][7].numTouch++ ;
        }
        temp_tile = BOARD[row+1][6];
        if (temp_tile.ISBOMB == true){
          BOARD[row][7].setHasNum(true);
          BOARD[row][7].numTouch++ ;
        }
      }
    }
        
        
        
        
        
  }     
          
  //this returns the requested tile from the board  
  public TILE getTile(int x, int y){
    return BOARD[x][y];
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
