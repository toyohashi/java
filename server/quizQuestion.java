import java.io.Serializable;

public class quizQuestion implements Serializable {

	String prompt;
	String answer;

	public quizQuestion(String prompt, String answer) {
		this.prompt = prompt;
		this.answer = answer;
	}

	public String showPromt() {
		return prompt;
	}

	public String showAnswer() {
		return answer;
	}

}