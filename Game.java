public class Game {
 
  public static void main(String[] args) {
    // Your code here
    
    Prompter admin = new Prompter();
    
    Jar jar = new Jar(admin.promptForItem(), admin.promptForNumber());
    Prompter prompter = new Prompter(jar);
    
    prompter.play();
    
  }
  
}