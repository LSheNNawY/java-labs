package buttoncount;

import java.applet.*;
import java.awt.*;

public class ButtonCount extends Applet {

    Button incBtn;
    Button decBtn;

    int x = 0;

    public void init() {

        incBtn = new Button("Increment");
        decBtn = new Button("Decrement");

        incBtn.addActionListener((ev) -> {
            x++;
            repaint();
        });

        decBtn.addActionListener((ev) -> {
            x--;
            repaint();
        });

        add(incBtn);
        add(decBtn);

    }

    @Override
    public void paint(Graphics g) {
        Font f = new Font("Dialog", Font.BOLD, 20);
        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString("X = " + x, getWidth() / 2, getHeight() / 2);
    }

}