import java.util.Random;

public class Jar {
  private String mItemName;
  private int mMaximumNumber;
  private int mFill;
  private int mNumberOfGuesses = 0;
  private String mPlayerName;
  private String mHighPlayer;
  private int mHighScore = 0;
 
  public Jar(String itemName, int maximumNumber){
    mItemName = itemName;
    mMaximumNumber = maximumNumber;
  }
  
  public void fillJar() {
    Random random = new Random();
    mFill = random.nextInt(mMaximumNumber) + 1; //Add 1 to avoid empty jar
  }
  
  public void enterName(String name) {
    mPlayerName = name;
  }
  
  public void resetGuesses() {
    mNumberOfGuesses = 0;
  }
  
  public void tie() {
    mHighPlayer += " and " + mPlayerName;
  }
  
  public void highScorer() {
    mHighPlayer = mPlayerName;
    mHighScore = mNumberOfGuesses;
  }
  
  public void makeGuess(){
    mNumberOfGuesses++;
  }
  
  public String getHighPlayer(){
    return mHighPlayer;
  }
  
  public int getHighScore() {
    return mHighScore;
  }
  
  public int getGuesses(){
    return mNumberOfGuesses;
  }
  
  public int getFill() {
    return mFill;
  }
  
  public String getItemName() {
    return mItemName;
  }
  
  public int getMaximumNumber() {
    return mMaximumNumber;
  }
  

}