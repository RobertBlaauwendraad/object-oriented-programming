package quiz;

public class OpenQuestion extends Question {
	public OpenQuestion(String question, String answer, int score) {
		this.question = question;
		this.answer = answer;
		setScore(score);
	}

	public OpenQuestion(String question, String answer) {
		this.question = question;
		this.answer = answer;
		setScore(3);
	}
}
