import javax.swing.*;
import java.awt.*;
import java.lang.*;

import java.awt.event.*;

public class MineSweeperWindow extends JFrame{
  
  public static void main (String args[]) {
    MineSweeperHomeWindow gui1 = new MineSweeperHomeWindow();
    gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui1.setSize(200,200);
    gui1.setVisible(true);
    gui1.setTitle("MineSweeper");
    
  }
  
}
