import java.util.ArrayList;
import java.io.*;
public class highScores{
   boolean noFile = false;
  
  
  
  public ArrayList<String> getHighScores()
  {
    if(noFile == false){
      ArrayList<String> scores = new ArrayList<String>();
      try
      {
        
        BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
        String line;
        while ((line = reader.readLine()) != null)
        {
          scores.add(line);
        }
        reader.close();
        return scores;
      }
      catch (Exception e)
      {
        System.out.println("Something went wrong");
        noFile = true;
        return null;
      }
    }
    else{
      createHighScores();
      return null;
    }
  }
  
  public void createHighScores(){
    try
      {
         // i don't know how to get the file location to be consistent here. You have to manually change it for your file system?
         FileWriter writer = new FileWriter("C:/Users/Sand/Desktop/SWEEP/highscores.txt");
         // score from the timer goes in the variable below
         String score = "we have to put the score from the timer here";
         writer.write(score);
         writer.close();
      }
      catch (Exception e)
      {
        System.out.println("Something went wrong");
        return;
      }
  
  }
}