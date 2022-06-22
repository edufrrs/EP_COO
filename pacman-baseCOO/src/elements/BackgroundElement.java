package elements;

import utils.Consts;
import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class BackgroundElement extends Element implements Serializable{
    
    public BackgroundElement(String imageName) {
        super(imageName);
    }

    public abstract void autoDraw(Graphics g);
}
