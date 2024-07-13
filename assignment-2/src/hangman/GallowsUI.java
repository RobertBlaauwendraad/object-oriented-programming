package hangman;

import java.util.Scanner;

public class GallowsUI {
	private Gallows gallows;

	public GallowsUI() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		System.out.println("Please enter a word or press Enter to randomly pick one");
		String wordToBeGuessed = scanner.nextLine();
		if (wordToBeGuessed.isEmpty()) {
			gallows = new Gallows();
		} else {
			gallows = new Gallows(wordToBeGuessed);
		}
		while (gallows.getRemainingMistakes() > 0 && !gallows.isWordGuessed()) {
			System.out.println("Remaining mistakes: " + gallows.getRemainingMistakes());
			System.out.println("Guessed letters: ["+ gallows.getGuessedLetters() +"]");
			System.out.println("Word: "+ gallows.getWordSoFar());
			String guessedString = scanner.next();
			char guessedChar = guessedString.charAt(0); // Assume user wants to guess first character entered
			boolean correctGuess = gallows.guessLetter(guessedChar);
			if (correctGuess) {
				System.out.println(guessedChar + " is in the word");
			} else {
				System.out.println(guessedChar + " is not in the word");
			}
			System.out.println("Word: " + gallows.getWordSoFar());
		}
		if (gallows.isWordGuessed()) {
			System.out.println("Congratulations, u won!");
		} else {
			System.out.println("Nice try, the word was: " + gallows.getWordToBeGuessed());
		}
	}
}
