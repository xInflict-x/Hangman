import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Player 1: Enter a word.");

        StringBuilder wordToGuess = new StringBuilder();
        wordToGuess.append(input.nextLine());

        StringBuilder word = new StringBuilder();
        word.append("-".repeat(wordToGuess.length()));

        boolean win = false;

        while (!win) {
            System.out.println(word.toString() + "Player 2: Enter a letter.");

            String guess = input.nextLine();

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.indexOf(guess, i) != -1) {
                    int pos = wordToGuess.indexOf(guess, i);

                    word.deleteCharAt(pos);
                    word.insert(pos, guess);
                }
            }
            if (wordToGuess.toString().contentEquals(word.toString())) {
                win = true;
            }
        }
        System.out.println("You win!\nThe word was " + wordToGuess.toString() + ".");
    }
}