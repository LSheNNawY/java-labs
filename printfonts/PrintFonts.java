package printfonts;

import java.applet.Applet;
import java.awt.*;

public class PrintFonts extends Applet {

    public void paint(Graphics g) {

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

        String[] fontNames = graphicsEnvironment.getAvailableFontFamilyNames();

        // String[] fontNames = Toolkit.getDefaultToolkit().getFontList();

        int y = 20;
        for (int i = 0; i < fontNames.length; i++) {
            Font f = new Font(fontNames[i], Font.BOLD, 15);

            g.setFont(f);
            // print font names
            g.drawString(fontNames[i], 100, y);
            y += 20;
        }
    }
}