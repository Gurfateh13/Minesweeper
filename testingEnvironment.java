/** 
  * this is just a class to mess around with and test various elements of the program. Feel free to run it
  * to get an idea of what's going on right now
  * */

public class testingEnvironment{
  
  public static void main(String[] args){
    
    RandomNumGen gen = new RandomNumGen(0,63,10);
    BOARDMAKER board = new BOARDMAKER("easy");
    board.makeBoard();
    //board.appointNum();
    //board.appointCornerNum();
    //board.appointEdgeNum();
    System.out.print(board.toString());
    System.out.println();
    // BOARDMAKER board1 = new BOARDMAKER("medium");
    //board1.makeBoard();
    //System.out.print(board1.toString());
    //for some reason hard implementation isn't working right now. I'll look into it later
    //BOARDMAKER board2 = new BOARDMAKER("hard");
    // board2.makeBoard();
    //System.out.print(board2.toString());
    
  }
}