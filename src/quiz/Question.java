package quiz;

public abstract class Question {
	protected String question;
	protected String answer;
	protected int score;

	public String toString() {
		return question + "\n";
	}

	public boolean isCorrect(String answer) {
		return correctAnswer().equalsIgnoreCase(answer.trim());
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
