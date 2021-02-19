package draglines;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DragLines extends Applet implements MouseMotionListener, MouseListener {

    final int SIZE = 5;
    int linesCount;
    Point[] startPoints;
    Point[] endPoints;
    Point startPoint;
    Point endPoint;

    @Override
    public void init() {
        addMouseMotionListener(this);
        addMouseListener(this);

        startPoints = new Point[SIZE];
        endPoints = new Point[SIZE];
        linesCount = 0;
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < linesCount; i++) {
            g.drawLine(startPoints[i].x, startPoints[i].y, endPoints[i].x, endPoints[i].y);
        }

        if (endPoint != null) {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (linesCount < SIZE) {

            startPoints[linesCount] = startPoint;
            endPoints[linesCount] = endPoint;

            linesCount++;
            endPoint = null;
            repaint();
        } else {
            endPoint = null;
            repaint();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
