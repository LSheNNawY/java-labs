package helloapplet;

import java.applet.Applet;
import java.awt.*;

public class Hello extends Applet {

    public void paint(Graphics g) {

        String name = getParameter("name");

        Font f = new Font("Dialog", Font.BOLD, 25);

        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString("Hello " + name, 100, 100);
    }
}
