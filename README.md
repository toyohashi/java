# Java Socket Programming

## 1. Java Socket
Java Socket programming is used for communication between the applications running on different Java Runtime Environment.
### 1.1. Socket API
The client in socket programming must know two information:
1. IP Address of Server, and
2. Port number. <br>
Here, we are going to make one-way client and server communication. In this application, client sends a message to the server, server reads the message and prints it. Here, two classes are being used: Socket and ServerSocket. The Socket class is used to communicate client and server. Through this class, we can read and write message. The ServerSocket class is used at server-side. The accept() method of ServerSocket class blocks the console until the client is connected. After the successful connection of client, it returns the instance of Socket at server-side.


![Image](https://static.javatpoint.com/core/images/socket-programming.png)

## 1.2. Socket Class: 
A socket is simply an endpoint for communications between the machines. The Socket class can be used to create a socket.<br>
Important method:
1. ```public InputStream getInputStream()```: returns the InputStream attached with this socket.
2. ```public OutputStream getOutputStream()```: returns the OutputStream attached with this socket.
3. ```public synchronized void close()```: closes this socket

## 1.3. ServerSocket Class: Create Server
The ServerSocket class can be used to create a server socket. This object is used to establish communication with the clients.<br>
Important method:
1. ```public Socket accept()```:returns the socket and establish a connection between server and client.
2. ```public synchronized void close()```:closes the server socket.

## 2. Online Quiz Application
