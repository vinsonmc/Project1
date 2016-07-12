import java.io.Console;

public class Prompter {
  private Jar mJar;
  private int mGuess;
  Console console = System.console();
  
  public Prompter(){
  }
  
  public Prompter(Jar jar) {
    mJar = jar;
  }
  
  public void play() {
    mJar.fillJar();
    
    boolean morePlayers = true;
    while (morePlayers) {
    String name = console.readLine("Enter name: ");
    mJar.enterName(name);
    
    console.printf("\n%s\n====================\nYour goal is to guess how many %s are in the jar. Your guess should be between 1 and %d\n",name, mJar.getItemName(), mJar.getMaximumNumber());
    
    boolean isGuessed = false;
    while (!isGuessed) {
      mJar.makeGuess();
      
      boolean isInRange = false;
      while (!isInRange) {
        mGuess = promptForGuess();
        isInRange = checkRange(mGuess);
      }
      
      if (mGuess == mJar.getFill()) {
        console.printf("Got it. That took %d guesses.\n",mJar.getGuesses());
        isGuessed = true;
        if (mJar.getHighScore() == 0 || mJar.getGuesses()<mJar.getHighScore()){
          mJar.highScorer();
        } else {
          if (mJar.getHighScore() == mJar.getGuesses()){
          mJar.tie();
        }
        }
        
      }
      if (mGuess > mJar.getFill()) {
        console.printf("Too high.\n");
      }
      if (mGuess < mJar.getFill()) {
        console.printf("Too low.\n");
      }
    }
      
      morePlayers = promptForPlayers();
      mJar.resetGuesses();
    
    }
    
    console.printf("Congrats, %s won with a score of %d guesses.\n", mJar.getHighPlayer(), mJar.getHighScore());
    
  }
  
  public boolean promptForPlayers() {
    String answer = console.readLine("Are there any more players?  ");
    if (answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("y")){
      return true;
    } else {
      if (answer.equalsIgnoreCase("no")||answer.equalsIgnoreCase("n")){
        return false;
      } else {
        console.printf("I'll take that as a no.\n");
        return false;
      }
    }
  }
  
  public boolean checkRange(int guess) {
    if (guess>mJar.getMaximumNumber() || guess < 1){
      console.printf("That guess is out of range. Try again.\n");
      return false;
    } else {
      return true;
    }
      
  }
  
  public int promptForGuess() {
    boolean isInteger = false;
    int number = 0;
    
    while (!isInteger){
      try{
        number = Integer.parseInt(console.readLine("Guess: "));
        isInteger = true;
      } catch (IllegalArgumentException iae){
        console.printf("%s. Please input an integer.\n", iae.getMessage());
      }
    }
    return number;
  }
  
  
  // ===ADMIN SETUP===
  private String mItemName;
  
  public String promptForItem() {
    boolean isEmpty = true;
    console.printf("ADMINISTRATOR SETUP\n=======================\n");
    while (isEmpty){
      mItemName = console.readLine("Name of items in the jar: ");
        if (mItemName.length() != 0){
        isEmpty = false;
      } else {
          console.printf("There has to be something in the jar. Try again.\n");
        }
    }
    return mItemName;
  }
  
  public int promptForNumber() {
    boolean isInteger = false;
    boolean isPositive = false;
    int number = 0;
    
    while (!isInteger || !isPositive){
      try{
        number = Integer.parseInt(console.readLine("Maximum number of %s in the jar: ", mItemName));
        isInteger = true;
      } catch (IllegalArgumentException iae){
        console.printf("%s. Please input an integer.\n", iae.getMessage());
      }
      if (number>1) {
        isPositive = true;
      } else {
        console.printf("There should probably be more than 1 in the jar.\n");
      }
    }
    return number;
  } 
    
  
  
}