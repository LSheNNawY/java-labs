package chatrooms;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Optional;

import javax.swing.*;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class ChatClient extends JFrame {

    Socket server;
    DataInputStream dis;
    PrintStream ps;
    String clientName;

    public ChatClient() {
        this.setLayout(new FlowLayout());
        clientName = JOptionPane.showInputDialog(this, "Name:");
        JTextArea ta = new JTextArea(20, 50);
        JScrollPane scroll = new JScrollPane(ta);
        JTextField tf = new JTextField(40);
        JButton okButton = new JButton("Send");

        ta.setEditable(false);

        try {
            server = new Socket("127.0.0.1", 6000);
            dis = new DataInputStream(server.getInputStream());
            ps = new PrintStream(server.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ps.println(tf.getText());
                ps.flush();
                tf.setText("");
            }
        });

        new Thread() {
            public void run() {
                while (true) {
                    String msg;

                    try {
                        msg = dis.readLine();
                        ta.append(clientName + ": " + msg + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

        }.start();

        add(scroll);
        add(tf);
        add(okButton);
    }

    public static void main(String args[]) {
        ChatClient ui = new ChatClient();
        ui.setSize(600, 400);
        ui.setResizable(false);
        ui.setVisible(true);

    }
}
