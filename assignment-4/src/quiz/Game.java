package quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private final List<Question> questions = new LinkedList<>();
	private final List<Question> wrongQuestions = new LinkedList<>();
	private int scoreOfFirstRound = 0;
	private int scoreOfSecondRound = 0;

	  protected void startGame() {
			addQuestions();
			Scanner scanner = new Scanner(System.in);
		  System.out.println("First round of questions:\n");
		  for (Question q : questions) {
				System.out.print(q);
			  String givenAnswer = scanner.nextLine();
				if (q.isCorrect(givenAnswer)) {
					scoreOfFirstRound += q.getScore();
				} else {
					wrongQuestions.add(q);
				}
	  }

	  System.out.println("Second round of questions:\n");
		for (Question q : wrongQuestions) {
			System.out.print(q);
			String givenAnswer = scanner.nextLine();
			if (q.isCorrect(givenAnswer)) {
				scoreOfSecondRound += q.getScore();
			}
		}
	  System.out.println("Score of first round: " + scoreOfFirstRound);
	  System.out.println("Score of second round: " + scoreOfSecondRound);
	}

	private void addQuestions() {
		questions.add(new OpenQuestion("What is the big O complexity of binary search?", "O(log N)"));
		questions.add(new	OpenQuestion("How would you read an integer i from scanner s in Java?", "i = s.nextInt();", 2));
		questions.add(new OpenQuestion("What is the minimum amount of constructors you have to define for a class in Java?", "0", 2));

		questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?", new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1, 4));
		questions.add(new	MultipleChoiceQuestion("How do you print \"Hello world\" on a line in Java?", new String[] { "System.out.print(\"Hello world\");", "System.out.println(\"Hello world\");", "cout << \"Hello world\";" }, 1));
		questions.add(new MultipleChoiceQuestion("How do you read a non-empty word in Java using scanner s?", new String[] { "s.nextline()", "s.next(\"\\S+\")", "s.next(\"\\a*\")", "s.next(\"\\S*\")", "s.next(\"\\\\s+\")", "s.next(\"\\s+\")", "s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")", "s.nextString()" }, 7, 1));

		questions.add(new ThisThatQuestion("Every class must have a constructor", "Right", "Wrong", 1));
		questions.add(new ThisThatQuestion("Is there a difference between an interface and an abstract class?", "Yes", "No", 0, 5));
		questions.add(new ThisThatQuestion("Is there a maximum to the amount of constructors a class can have in Java?", "Yes", "No", 1));
	}
}
