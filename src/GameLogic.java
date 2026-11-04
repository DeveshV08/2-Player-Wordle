import java.util.*;
import java.io.*;
public class GameLogic {

   private int guesses;
   private int guessesLeft;
   private String secretWord;
   private int wordLength;


   public GameLogic(int guesses, int wordLength, String secretWord) {
       this.guesses = guesses;
       this.secretWord = secretWord;
       this.guessesLeft = guesses;
       this.wordLength = wordLength;
   }

   public static boolean WordExists(String word) {

       boolean exists = false;

       try (BufferedReader br = new BufferedReader(new FileReader("Words.txt"))) {

           String line = "";
           while ((line = br.readLine()) != null) {
               if (line.equals(word)) {
                   exists = true;
                   break;
               }
           }

       } catch (Exception e) {
           e.printStackTrace();
       }

       return exists;

   }

}
