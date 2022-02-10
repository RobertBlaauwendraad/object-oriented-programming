package hangman;

public class HangmanTester {

	Gallows gallows;
	public void newGallows(String word) {
		gallows = new Gallows(word);
	}

	public String getWordSoFar() {
		return gallows.getWordSoFar();
	}

	public void guessLetter(char c) {
		gallows.guessLetter(c);
	}

	public String getGuessedLetters() {
		return gallows.getGuessedLetters();
	}
	
	public boolean isWordGuessed() {
		return gallows.isWordGuessed();
	}
}
