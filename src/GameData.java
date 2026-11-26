import java.io.*;
import java.util.Random;
import java.util.random.*;

public class GameData {

    private int rounds;
    private int player1Wins;
    private int player2Wins;
    private int player1Losses;
    private int player2Losses;
    private double player1winPercentage;
    private double player2winPercentage;


   public GameData() {
       rounds = 0;
       player1Wins = 0;
       player2Wins = 0;
       player1Losses = 0;
       player2Losses = 0;
       player1winPercentage = 0.0;
       player2winPercentage = 0.0;
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

   public String wordSelector(int letters) {

       Random rand = new Random();

       while (true) {

           int randInt = rand.nextInt(this.getNumberOfWords());

           int index = 0;

           try (BufferedReader br = new BufferedReader(new FileReader("Words.txt"))) {

               String line = "";
               while ((line = br.readLine()) != null) {
                   if (line.length() == letters && index == randInt) {
                       return line;
                   } else {
                       index++;
                   }
               }

           } catch (Exception e) {
               e.printStackTrace();
           }
       }




   }

   public int getRounds() {
       return rounds;
   }

   public int getPlayer1Wins() {
       return player1Wins;
   }

   public int getPlayer2Wins() {
       return player2Wins;
   }

   public int getPlayer1Losses() {
       return player1Losses;
   }

   public int getPlayer2Losses() {
       return player2Losses;
   }

   public double getPlayer1WinPercentage() {
       return player1winPercentage;
   }

   public double getPlayer2WinPercentage() {
       return player2winPercentage;
   }

   public void incrementRounds() {
       rounds++;
   }

    public void incrementPlayer1Wins() {
       player1Wins++;
    }

    public void incrementPlayer2Wins() {
       player2Wins++;
    }

    public void incrementPlayer1Losses() {
       player1Losses++;
    }

    public void incrementPlayer2Losses() {
       player2Losses++;
    }

    public void calculatePlayer1WinPercentage() {
       player1winPercentage = (player1Wins / rounds) * 100;
    }

    public void calculatePlayer2WinPercentage() {
       player2winPercentage = (player2Wins / rounds) * 100;
    }

    public int getNumberOfWords() {

       int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Words.txt"))) {

            String line = "";
            while ((line = br.readLine()) != null) {
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;

    }

    public boolean atleastOneWord(int letters) {

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Words.txt"))) {

            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.length() == letters) {
                    count++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (count == 0) {
            return false;
        } else {
            return true;
        }

    }

}
