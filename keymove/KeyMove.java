package keymove;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class KeyMove extends Applet implements KeyListener {

    String text = "Hello World";
    int x;
    int y;

    @Override
    public void init() {
        this.addKeyListener(this);
        x = getWidth() / 2;
        y = getHeight() / 2;

        System.out.println(text.length());
    }

    @Override
    public void paint(Graphics g) {
        Font f = new Font("Dialog", Font.BOLD, 20);
        g.setFont(f);
        g.setColor(Color.BLUE);
        g.drawString(text, x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int arrowCode = e.getKeyCode();

        switch (arrowCode) {
            case 37:
                x -= 20;
                repaint();
                break;
            case 38:
                y -= 20;
                repaint();
                break;
            case 39:
                x += 20;
                repaint();
                break;
            case 40:
                y += 20;
                repaint();
                break;

        }

    }

}
