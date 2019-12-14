/**
  * This is the main class that will be called to execute the minesweeper game eventually. It's not finished and
  * will likely be changed a great deal from now until the final product. Right now it's a basic command prompt
  * interface that asks the user for inputs and lets you click on objects.
  */


import java.util.Scanner;
public class minesweeperMain{
  
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Welcome to minesweeper\n\n\nPlease enter your difficulty! (easy, medium, or hard)");
    String difficulty = scnr.next();
    System.out.println();
    BOARDMAKER board = new BOARDMAKER(difficulty);
    board.makeBoard();
    //insert board making here
    System.out.println(board.toString());
    String choice;
    
    //board.testBoard();
    //System.out.println(board.toString());
    do{
      System.out.println("Okay what's your next move?");
      System.out.println("Now press 'c' to click 'r' to right click 'q' to quit\n\n");
      choice = scnr.next();
      if(choice.equals("c")){
        System.out.println("Okay, now enter the coordinates of your clicks y value first then x value!");
        int xcoord = scnr.nextInt();
        int ycoord = scnr.nextInt();
        board.leftClick(ycoord,xcoord);
      }
      else if(choice.equals("r")){
        System.out.println("Okay, now enter the coordinates of your right clicks y value first then x value!");
        int xcoord = scnr.nextInt();
        int ycoord = scnr.nextInt();
        board.rightClick(ycoord,xcoord);
      }
      else
      {
        System.out.println("Sorry, that wasn't one of the options, try again!");
      }
      System.out.println(board.toString());
      
    }while(!choice.equals("q") && !board.getGameOver());
    
    System.exit(0);
    
    
  }
}