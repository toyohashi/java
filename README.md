# Java Socket Programming

## 1. Java Socket
Java Socket programming is used for communication between the applications running on different Java Runtime Environment.
### 1.1. Socket API
The client in socket programming must know two information:
1. IP Address of Server, and
2. Port number. <br>
Here, we are going to make one-way client and server communication. In this application, client sends a message to the server, server reads the message and prints it. Here, two classes are being used: Socket and ServerSocket. The Socket class is used to communicate client and server. Through this class, we can read and write message. The ServerSocket class is used at server-side. The accept() method of ServerSocket class blocks the console until the client is connected. After the successful connection of client, it returns the instance of Socket at server-side.


![Image](https://static.javatpoint.com/core/images/socket-programming.png)

### 1.2. Socket Class: 
A socket is simply an endpoint for communications between the machines. The Socket class can be used to create a socket.<br>
Important method:
1. ```public InputStream getInputStream()```: returns the InputStream attached with this socket.
2. ```public OutputStream getOutputStream()```: returns the OutputStream attached with this socket.
3. ```public synchronized void close()```: closes this socket

### 1.3. ServerSocket Class: Create Server
The ServerSocket class can be used to create a server socket. This object is used to establish communication with the clients.<br>
Important method:
1. ```public Socket accept()```:returns the socket and establish a connection between server and client.
2. ```public synchronized void close()```:closes the server socket.

## 2. Online Quiz Application
### 2.1. Ideal:
Create an online quiz game with 10 random questions about the outstanding events in 2019. In that game, users enter information (ip, port, name) in the Log in window, if the information is correct, server will send the question to the client. On the client side, the method has been programmed to receive questionnaires and scoring for this game. Client side will be switch to playGame menu and the game will be start. <br><br>
When the user completes question 10, the client will display the message "You have achieved ... points. Quiz has been completed." After this point is sent to the server, the server side will save the name + points of each player.

### 2.2. Classes for this game:
#### Server side:
- ```class quizQuestion```: Create method to format questionList.
- ```class questionList```: With the format in ```class quizQuestion```, use this class to add question and its answer to the question List.
- ```class Server```: Create Server socket, open a port, accept connection request from clients.
- ```class ClientHanlder implements Runnable```: Hold client's connection, receive username, send question list Object to Client, receive final score.

#### Client side:
- ```class quizQuestion```: When you receive question list object from Server, this class is used to format received data to question list form: question-answer.
- ```class playBackgroundMusic```: Play background music when user playing game (MutiThread).
- ```class playGame```: Create```Online Quiz Home``` window that displays question and get answer. Send final score to Server and exit game when it is completed.
- ```class ClientA```: Create ```Log in``` window, request connect to Server, hold this connection.
- ```sub class ConfirmButton```: get information from user's input, require connect to Server.

### 2.3. Run this game:
#### Server side:
```
javac quizQuestion.java
javac Server.java
java Server
```
#### Client side:
```
javac quizQuestion.java
javac playGame.java
javac ClientA.java
java ClientA
