package game;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class functions {
    public static float[] getVectorsIntersec(float[] a1, float[] b1, float[] a2, float[] b2) {

        float k1 = (a1[1] - b1[1]) / (a1[0] - b1[0]);
        float k2 = (a2[1] - b2[1]) / (a2[0] - b2[0]);
        if (k1 == k2) return new float[] {};

        float c1 = a1[1] - a1[0] * k1;
        float c2 = a2[1] - a2[0] * k2;
        if (a1[0] == b1[0]) {
            return new float[] {a1[0], a1[0] * k2 + c2};
        }
        if (a2[0] == b2[0]) {
            return new float[] {a2[0], a2[0] * k1 + c1};
        }
        float intersecX = (c2 - c1) / (k1 - k2);
        float intersecY = k1 * intersecX + c1;
        return new float[]{intersecX, intersecY};
    }
    public static int[][] convertTo2DUsingGetRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row][col] = image.getRGB(col, row);
            }
        }

        return result;
    }
}
