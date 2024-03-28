package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class wall {
    private float[] a;
    private float[] b;
    private Color color = Color.MAGENTA;
    private boolean hasTeture;
    private BufferedImage texture;
    public wall(float[] a, float[] b, Color color) {
        if (a[0] > b[0]) {
            this.a = a;
            this.b = b;
        } else {
            this.b = a;
            this.a = b;
        }
        this.color = color;
        this.hasTeture = false;
    }
    public wall(float[] a, float[] b, BufferedImage texture) {
        if (a[0] > b[0]) {
            this.a = a;
            this.b = b;
        } else {
            this.b = a;
            this.a = b;
        }
        this.texture = texture;
        this.hasTeture = true;
    }

    public float[] getA() {
        return a;
    }

    public void setA(float[] a) {
        this.a = a;
    }

    public float[] getB() {
        return b;
    }

    public void setB(float[] b) {
        this.b = b;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isHasTeture() {
        return hasTeture;
    }

    public void setHasTeture(boolean hasTeture) {
        this.hasTeture = hasTeture;
    }

    public BufferedImage getTexture() {        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
}
