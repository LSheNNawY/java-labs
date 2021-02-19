package clock;

import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class Clock extends Applet implements Runnable {

    Thread thread;
    Date date;

    @Override
    public void init() {
        thread = new Thread(this);
        thread.start();
        date = new Date();
    }

    @Override
    public void paint(Graphics g) {
        Font f = new Font("Dialog", Font.BOLD, 25);
        g.setFont(f);

        g.setColor(Color.RED);

        g.drawString(date.toString(), 20, getHeight() / 2);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        while (true) {
            date = new Date();
            repaint();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
