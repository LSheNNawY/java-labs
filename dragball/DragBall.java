package dragball;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DragBall extends Applet implements MouseMotionListener, MouseListener {

    int x, y, width, height;

    @Override
    public void init() {
        addMouseMotionListener(this);
        addMouseListener(this);

        x = 100;
        y = 100;
        width = 50;
        height = 50;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x, y, width, height);
        g.fillOval(x, y, width, height);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
