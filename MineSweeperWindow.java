import javax.swing.*;
import java.awt.*;

public class MineSweeperWindow extends JFrame{
  
  public static void main (String args[]) {
    MineSweeperEasyWind gui1 = new MineSweeperEasyWind();
    gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui1.setSize(600,640);
    gui1.setVisible(true);
    gui1.setTitle("MineSweeper");
    
  }
  
}
