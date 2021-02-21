package chatrooms;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;

public class ChatHandelerThread extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandelerThread> clientsVector = new Vector<ChatHandelerThread>();

    public ChatHandelerThread(Socket waiter) {
        try {
            dis = new DataInputStream(waiter.getInputStream());
            ps = new PrintStream(waiter.getOutputStream());
            clientsVector.add(this);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = dis.readLine();
                sendMessageToAll(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    void sendMessageToAll(String msg) {
        for (ChatHandelerThread chatHandelerThread : clientsVector) {
            chatHandelerThread.ps.println(msg);
        }
    }
}
