/**
  * Main object class of minesweeper. Essentially minesweeper is a board filled with a grid of these objects.
  * Each tile object has a few boolean fields as well as an int that represents how many bombs it touches
  * Each tile can also self report wether it is on the edge of the minefield(grid) and wether or not it touches
  * bombs and also how many bombs it touches. A tile can be touching anywhere from 0 to 8 bombs
  * */
public class TILE{
  //represents wether a tile is covered or not. By default it is
  public boolean HIDDEN = true;
  //Tiles can be flagged and unflagged
  public boolean FLAG;
  //represents wether a tile is on the edge of the playing field
  public boolean EDGE; 
  //represents if the tile is a mine
  public boolean ISBOMB;
  //if the tile is near a mine it will have a NUM representing how many mines it is next to
  public boolean hasNUM;
  //The above num will be this int 1-8
  public int numTouch;
  
  //by default a tile is NOT a min
  public TILE(){
    this.ISBOMB = false;
  }
  
  //this constructor makes tiles a bomb based on the provided boolean
  public TILE(boolean ISBOMB){
    this.ISBOMB = ISBOMB;
  }
  
  //this constructor makes tiles that are bombs and edges based on the booleans provided
  public TILE(boolean ISBOMB, boolean EDGE){
    this.ISBOMB = ISBOMB;
    this.EDGE = EDGE;
  }
  //getters and setters
  public void setHIDDEN(boolean HIDDEN){this.HIDDEN = HIDDEN;}
  public boolean getHIDDEN(){return this.HIDDEN;}
  
  public void setFLAG(boolean flagStatus){this.FLAG = flagStatus;}
  public boolean getFLAG(){return this.FLAG;}
  
  public void setEDGE(boolean edge){this.EDGE = edge;}
  public boolean getEDGE(){return this.EDGE;}
  
  public void setISBOMB(boolean ISBOMB){ this.ISBOMB = ISBOMB;}
  public boolean getISBOMB(){return this.ISBOMB;}
  
  public void setHasNum(boolean hasNUM){this.hasNUM = hasNUM;}
  public boolean getHasNUM(){return this.hasNUM;}
  
  public void setNumTouch(int numTouch){this.numTouch = numTouch;}
  public int getNumTouch(){return this.numTouch;}
  
  //this will eventually be how the user interfaces with the tile objects. more to come here later i imagine
  public void click(){
    this.HIDDEN = false;
  }
  
  /* This is the big thing that has to get done right now. A tile has to be able to figure out where it is in the
   * board matrix. I think a better places for this method might be in the BOARDMAKER class. I'm not sure yet
   * but for now this isn't implemented. If anyone wants to take a shot at this feel free.
   * what it should do is report the number of bombs that surround it. Anywhere from 0 to 8 possible.
   * */
  /*
  public int reportNum(){
    return -1;
  }
  */
  
  //right now bombs will print that they are bombs plainly. This is just for testing. Obviously in the future
  //we probably won't even need this toString method
  @Override
  public String toString(){
    if(FLAG){
      return "[F]";
    }
    else if(ISBOMB){
      return "[B]";
    }
    if(hasNUM == true){
      return "[" + this.numTouch + "]";
    }
    else return "[0]";
  }
  
  /*
  //the correct toString
  @Override
  public String toString(){
    if(FLAG){
      return "[F]";
    }
    else if(HIDDEN){
      return "[ ]";
    }
    else{
      if(hasNUM)
        return "[" + this.numTouch + "]";
      else if(ISBOMB)
        return "[B]";
      else
        return "[-]";
    }
  }
  */
}