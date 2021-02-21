package clientservercmd;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket server;
    Socket waiter;
    DataInputStream dis;
    PrintStream ps;

    public Server() {
        try {
            server = new ServerSocket(6000);
            waiter = server.accept();
            dis = new DataInputStream(waiter.getInputStream());
            ps = new PrintStream(waiter.getOutputStream());

            String message = dis.readLine();
            System.out.println("The client says: " + message);
            ps.println("Pong...");

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                ps.close();
                dis.close();
                waiter.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
