/** 
  * this is just a class to mess around with and test various elements of the program. Feel free to run it
  * to get an idea of what's going on right now
  * */

public class testingEnvironment{
  
  public static void main(String[] args){
    
    RandomNumGen gen = new RandomNumGen(0,63,10);
    BOARDMAKER board = new BOARDMAKER("easy");
    board.makeBoard();
    System.out.print(board.toString());
    System.out.println();
    //BOARDMAKER board1 = new BOARDMAKER("medium");
    //board1.makeBoard();
    //System.out.print(board1.toString());
    //System.out.println();
    BOARDMAKER board2 = new BOARDMAKER("hard");
    board2.makeBoard();
    //System.out.print(board2.toString());
    //System.out.println();
    
  }
}