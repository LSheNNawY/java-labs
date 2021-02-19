package dragline;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DragLine extends Applet implements MouseMotionListener, MouseListener {

    private Point startPoint, endPoint;

    public void init() {
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        if (startPoint != null && endPoint != null) {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        endPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}