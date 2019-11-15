/** Author: Diego "Max" Rivera 
 * This is the main class that will be called to execute the minesweeper game eventually. It's not finished and
 * will likely be changed a great deal from now until the final product. Right now it's a basic command prompt
 * interface that asks the user for inputs and lets you click on objects.
 * */

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
    System.out.println("Excellent, now press 'c' to click 'q' to quit or 'f' to flag\n\n");
    do{
      choice = scnr.next();
      if(choice.equals("c")){
        System.out.println("Okay, now enter the coordinates of your clicks x value first then y value!");
      }
      else if(choice.equals("f")){
      
        System.out.println("Okay, now enter the coordinate you want to flag, x value first then y value!");
      }
      else
      {
        System.out.println("Sorry, that wasn't one of the options, try again!");
      }
    
    }while(!choice.equals("q"));
    
    System.exit(0);
    
    
  }
}