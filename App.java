package finalprogram;

import finalprogram.Question;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		String q1 = "What color are apple?\n" + "(a)red/green\n(b)Orange\n(c)Magenta\n";

		String q2 = "What color are banana?\n" + "(a)red/green\n(b)Yellow\n(c)Blue\n";

		Question[] questions = { new Question(q1, "a"), new Question(q2, "b") };

		takeTest(questions);

	}

	public static void takeTest(Question[] questions) {
		int score = 0;
		Scanner keyboardInput = new Scanner(System.in);

		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i].prompt);
			String answer = keyboardInput.nextLine();

			if (answer.contentEquals(questions[i].answer)) {
				score++;

			}

		}

		System.out.println("You got" + score + "/" + questions.length);

	}
}
