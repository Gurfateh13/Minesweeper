/** Author: Diego "Max" Rivera
  * This class serves only to create a psuedo random array of unique numbers. I couldn't find a way for
  * java to directly give an array of UNIQUE random numbers with its randomnumgen so i'm using this work around
  * it uses the shuffle method from collections. It loads up an array with possible locations for the bombs, then
  * shuffles and loads the first n(num mines) into an array representing the location of the mines.
  * Right now it's best used by putting the array object returned by numGen() into what variable you want
  * */
import java.util.ArrayList;
import java.util.Collections;

public class RandomNumGen {
  public int max;
  public int min;
  public int numMines;
  int[] random;
  
  //defaults to the easy intepretation
  public RandomNumGen(){
    this.min = 0;
    this.max = 64;
    this.numMines = 10;
    this.numGen();
  }
  
  public RandomNumGen(int min, int max, int numMines){
    this.min = min;
    this.max = max;
    this.numMines = numMines;
    this.numGen();
  }
  
  //this returns the array of locations for the mines
  public int[] numGen(){
    ArrayList<Integer> list = new ArrayList<Integer>();
    random = new int[numMines];
    for (int i=min; i<max; i++) {
      list.add(new Integer(i));
    }
    Collections.shuffle(list);
    for (int i=0; i<numMines; i++) {
      random[i] = list.get(i);
    }
    return random;
  }
  
  //tostring intepretation for testing
  @Override
  public String toString(){
    String holder = "[";
    for(int i = 0; i < random.length; i++){
      holder+= random[i];
      holder+= ",";
    }
    holder = holder.substring(0,holder.length()-1);
    holder += "]";
    return holder;
  }
}