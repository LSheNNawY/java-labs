package chatrooms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    ServerSocket server;
    Socket waiter;

    public ChatServer() {
        try {
            server = new ServerSocket(6000);
            while (true) {
                waiter = server.accept();
                new ChatHandelerThread(waiter);
                System.out.println("New user created !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
