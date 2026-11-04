import java.util.Locale;

public class Wordle {

    void main() {

        IO.println("Welcome to 2-Player Wordle!");
        IO.println();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        IO.println("Player 1 selects the number of letters and the secret word, while player 2 \n" +
                "has to guess the word in a certain amount of attempts!");

        IO.println();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
        IO.println();
        String word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (letters != word.length()) {
            IO.println("Sorry! the length of your secret word does not match the number of letters you are playing for, try again");
            IO.println();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
            IO.println();
            word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();
        }

        while (GameLogic.WordExists(word) == false) {
            IO.println("Your selected word does not exist, try again!");
            IO.println();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
            IO.println();
            word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        IO.println("Thank you for selecting your secret word!");



    }



}
