package marquee;

import java.applet.Applet;
import java.awt.*;

public class Marquee extends Applet implements Runnable {

    Thread thread;
    int xPosition;
    String text = "Hello world";

    @Override
    public void init() {
        thread = new Thread(this);
        xPosition = 0;
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        Font f = new Font("Dialog", Font.BOLD, 20);
        g.setFont(f);
        g.setColor(Color.RED);

        g.drawString(text, xPosition, 100);

    }

    @Override
    public void run() {
        while (true) {
            xPosition += 10;
            if (xPosition > getWidth())
                xPosition = -100;
            repaint();
            System.out.println(xPosition);
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
