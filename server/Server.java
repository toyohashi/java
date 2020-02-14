import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Create a superclass to store questions and answers
class makeQuestionList {
	public List<quizQuestion> makeQuestions() {
		String q1 = "In early January 2019, which country landed the first human-made object on the far side of the Moon?\n\n"
				+ "A.America\nB.China\nC.England\nD.Japan";
		String q2 = "In 2019 Premier League striker Emiliano Sala's plane went missing while on a flight from Nantes to which British city?\n\n"
				+ "A.Cardiff\nB.London\nC.Liverpool\nD.Leicester";
		String q3 = "A picture of which everyday object on Instagram became a global phenomenon by becoming the most liked post in online history?\n\n"
				+ "A.Cristiano’s family of Christmas elves\nB.Spiderman and Iron Man reunion\nC.An egg\nD.Lebron James says farewell to Kobe Bryant";
		String q4 = "The U.S. Justice Department charged which Chinese tech firm with multiple counts of fraud?\n\n"
				+ "A.Lenovo\nB.Xiaomi\nC.Asus\nD.Huawei";
		String q5 = "In 2019, who became the oldest football manager in Premier League history, at the age of 71 years and 198 days?\n\n"
				+ "A.Roy Hodgson\nB.Arsene Wenger\nC.Steve Bruce\nD.Alex Ferguson";
		String q6 = "Chelsea goalkeeper Kepa Arrizabalaga apologised for doing what during the Cup final?\n\n"
				+ "A.Missed penaty shoot\nB.Did terrible foul\nC.Refused to be substituted\nD.Red card";
		String q7 = "The February North Korea–United States summit was held in which country?\n\n"
				+ "A.USA\nB.North Korea\nC.Japan\nD.Vietnam";
		String q8 = "Which denomination coin celebrating Stephen Hawking’s work on black holes was unveiled in March 2019?\n\n"
				+ "A.Fifty pence piece\nB.Lincoln Cent\nC.Peace Dollar\nD.Standing Liberty Quarter";
		String q9 = "In 2019, what did retired banker Irini Tzortzoglou win?\n\n"
				+ "A.Let's Make a Deal\nB.The 2019 series of MasterChef\nC.Who Wants to Be a Millionaire\nD.The $100.000 Pyramid";
		String q10 = "Wikileaks co-founder Julian Assange is arrested after seven years of living in which country's London embassy?\n\n"
				+ "A.Japan's\nB.Rusia's\nC.Ecuador's\nD.Columbia's";
		String q11 = "In 2019, in Paris there is a major fire at which medieval cathedral?\n\n"
				+ "A.Saint-Germain-des-Prés\nB.Les Invalides\nC.Arc de Triomphe\nD.Notre-Dame";
		String q12 = "Which city's university beat St Edmund Hall, Oxford, to win the 2019 series of University Challenge?\n\n"
				+ "A.Edinburgh\nB.Cambridge\nC.Manchester\nD.London";
		String q13 = "In2019, Manchester City won the Premier League for the second year in a row with 98 points, but by how many points did the beat second placed Liverpool?\n\n"
				+ "A.One poit\nB.Two points\nC.Three points\nD.Five points";
		String q14 = "The 2019 FIFA Women's World Cup starts, in which country is it held?\n\n"
				+ "A.Japan\nB.Korea\nC.France\nD.Rusia";
		String q15 = "The 2019 FIFA Women's World Cup, which country won?\n\n"
				+ "A.France\nB.Germany\nC.England\nD.America";
		String q16 = "In July 2019, which country resumes commercial whaling again after not doing so for 30 years?\n\n"
				+ "A.Japan\nB.England\nC.America\nD.Italy";
		String q17 = "England win the Cricket World Cup final but which country did they beat in the final?\n\n"
				+ "A.Japan\nB.New Zealand\nC.Rusia\nD.Brazil";
		String q18 = "Novak Djokovic beats Roger Federer in the longest ever Wimbledon final. How long did  this match last?\n\n"
				+ "A.3 hours 57 minutes\nB.4 hours 27 minutes\nC.4 hours 57 minutes\nD.3 hours 27 minutes";
		String q19 = "Ahead of the latest G7 summit Boris Johnson expresses concern over major fires where?\n\n"
				+ "A.Kinabalu National Park\nB.Tongass National Forest\nC.Sundarbans Researve Forest\nD.Amazon rainforest";
		String q20 = "The Rugby World Cup starts in Japan. Which country do Japan beat in the first game of the tournament?\n\n"
				+ "A.Russia\nB.Brazil\nC.Germany\nD.USA";
		String q21 = "In 2019, astronomers announced the discovery of 20 new moons around which planet?\n\n"
				+ "A.Earth\nB.Saturn\nC.Jupiter\nD.Mars";
		String q22 = "Which country's Prime Minister won the 2019 Nobel Peace Prize?\n\n"
				+ "A.America\nB.Japan\nC.Eithiopia's\nD.China";
		String q23 = "In 2019, typhoon Hagibis was the biggest storm to hit which country in decades?\n\n"
				+ "A.America\nB.China\nC.Indonesia\nD.Japan";
		String q24 = "In 2019, the USA formally begins the process to pull out of which climate change agreement?\n\n"
				+ "A.Paris Agreement\nB.NewYok Agreement\nC.London Agreement\nD.Berlin Agreement";
		String q25 = "Which country was banned from global sporting events including the 2020 Olympics and 2022 World Cup?\n\n"
				+ "A.Vietnam\nB.Russia\nC.China\nD.Brazil";
		String q26 = "In 2019, Leicester City equaled the record for the biggest ever Premier League with a 9–0 victory against which team?\n\n"
				+ "A.Aston Villa\nB.Burley\nC.Southampton\nD.Everton";
		String q27 = "How many trees did Jeremy Corbyn promise to plant by 2040?\n\n"
				+ "A.1 billion\nB.2 billion\nC.3 billion\nD.4 billion";
		String q28 = "In 2019, Italy declared a state of emergency in which city following record flooding?\n\n"
				+ "A.Venice\nB.Rome\nC.Milan\nD.Turin";
		String q29 = "Ms Sanna Marin, aged 34, will become the world’s youngest sitting prime minister. Which country has she been elected to lead?\n\n"
				+ "A.Austria\nB.Finland\nC.Belgium\nD.Croatia";

		//Add question and its answer to questionList
		List<quizQuestion> questionList = new ArrayList<>();
		questionList.add(new quizQuestion(q1, "B"));
		questionList.add(new quizQuestion(q2, "A"));
		questionList.add(new quizQuestion(q3, "C"));
		questionList.add(new quizQuestion(q4, "D"));
		questionList.add(new quizQuestion(q5, "A"));
		questionList.add(new quizQuestion(q6, "C"));
		questionList.add(new quizQuestion(q7, "D"));
		questionList.add(new quizQuestion(q8, "A"));
		questionList.add(new quizQuestion(q9, "B"));
		questionList.add(new quizQuestion(q10, "C"));
		questionList.add(new quizQuestion(q11, "D"));
		questionList.add(new quizQuestion(q12, "A"));
		questionList.add(new quizQuestion(q13, "A"));
		questionList.add(new quizQuestion(q14, "C"));
		questionList.add(new quizQuestion(q15, "D"));
		questionList.add(new quizQuestion(q16, "A"));
		questionList.add(new quizQuestion(q17, "B"));
		questionList.add(new quizQuestion(q18, "C"));
		questionList.add(new quizQuestion(q19, "D"));
		questionList.add(new quizQuestion(q20, "A"));
		questionList.add(new quizQuestion(q21, "B"));
		questionList.add(new quizQuestion(q22, "C"));
		questionList.add(new quizQuestion(q23, "D"));
		questionList.add(new quizQuestion(q24, "A"));
		questionList.add(new quizQuestion(q25, "B"));
		questionList.add(new quizQuestion(q26, "C"));
		questionList.add(new quizQuestion(q27, "B"));
		questionList.add(new quizQuestion(q28, "A"));
		questionList.add(new quizQuestion(q29, "B"));

		return questionList;
	}

}

