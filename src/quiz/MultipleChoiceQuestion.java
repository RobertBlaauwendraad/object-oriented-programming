package quiz;

public class MultipleChoiceQuestion extends Question {
	protected String[] answers;
	protected int correctAnswer;
	private final String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

	public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer, int score) {
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		setScore(score);
	}

	public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer) {
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		setScore(3);
	}

	@Override
	public String toString() {
		StringBuilder questionString = new StringBuilder(super.toString() + "\n");
		for (int i = 0; i < answers.length; i++) {
			questionString.append(alphabet[i]).append(") ").append(answers[i]).append("\n");
		}
		return questionString.toString();
	}

	@Override
	public String correctAnswer() {
		return alphabet[correctAnswer];
	}
}
