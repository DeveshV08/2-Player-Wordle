import java.util.Locale;
import java.io.*;

public class Wordle {

    void main() {

        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String GRAY = "\u001B[90m";
        String RESET = "\u001B[0m";

        IO.println("Welcome to Wordle");

        IO.println();

        int gameChoice = 0;

        try {

            gameChoice = Integer.parseInt(IO.readln("To play singleplayer Wordle type 1, to play two player Wordle type 2\n"));

        } catch (Exception e) {

            gameChoice = Integer.parseInt(IO.readln("To play singleplayer Wordle type 1, to play two player Wordle type 2\n"));
        }

        while (gameChoice != 1 && gameChoice != 2) {

            try {

                gameChoice = Integer.parseInt(IO.readln("To play singleplayer Wordle type 1, to play two player Wordle type 2\n"));

            } catch (Exception e) {

                gameChoice = Integer.parseInt(IO.readln("To play singleplayer Wordle type 1, to play two player Wordle type 2\n"));
            }

        }

        IO.println();

        if (gameChoice == 2) {

            IO.println("Welcome to 2-Player Wordle!");
            IO.println();


            boolean playing = true;

            GameData gameSession = new GameData();

            while (playing) {

                IO.println("Player 1 selects the number of letters and the secret word, while player 2 \n" +
                        "has to guess the word in a certain amount of attempts!");

                IO.println();


                int letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
                IO.println();
                String word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();


                while (letters != word.length()) {
                    IO.println("Sorry! the length of your secret word does not match the number of letters you are playing for, try again");
                    IO.println();

                    letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
                    IO.println();
                    word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();
                }

                while (GameData.WordExists(word) == false) {
                    IO.println("Your selected word does not exist, try again!");
                    IO.println();

                    letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
                    IO.println();
                    word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();

                    while (letters != word.length()) {
                        IO.println("Sorry! the length of your secret word does not match the number of letters you are playing for, try again");
                        IO.println();

                        letters = Integer.parseInt(IO.readln("Player 1: Please select the amount of letters you want to play for\n"));
                        IO.println();
                        word = IO.readln("Player 1: Enter the secret word\n").toLowerCase();
                    }
                }


                IO.println("Thank you for selecting your secret word!");

                IO.println();
                IO.println();
                IO.println();
                IO.println();
                IO.println();


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

                        guess = IO.readln("Guess:\n").toLowerCase();
                    }

                    while (GameData.WordExists(guess) == false) {
                        IO.println("Your selected word does not exist, try again!");
                        IO.println();

                        IO.println();
                        guess = IO.readln("Guess:\n").toLowerCase();

                        while (letters != guess.length()) {
                            IO.println("Sorry! the length of your guess does not match the number of words you are playing for");
                            IO.println();

                            IO.println();
                            guess = IO.readln("Guess:\n").toLowerCase();
                        }
                    }

                    if (guess.equals(word)) {
                        wordGuessed = true;
                        IO.println(GREEN + word + RESET);
                        IO.println("Congrats! You have successfully guessed the secret word");
                        gameSession.incrementPlayer1Wins();
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
                    gameSession.incrementPlayer1Losses();
                }

                IO.println();

                IO.println("Now player 2 has to select a secret word and player 1 has to guess it");

                IO.println();


                letters = Integer.parseInt(IO.readln("Player 2: Please select the amount of letters you want to play for\n"));
                IO.println();
                word = IO.readln("Player 2: Enter the secret word\n").toLowerCase();


                while (letters != word.length()) {
                    IO.println("Sorry! the length of your secret word does not match the number of letters you are playing for, try again");
                    IO.println();

                    letters = Integer.parseInt(IO.readln("Player 2: Please select the amount of letters you want to play for\n"));
                    IO.println();
                    word = IO.readln("Player 2: Enter the secret word\n").toLowerCase();
                }

                while (GameData.WordExists(word) == false) {
                    IO.println("Your selected word does not exist, try again!");
                    IO.println();

                    letters = Integer.parseInt(IO.readln("Player 2: Please select the amount of letters you want to play for\n"));
                    IO.println();
                    word = IO.readln("Player 2: Enter the secret word\n").toLowerCase();

                    while (letters != word.length()) {
                        IO.println("Sorry! the length of your secret word does not match the number of letters you are playing for, try again");
                        IO.println();

                        letters = Integer.parseInt(IO.readln("Player 2: Please select the amount of letters you want to play for\n"));
                        IO.println();
                        word = IO.readln("Player 2: Enter the secret word\n").toLowerCase();
                    }
                }


                IO.println("Thank you for selecting your secret word!");

                IO.println();
                IO.println();
                IO.println();
                IO.println();
                IO.println();


                IO.println("Player 1: You have 6 tries to guess the secret word");

                wordGuessed = false;
                guesses = 0;
                guess = "";

                while (wordGuessed == false && guesses < 6) {

                    IO.println();
                    guess = IO.readln("Guess:\n").toLowerCase();
                    IO.println();

                    while (letters != guess.length()) {
                        IO.println("Sorry! the length of your guess does not match the number of words you are playing for");
                        IO.println();

                        guess = IO.readln("Guess:\n").toLowerCase();
                    }

                    while (GameData.WordExists(guess) == false) {
                        IO.println("Your selected word does not exist, try again!");
                        IO.println();

                        IO.println();
                        guess = IO.readln("Guess:\n").toLowerCase();

                        while (letters != guess.length()) {
                            IO.println("Sorry! the length of your guess does not match the number of words you are playing for");
                            IO.println();

                            IO.println();
                            guess = IO.readln("Guess:\n").toLowerCase();
                        }
                    }

                    if (guess.equals(word)) {
                        wordGuessed = true;
                        IO.println(GREEN + word + RESET);
                        IO.println("Congrats! You have successfully guessed the secret word");
                        gameSession.incrementPlayer2Wins();
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
                    gameSession.incrementPlayer2Losses();
                }

                gameSession.incrementRounds();

                IO.println();

                IO.println("End of Round " + gameSession.getRounds());

                IO.println();

                int choice = 1;

                try {

                    choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));

                } catch (Exception e) {

                    choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));
                }

                while (choice != 1 && choice != 2) {

                    try {

                        choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));

                    } catch (Exception e) {

                        choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));
                    }

                }

                IO.println();
                IO.println();

                if (choice == 2) {

                    gameSession.calculatePlayer1WinPercentage();
                    gameSession.calculatePlayer2WinPercentage();

                    IO.println("Thanks for playing!");
                    IO.println("Game Statistics:");

                    IO.println();

                    IO.println("Rounds: " + gameSession.getRounds());

                    IO.println();

                    IO.println("Player 1 Wins: " + gameSession.getPlayer1Wins());
                    IO.println("Player 1 Losses: " + gameSession.getPlayer1Losses());
                    IO.println("Player 1 Win Percentage: " + gameSession.getPlayer1WinPercentage());

                    IO.println();

                    IO.println("Player 2 Wins: " + gameSession.getPlayer2Wins());
                    IO.println("Player 2 Losses: " + gameSession.getPlayer2Losses());
                    IO.println("Player 2 Win Percentage: " + gameSession.getPlayer2WinPercentage());

                    playing = false;

                } else {
                    IO.println("Round: " + (gameSession.getRounds() + 1));
                }

            }

        } else {

            IO.println("Welcome to singleplayer Wordle!");

            IO.println();

            IO.println("You will decide the number of letters to play for and the program randomly selects a word of that length");
            IO.println("You have 6 attempts to correctly guess the word");

            boolean playing = true;

            GameData gameSession = new GameData();

            while (playing) {

                IO.println();

                int letters = Integer.parseInt(IO.readln("Please select the amount of letters you want to play for\n"));
                IO.println();

                while (true) {

                    if (gameSession.atleastOneWord(letters) == false) {
                        letters = Integer.parseInt(IO.readln("No words of that length found in word list, please select the amount of letters you want to play for again\n"));
                    } else {
                        break;
                    }
                }

                String word = gameSession.wordSelector(letters);

                IO.println("You have 6 tries to guess the secret word");

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

                        guess = IO.readln("Guess:\n").toLowerCase();
                    }

                    while (GameData.WordExists(guess) == false) {
                        IO.println("Your selected word does not exist, try again!");
                        IO.println();

                        IO.println();
                        guess = IO.readln("Guess:\n").toLowerCase();

                        while (letters != guess.length()) {
                            IO.println("Sorry! the length of your guess does not match the number of words you are playing for");
                            IO.println();

                            IO.println();
                            guess = IO.readln("Guess:\n").toLowerCase();
                        }
                    }

                    if (guess.equals(word)) {
                        wordGuessed = true;
                        IO.println(GREEN + word + RESET);
                        IO.println("Congrats! You have successfully guessed the secret word");
                        gameSession.incrementPlayer1Wins();
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
                    gameSession.incrementPlayer1Losses();
                }

                gameSession.incrementRounds();

                IO.println();

                IO.println("End of Round " + gameSession.getRounds());

                IO.println();

                int choice = 1;

                try {

                    choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));

                } catch (Exception e) {

                    choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));
                }

                while (choice != 1 && choice != 2) {

                    try {

                        choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));

                    } catch (Exception e) {

                        choice = Integer.parseInt(IO.readln("To play another round type 1, to stop playing and end the session type 2\n"));
                    }

                }

                IO.println();
                IO.println();

                if (choice == 2) {

                    gameSession.calculatePlayer1WinPercentage();

                    IO.println("Thanks for playing!");
                    IO.println("Game Statistics:");

                    IO.println();

                    IO.println("Rounds: " + gameSession.getRounds());

                    IO.println();


                    IO.println("Wins: " + gameSession.getPlayer1Wins());
                    IO.println("Losses: " + gameSession.getPlayer1Losses());
                    IO.println("Win Percentage: " + gameSession.getPlayer1WinPercentage());

                    playing = false;

                } else {
                    IO.println("Round: " + (gameSession.getRounds() + 1));
                }

            }

        }

    }







}
