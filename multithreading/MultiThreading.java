package multithreading;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class MultiThreading extends Applet implements Runnable {
    Thread clockTh, marqueeTh, ballTh;
    int xPosition, x, y, ballWidth, ballHeight, xInc, yInc;
    String text = "Hello world";

    Date date;

    public void updateClock() {
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

    public void updateMarquee() {
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

    public void updateBall() {
        while (true) {

            x += xInc;
            y += yInc;

            if ((x + ballWidth) >= getWidth() || x <= 0) {
                xInc = xInc * -1;
            }
            if ((y + ballHeight) >= getHeight() || y <= 0) {
                yInc = yInc * -1;
            }

            repaint();

            try {
                Thread.sleep(30);
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    @Override
    public void init() {

        clockTh = new Thread(this, "clockTh");
        marqueeTh = new Thread(this, "marqueeTh");
        ballTh = new Thread(this, "ballTh");

        date = new Date();

        x = 0;
        y = getHeight() / 3;

        ballHeight = 50;
        ballHeight = 50;

        yInc = 5;
        xInc = 5;

        clockTh.start();
        marqueeTh.start();
        ballTh.start();
    }

    @Override
    public void paint(Graphics g) {
        Font f = new Font("Dialog", Font.BOLD, 25);
        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString(date.toString(), 20, getHeight() / 2);

        g.setColor(Color.BLACK);
        g.drawString(text, xPosition, 100);

        g.setColor(Color.BLUE);
        g.drawOval(x, y, 50, 50);
        g.fillOval(x, y, 50, 50);
    }

    @Override
    public void run() {
        String thName = Thread.currentThread().getName();
        if (thName == "clockTh")
            updateClock();
        else if (thName == "marqueeTh")
            updateMarquee();
        else if (thName == "ballTh")
            updateBall();

    }

}
