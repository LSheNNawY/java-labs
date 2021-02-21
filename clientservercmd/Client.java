package clientservercmd;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    Socket server;
    PrintStream ps;
    DataInputStream dis;

    public Client() {
        try {
            server = new Socket("127.0.0.1", 6000);
            dis = new DataInputStream(server.getInputStream());
            ps = new PrintStream(server.getOutputStream());
            ps.println("Ping...");
            String message = dis.readLine();
            System.out.println("The Server says: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                dis.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
