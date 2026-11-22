import java.util.Locale;
import java.io.*;

public class Wordle {

    void main() {

        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String GRAY = "\u001B[90m";
        String RESET = "\u001B[0m";

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
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        IO.println("Thank you for selecting your secret word!");

        IO.println();
        IO.println();
        IO.println();
        IO.println();
        IO.println();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        IO.println("Player 2: You have 6 tries to guess the secret word");

        boolean wordGuessed = false;
        int guesses = 0;
        String guess = "";

        while (wordGuessed == false && guesses < 6) {

            IO.println();
            guess = IO.readln("Guess:\n").toLowerCase();
            IO.println();

            while (letters != guess.length()) {
                IO.println("Sorry! the length of your guess does not match the number of words you are playing for");
                IO.println();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                guess = IO.readln("Guess:\n").toLowerCase();
            }

            while (GameLogic.WordExists(guess) == false) {
                IO.println("Your selected word does not exist, try again!");
                IO.println();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                IO.println();
                guess = IO.readln("Guess:\n").toLowerCase();

                while (letters != guess.length()) {
                    IO.println("Sorry! the length of your guess does not match the number of words you are playing for");
                    IO.println();
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    IO.println();
                    guess = IO.readln("Guess:\n").toLowerCase();
                }
            }

            if (guess.equals(word)) {
                wordGuessed = true;
                IO.println(GREEN + word + RESET);
                IO.println("Congrats! You have successfully guessed the secret word");
            } else {
                IO.println("Try again");

                boolean[] used = new boolean[word.length()];
                String[] colors = new String[guess.length()];

                for (int i = 0; i < guess.length(); i++) {
                    if (guess.charAt(i) == word.charAt(i)) {
                        colors[i] = GREEN;
                        used[i] = true;
                    }
                }

                for (int i = 0; i < guess.length(); i++) {
                    if (colors[i] != null) {
                        continue;
                    }

                    colors[i] = GRAY;
                    for (int j = 0; j < word.length(); j++) {
                        if (used[j] == false && guess.charAt(i) == word.charAt(j)) {
                            colors[i] = YELLOW;
                            used[j] = true;
                            break;
                        }
                    }
                }

                for (int i = 0; i < guess.length(); i++) {
                    IO.print(colors[i] + guess.charAt(i) + RESET);
                }
                IO.println();

            }
            guesses++;
        }

        if (!wordGuessed && guesses == 6) {
            IO.println("Out of tries! The secret word was: " + word);
        }

    }







}
