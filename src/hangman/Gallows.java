package hangman;

public class Gallows {
	private final String wordToBeGuessed;
	private StringBuilder wordSoFarStringBuilder;
	private final StringBuilder guessedLetters = new StringBuilder();
	private static final int MAX_MISTAKES = 10;
	private int remainingMistakes = MAX_MISTAKES;

	public Gallows() {
		WordReader wordReader = new WordReader("words.txt");
		wordToBeGuessed = wordReader.getWord();
		setWordSoFarStringBuilder();
	}

	public Gallows(String wordToBeGuessed) {
		this.wordToBeGuessed = wordToBeGuessed;
		setWordSoFarStringBuilder();
	}

	public boolean guessLetter(char guessedLetter) {
		guessedLetters.append(guessedLetter);
		if (wordToBeGuessed.contains(String.valueOf(guessedLetter))) {
			updateWordSoFar(guessedLetter);
			return true;
		}
		remainingMistakes--;
		return false;
	}

	private void setWordSoFarStringBuilder() {
		wordSoFarStringBuilder = new StringBuilder(wordToBeGuessed.length());
		wordSoFarStringBuilder.append(".".repeat(wordToBeGuessed.length()));
	}

	private void updateWordSoFar(char guessedLetter) {
		int index = wordToBeGuessed.indexOf(guessedLetter);
		while (index >= 0) {
			wordSoFarStringBuilder.setCharAt(index, guessedLetter);
			index = wordToBeGuessed.indexOf(String.valueOf(guessedLetter), index + 1);

		}
	}

	public boolean isWordGuessed() {
		return (wordToBeGuessed.equals(wordSoFarStringBuilder.toString()));
	}

	public String getWordToBeGuessed() {
		return wordToBeGuessed;
	}

	public String getWordSoFar() {
		return wordSoFarStringBuilder.toString();
	}

	public String getGuessedLetters() {
		return guessedLetters.toString();
	}

	public int getRemainingMistakes() {
		return remainingMistakes;
	}
}
