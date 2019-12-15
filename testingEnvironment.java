/** 
  * this is just a class to mess around with and test various elements of the program. Feel free to run it
  * to get an idea of what's going on right now
  * */

public class testingEnvironment{
  
  public static void main(String[] args){
    
    BOARDMAKER board = new BOARDMAKER("hard");
    board.makeBoard();
    System.out.println(board.toString());
    
  }
}