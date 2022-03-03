package quiz;

public abstract class Question {
	protected String question;
	protected String answer;
	protected int score = 3;

	public String toString() {
		return question;
	}

	public boolean isCorrect(String answer) {
		String correctAnswer = correctAnswer();
		return correctAnswer.equalsIgnoreCase(answer);
	}

	public String correctAnswer() {
		return answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore (int val) {
		score = val;
	}
}
