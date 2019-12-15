import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;


public class MineSweeperHomeWindow extends JFrame implements ActionListener{
  
  public MineSweeperHomeWindow(){
    setLayout(new FlowLayout());  
    
    JLabel introP1 = new JLabel("Welcome to MineSweeper");
    JLabel introP2 = new JLabel("Please choose your game");
    JButton easy = new JButton("Easy");
    easy.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        MineSweeperEasyWind gui1 = new MineSweeperEasyWind();
        gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui1.setSize(600,640);
        gui1.setVisible(true);
        gui1.setTitle("MineSweeper");
      }
    });
    
    JButton notEasy = new JButton("Not Easy");
    notEasy.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        MineSweeperMedWind gui1 = new MineSweeperMedWind();
        gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui1.setSize(600,640);
        gui1.setVisible(true);
        gui1.setTitle("MineSweeper");
      }
    });
    add(introP1);
    add(introP2);
    add(easy);
    add(notEasy);
  }
  
    @Override
  public void actionPerformed(ActionEvent e){}
}