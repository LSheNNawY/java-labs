package drawlamp;

import java.applet.Applet;
import java.awt.*;

public class DrawLamp extends Applet {

    public void paint(Graphics g) {
        // Font f = new Font("Dialog", Font.BOLD, 25);
        // g.setFont(f);

        g.drawOval(150, 50, 250, 80);
        g.setColor(Color.YELLOW);
        g.fillOval(150, 50, 250, 80);

        g.setColor(Color.BLACK);
        g.drawOval(150, 150, 50, 90);
        g.setColor(Color.YELLOW);
        g.fillOval(150, 150, 50, 90);

        g.setColor(Color.BLACK);
        g.drawOval(220, 150, 100, 140);
        g.setColor(Color.YELLOW);
        g.fillOval(220, 150, 100, 140);

        g.setColor(Color.BLACK);
        g.drawOval(350, 160, 50, 90);
        g.setColor(Color.YELLOW);
        g.fillOval(350, 160, 50, 90);

        g.setColor(Color.BLACK);
        g.drawLine(150, 95, 100, 270);

        g.drawLine(400, 95, 450, 270);

        g.drawArc(100, 220, 350, 100, 180, 180);

        g.drawLine(250, 320, 210, 450);

        g.drawLine(270, 320, 300, 450);

        g.drawRect(110, 450, 300, 30);

    }
}
