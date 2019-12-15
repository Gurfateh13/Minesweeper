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
  //boolean for keeping track of wether the game is over
  public boolean gameOver = false;
  //NEW CONCEPT strictly for handling clearing tile logic
  //all this is a 2d array of 0 or 1 indicating if the tile has been checked
  public int[][] checkedArray;
  
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
  public void setGameOver(boolean game){ this.gameOver = game;}
  public boolean getGameOver(){ return this.gameOver;}
  
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
    //Works correctly now
    if(difficulty.equals("hard")){
      BOARD = new TILE[16][36];
      checkedArray = new int[16][36];
      for(int i = 0; i < 16; i++){
        for(int j = 0; j < 36; j++){
          BOARD[i][j] = new TILE();
          checkedArray[i][j] = 0;
        }
      }
      int[] mines = this.mineLocationCalc(difficulty);
      for(int i = 0; i < mines.length; i++){
        BOARD[mines[i]/36][mines[i]%36].setISBOMB(true);
      } 
      this.appointNum();
      this.appointCornerNum();
      this.appointEdgeNum();
      
    }
    
    else if(difficulty.equals("medium")){
      BOARD = new TILE[16][16];
      checkedArray = new int[16][16];
      for(int i = 0; i < 16; i++){
        for(int j = 0; j < 16; j++){
          BOARD[i][j] = new TILE();
          checkedArray[i][j] = 0;
        }
      }
      int[] mines = this.mineLocationCalc(difficulty);
      for(int i = 0; i < mines.length; i++){
        BOARD[mines[i]/16][mines[i]%16].setISBOMB(true);
      }
      this.appointNum();
      this.appointCornerNum();
      this.appointEdgeNum();
    }
    
    else{
      BOARD = new TILE[8][8];
      checkedArray = new int[8][8];
      this.difficulty = "easy";
      for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          BOARD[i][j] = new TILE();
          checkedArray[i][j] = 0;
        }
      }
      int[] mines = this.mineLocationCalc(difficulty);
      for(int i = 0; i < mines.length; i++){
        BOARD[mines[i]/8][mines[i]%8].setISBOMB(true);
      } 
      this.appointNum();
      this.appointCornerNum();
      this.appointEdgeNum();
      
    }
  }
  
  
  public void appointNum(){
    
    if(difficulty.equals("hard")){
      for (int row = 1; row < 15; row++){
        for (int col = 1; col < 35; col++){
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
    
    else if(difficulty.equals("medium")){
      for (int row = 1; row < 15; row++){
        for (int col = 1; col < 15; col++){
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
    else{
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
  }
  
  public void appointCornerNum(){
    if(difficulty.equals("hard")){
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
      }
        
        
      TILE second_corner_tile = BOARD[0][35];
      if(second_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[0][34];
        if (temp_tile.ISBOMB == true){
          BOARD[0][35].setHasNum(true);
          BOARD[0][35].numTouch++ ;
        }
        temp_tile = BOARD[1][34];
        if (temp_tile.ISBOMB == true){
          BOARD[0][35].setHasNum(true);
          BOARD[0][35].numTouch++ ;
        }
        temp_tile = BOARD[1][35];
        if (temp_tile.ISBOMB == true){
          BOARD[0][35].setHasNum(true);
          BOARD[0][35].numTouch++ ;
        }
      }
      TILE third_corner_tile = BOARD[15][0];
      if(third_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[14][0];
        if (temp_tile.ISBOMB == true){
          BOARD[15][0].setHasNum(true);
          BOARD[15][0].numTouch++ ;
        }
        temp_tile = BOARD[14][1];
        if (temp_tile.ISBOMB == true){
          BOARD[15][0].setHasNum(true);
          BOARD[15][0].numTouch++ ;
        }
        temp_tile = BOARD[15][1];
        if (temp_tile.ISBOMB == true){
          BOARD[15][0].setHasNum(true);
          BOARD[15][0].numTouch++ ;
        }
      }
      
      TILE fourth_corner_tile = BOARD[15][35];
      if(fourth_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[14][35];
        if (temp_tile.ISBOMB == true){
          BOARD[15][35].setHasNum(true);
          BOARD[15][35].numTouch++ ;
        }
        temp_tile = BOARD[14][34];
        if (temp_tile.ISBOMB == true){
          BOARD[7][7].setHasNum(true);
          BOARD[7][7].numTouch++ ;
        }
        temp_tile = BOARD[15][34];
        if (temp_tile.ISBOMB == true){
          BOARD[7][7].setHasNum(true);
          BOARD[7][7].numTouch++ ;
        }
      }
    }
    
    else if(difficulty.equals("medium")){
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
      }
        
        
      TILE second_corner_tile = BOARD[0][15];
      if(second_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[0][14];
        if (temp_tile.ISBOMB == true){
          BOARD[0][15].setHasNum(true);
          BOARD[0][15].numTouch++ ;
        }
        temp_tile = BOARD[1][14];
        if (temp_tile.ISBOMB == true){
          BOARD[0][15].setHasNum(true);
          BOARD[0][15].numTouch++ ;
        }
        temp_tile = BOARD[1][15];
        if (temp_tile.ISBOMB == true){
          BOARD[0][15].setHasNum(true);
          BOARD[0][15].numTouch++ ;
        }
      }
      TILE third_corner_tile = BOARD[15][0];
      if(third_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[14][0];
        if (temp_tile.ISBOMB == true){
          BOARD[15][0].setHasNum(true);
          BOARD[15][0].numTouch++ ;
        }
        temp_tile = BOARD[14][1];
        if (temp_tile.ISBOMB == true){
          BOARD[15][0].setHasNum(true);
          BOARD[15][0].numTouch++ ;
        }
        temp_tile = BOARD[15][1];
        if (temp_tile.ISBOMB == true){
          BOARD[15][0].setHasNum(true);
          BOARD[15][0].numTouch++ ;
        }
      }
      
      TILE fourth_corner_tile = BOARD[15][15];
      if(fourth_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[14][15];
        if (temp_tile.ISBOMB == true){
          BOARD[15][15].setHasNum(true);
          BOARD[15][15].numTouch++ ;
        }
        temp_tile = BOARD[14][14];
        if (temp_tile.ISBOMB == true){
          BOARD[15][15].setHasNum(true);
          BOARD[15][15].numTouch++ ;
        }
        temp_tile = BOARD[15][14];
        if (temp_tile.ISBOMB == true){
          BOARD[15][15].setHasNum(true);
          BOARD[15][15].numTouch++ ;
        }
      }
    }
    
    
    else{
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
      }
        
        
      TILE second_corner_tile = BOARD[0][7];
      if(second_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[0][6];
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
        TILE temp_tile = BOARD[6][0];
        if (temp_tile.ISBOMB == true){
          BOARD[7][0].setHasNum(true);
          BOARD[7][0].numTouch++ ;
        }
        temp_tile = BOARD[6][1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][0].setHasNum(true);
          BOARD[7][0].numTouch++ ;
        }
        temp_tile = BOARD[7][1];
        if (temp_tile.ISBOMB == true){
          BOARD[7][0].setHasNum(true);
          BOARD[7][0].numTouch++ ;
        }
      }
      
      TILE fourth_corner_tile = BOARD[7][7];
      if(fourth_corner_tile.ISBOMB == false){
        TILE temp_tile = BOARD[6][7];
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
    if(difficulty.equals("hard")){
      for (int col = 1; col <34; col++){
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
      for (int col = 1; col <34; col++){
        TILE current_tile = BOARD[15][col];
        if(current_tile.ISBOMB == false){
          TILE temp_tile = BOARD[15][col-1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[15][col+1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[14][col-1];
          if (temp_tile.ISBOMB == true){
            BOARD[7][col].setHasNum(true);
            BOARD[7][col].numTouch++ ;
          }
          temp_tile = BOARD[14][col];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[14][col+1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
        }
      }
      
      
      for (int row = 1; row <15; row++){
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
      
      for (int row = 1; row <15; row++){
        TILE current_tile = BOARD[row][35];
        if(current_tile.ISBOMB == false){
          TILE temp_tile = BOARD[row-1][35];
          if (temp_tile.ISBOMB == true){
            BOARD[row][35].setHasNum(true);
            BOARD[row][35].numTouch++ ;
          }
          temp_tile = BOARD[row+1][35];
          if (temp_tile.ISBOMB == true){
            BOARD[row][35].setHasNum(true);
            BOARD[row][35].numTouch++ ;
          }
          temp_tile = BOARD[row-1][34];
          if (temp_tile.ISBOMB == true){
            BOARD[row][35].setHasNum(true);
            BOARD[row][35].numTouch++ ;
          }
          temp_tile = BOARD[row][34];
          if (temp_tile.ISBOMB == true){
            BOARD[row][35].setHasNum(true);
            BOARD[row][35].numTouch++ ;
          }
          temp_tile = BOARD[row+1][34];
          if (temp_tile.ISBOMB == true){
            BOARD[row][35].setHasNum(true);
            BOARD[row][35].numTouch++ ;
          }
        }
      } 
    }
    
    else if(difficulty.equals("medium")){
      for (int col = 1; col <15; col++){
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
      for (int col = 1; col <15; col++){
        TILE current_tile = BOARD[15][col];
        if(current_tile.ISBOMB == false){
          TILE temp_tile = BOARD[15][col-1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[15][col+1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[14][col-1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[14][col];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
          temp_tile = BOARD[14][col+1];
          if (temp_tile.ISBOMB == true){
            BOARD[15][col].setHasNum(true);
            BOARD[15][col].numTouch++ ;
          }
        }
      }
      
      for (int row = 1; row <15; row++){
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
      
      for (int row = 1; row <15; row++){
        TILE current_tile = BOARD[row][15];
        if(current_tile.ISBOMB == false){
          TILE temp_tile = BOARD[row-1][15];
          if (temp_tile.ISBOMB == true){
            BOARD[row][15].setHasNum(true);
            BOARD[row][15].numTouch++ ;
          }
          temp_tile = BOARD[row+1][15];
          if (temp_tile.ISBOMB == true){
            BOARD[row][15].setHasNum(true);
            BOARD[row][15].numTouch++ ;
          }
          temp_tile = BOARD[row-1][14];
          if (temp_tile.ISBOMB == true){
            BOARD[row][15].setHasNum(true);
            BOARD[row][15].numTouch++ ;
          }
          temp_tile = BOARD[row][14];
          if (temp_tile.ISBOMB == true){
            BOARD[row][15].setHasNum(true);
            BOARD[row][15].numTouch++ ;
          }
          temp_tile = BOARD[row+1][14];
          if (temp_tile.ISBOMB == true){
            BOARD[row][15].setHasNum(true);
            BOARD[row][15].numTouch++ ;
          }
        }
      } 
    }

    else{
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
  }
  
    
  //this returns the requested tile from the board  
  public TILE getTile(int x, int y){
    return BOARD[y][x];
  }
  
  /**This method approximates left click. It will clear tiles if they are clear, but if it is a bomb
    * that ends the game.*/
  public void leftClick(int x, int y){
    if(this.getTile(x,y).getISBOMB()){
      //this is the game over condition
      for(int i = 0; i < 10; i++){
        System.out.println("GAME OVER GAME OVER GAME OVER");
        this.setGameOver(true);
        //System.exit(0);
      }
    }
    //this is what happens if the tile is clear
    else{
      //it gives the logic to the method clearTiles
      this.clearTiles(x,y);
    }
  }
  
  /* THis method handles the logic for clearing tiles. It's pretty ugly, and uses recursion
   * i couldn't figure out any other way to do it. Basically there's a truth table a 2d array
   * that gets created at the time the board size does. for each tile there's a checked status
   * 0 means unchecked 1 means checked. This goes around the 8 positions of a tiles neighbors and
   * checks to see if they are clearable. if so it calls itself on those tiles that are clearable.
   * once a tile has been checked one it excempts itself from being checked again. SHRUG
   * @Param x : simply the x coordinate
   * @Param y: simply the y coordinate
   * @Return returns nothing but updates the board
   * */
  public void clearTiles(int x, int y){
    //if the tile hasNUM it no longer clears surroundings and returns
    if(getTile(x,y).getHasNUM())
    {
      getTile(x,y).setHIDDEN(false);
      checkedArray[y][x] = 1;
      return;
    }
    // the else condition here represents a tile with no number and no bomb since this method only gets called from
    // the above leftClick method. It checks all surrounding 8 positions. There is no catch code because the program
    //doesn't actually need to do anything in the event of an error. It just means that TILE isn't there which is fine
    else
    {
      this.getTile(x,y).setHIDDEN(false);
      checkedArray[y][x] = 1;
      try{
        if(!getTile(x-1,y-1).getHasNUM() && checkedArray[y-1][x-1] == 0){
          getTile(x-1,y-1).setHIDDEN(false);
          checkedArray[y-1][x-1] = 1;
          clearTiles(x-1,y-1);
        }
        else{
          getTile(x-1,y-1).setHIDDEN(false);
          checkedArray[y-1][x-1] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x,y-1).getHasNUM() && checkedArray[y-1][x] == 0){
          getTile(x,y-1).setHIDDEN(false);
          checkedArray[y-1][x] = 1;
          clearTiles(x,y-1);
        }
        else{
          getTile(x,y-1).setHIDDEN(false);
          checkedArray[y-1][x] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x+1,y-1).getHasNUM() && checkedArray[y-1][x+1] == 0){
          getTile(x+1,y-1).setHIDDEN(false);
          checkedArray[y-1][x+1] = 1;
          clearTiles(x+1,y-1);
        }
        else{
          getTile(x+1,y-1).setHIDDEN(false);
          checkedArray[y-1][x+1] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x-1,y).getHasNUM() && checkedArray[y][x-1] == 0){
          getTile(x-1,y).setHIDDEN(false);
          checkedArray[y][x-1] = 1;
          clearTiles(x-1,y);
        }
        else{
          getTile(x-1,y).setHIDDEN(false);
          checkedArray[y][x-1] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x+1,y).getHasNUM() && checkedArray[y][x+1] == 0){
          getTile(x+1,y).setHIDDEN(false);
          checkedArray[y][x+1] = 1;
          clearTiles(x+1,y);
        }
        else{
          getTile(x+1,y).setHIDDEN(false);
          checkedArray[y][x+1] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x-1,y+1).getHasNUM() && checkedArray[y+1][x-1] == 0){
          getTile(x-1,y+1).setHIDDEN(false);
          checkedArray[y+1][x-1] = 1;
          clearTiles(x-1,y+1);
        }
        else{
          getTile(x-1,y+1).setHIDDEN(false);
          checkedArray[y+1][x-1] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x,y+1).getHasNUM() && checkedArray[y+1][x] == 0){
          getTile(x,y+1).setHIDDEN(false);
          checkedArray[y+1][x] = 1;
          clearTiles(x,y+1);
        }
        else{
          getTile(x,y+1).setHIDDEN(false);
          checkedArray[y+1][x] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
      try{
        if(!getTile(x+1,y+1).getHasNUM() && checkedArray[y+1][x+1] == 0){
          getTile(x+1,y+1).setHIDDEN(false);
          checkedArray[y+1][x+1] = 1;
          clearTiles(x+1,y+1);
        }
        else{
          getTile(x+1,y+1).setHIDDEN(false);
          checkedArray[y+1][x+1] = 1;
        }
      }
      catch(IndexOutOfBoundsException e){}
    }
  }
  
  
  //this method approximates right click. It flags a tile
  public void rightClick(int x, int y){
    //sets flag on given tile
    this.getTile(x,y).setFLAG(true);
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
  
  //delete this method later, it's purely for creating a testing board
  public void testBoard(){
    BOARD = new TILE[8][8];
    this.difficulty = "easy";
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        BOARD[i][j] = new TILE();
      }
    }
    for(int i = 3; i < 7; i++){
      BOARD[i][3].setISBOMB(true);
    } 
    for(int i = 3; i < 7; i++){
      BOARD[i][5].setISBOMB(true);
    } 
    BOARD[3][4].setISBOMB(true);
    BOARD[6][4].setISBOMB(true);
    this.appointNum();
    this.appointCornerNum();
    this.appointEdgeNum();
  }
 
  @Override
  public String toString(){
    String boardString ="";
    for(int i = 0; i < BOARD.length; i++){
      for(int j = 0; j < BOARD[i].length; j++){
        boardString += BOARD[i][j].toString();
      }
      boardString+= "\n";
    }
    return boardString;
  }
}
