package drawimage;

import java.applet.Applet;
import java.awt.*;

public class DrawImage extends Applet {

    Image picture;

    public void init() {
        picture = getImage(getDocumentBase(), "drawimage/workers.jpg");
    }

    public void paint(Graphics g) {
        // drwaw image without width & height
        // g.drawImage(picture, 0, 0, this);

        // draw imagw with width & height
        g.drawImage(picture, 0, 0, getSize().height, getSize().width, this);
    }
}
