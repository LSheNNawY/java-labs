package playpauseanimation;

import java.applet.Applet;
import java.awt.*;

public class PlayPauseAnimation extends Applet {

    Thread thread;
    int x, y, ballWidth, ballHeight, xInc, yInc;
    volatile boolean ballFlag = true;

    Button playBtn, pauseBtn;

    @Override
    public void init() {
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (ballFlag) {
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
            }

        });

        playBtn = new Button("Play");
        pauseBtn = new Button("Pause");

        playBtn.addActionListener((e) -> {
            ballFlag = true;
        });

        pauseBtn.addActionListener((e) -> {
            ballFlag = false;
        });

        x = 0;
        y = getHeight() / 3;

        ballHeight = 50;
        ballHeight = 50;

        yInc = 5;
        xInc = 5;

        thread.start();

        add(playBtn);
        add(pauseBtn);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x, y, 50, 50);
        g.fillOval(x, y, 50, 50);
    }

}
