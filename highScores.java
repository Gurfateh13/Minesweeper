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
  
  public static void createHighScores(String name, String score){
    try
      {
        File textFile = new File("highscores.txt");
        String absPath = textFile.getAbsolutePath();
        // Used to retrieve and store the absolute pathname of the highscores.txt file.
        FileWriter writer = new FileWriter(absPath);
        writer.write(score + " " + name + "\n");
        writer.close();
      }
     catch (Exception e)
     {
      System.out.println("Something went wrong");
      return;
     }
  
  }
}
