//adds the required packages
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
//MineSweeperWindow is a child of JFrame
public class MineSweeperWindow extends JFrame{
//main method  
  public static void main (String args[]) {
    MineSweeperHomeWindow gui1 = new MineSweeperHomeWindow();
    gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui1.setSize(200,200);
    gui1.setVisible(true);
    gui1.setTitle("MineSweeper");
    
  }
  
}