//Handle connected client
class ClientHandler implements Runnable{
	
	private String name;
	final DataInputStream dis;
	final ObjectOutputStream os;
	Socket socket;
	boolean isloggedin;

	//Constructor
	public ClientHandler(Socket socket,String name,DataInputStream dis,ObjectOutputStream os){
		this.dis = dis;
		this.os = os;
		this.name = name;
		this.socket = socket;
		this.isloggedin = true;
	}

	//Override
	public void run(){

		String userName;
		int score = -1;
		try{
			//Firstly received userName
			userName = dis.readUTF();
			System.out.println(name+": "+userName+" started to play game");

			//Send questions list to connected Client
			Server mySerVer = new Server();
			os.writeObject(mySerVer.makeQuestions());

			//Try to get final score
			while(true){
				try{
					score = Integer.parseInt(dis.readUTF());
					if (score!=-1) {
						System.out.println(name+": "+userName+" finished this game with score "+score+"/10");
						break;
					}	

				}catch(Exception e){
					System.out.println("Something went wrong....Can't get final score.");
					break;
				}

			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}

		try{
			this.dis.close();
			this.os.close();
			this.socket.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}

// Subclass Server which inheritants from the Superclass makeQuestionList
public class Server extends makeQuestionList {

	static int i = 1; //number of client

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		Socket socket;
		//Running infinite loop for getting client request
		while (true){
			socket = ss.accept();
			System.out.println("Received request from client "+i+": "+socket);

			//Obtain input stream and output object
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("Sending question lists to client "+i+".......");

			//Create a new handler object for handling this request.
			ClientHandler client = new ClientHandler(socket,"Client "+i,dis, os);
			Thread thread = new Thread(client);
			thread.start();

			//Increase the client's number
			i++;

		}
	}
	
}


