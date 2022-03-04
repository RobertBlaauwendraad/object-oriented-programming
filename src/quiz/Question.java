package quiz;

public abstract class Question {
	protected String question;
	protected String answer;
	protected int score;
	protected int totalScore = 0;

	public String toString() {
		return question;
	}

	public boolean isCorrect(String answer) {
		String correctAnswer = correctAnswer();
		boolean isCorrect = correctAnswer.equalsIgnoreCase(answer);
		if (isCorrect) {
			totalScore += score;
		}
		return isCorrect;
	}

	public String correctAnswer() {
		return answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore (int val) {
		if (val < 1 || val > 5) {
			score = 3;
		} else {
			score = val;
		}
	}
}
