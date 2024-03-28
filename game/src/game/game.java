
package game;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

public class game extends JFrame {
    public game(String title) {
        super(title);


        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int curX = e.getX();
                game.player.setDirection(((game.player.getDirection() + (float) (curX - settings.screenSize.width / 2) * settings.getSensitivity() / 50) + 360) % 360);
                try {
                    Robot r = new Robot();
                    r.mouseMove(settings.screenSize.width / 2, settings.screenSize.height / 2);
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) gameplay.isW = true;
                if (e.getKeyCode() == KeyEvent.VK_A) gameplay.isA = true;
                if (e.getKeyCode() == KeyEvent.VK_S) gameplay.isS = true;
                if (e.getKeyCode() == KeyEvent.VK_D) gameplay.isD = true;
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) gameplay.isESC = true;
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) gameplay.isSHIFT = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) gameplay.isW = false;
                if (e.getKeyCode() == KeyEvent.VK_A) gameplay.isA = false;
                if (e.getKeyCode() == KeyEvent.VK_S) gameplay.isS = false;
                if (e.getKeyCode() == KeyEvent.VK_D) gameplay.isD = false;
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) gameplay.isESC = false;
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) gameplay.isSHIFT = false;
            }
        });
        gameplay gp = new gameplay();
        gp.setPreferredSize(settings.getScreenSize());
        setContentPane(gp);
    }

    public static void main(String[] args) throws IOException {
        game OurApp = new game("Testing");
        OurApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OurApp.setCursor(OurApp.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));
        OurApp.setResizable(false);
        BufferedImage converted1 = ImageIO.read(new File("C:\\Users\\farywave\\IdeaProjects\\game\\5.jpg"));
        BufferedImage converted2 = ImageIO.read(new File("C:\\Users\\farywave\\IdeaProjects\\game\\5.jpg"));
        BufferedImage converted3 = ImageIO.read(new File("C:\\Users\\farywave\\IdeaProjects\\game\\5.jpg"));

        game.world.addObject(new wall(new float[]{-50, -25}, new float[]{-25, -75}, converted1));
        game.world.addObject(new wall(new float[]{-25, -75}, new float[]{25, -75}, converted2));
        game.world.addObject(new wall(new float[]{25, -75}, new float[]{50, -25}, converted3));

        game.world.addObject(new wall(new float[]{-50, 75}, new float[]{-50, 25}, Color.red));
        game.world.addObject(new wall(new float[]{-50, 25}, new float[]{50, 25}, Color.black));
        game.world.addObject(new wall(new float[]{50, 25}, new float[]{50, 75}, Color.YELLOW));


        OurApp.setUndecorated(true);
        OurApp.pack();
        OurApp.setVisible(true);

    }

    public static class world {
        static ArrayList<wall> objects = new ArrayList<>();

        public static ArrayList<wall> getObjects() {
            return objects;
        }

        public static void addObject(wall object) {
            objects.add(object);
        }
    }

    public static class player {
        private static float walkSpeed = 2;
        private static float runSpeed = 4;
        private static float direction = 0;
        private static float speed = walkSpeed;
        private static float[] position = new float[]{0, 0};

        public static float getDirection() {
            return direction;
        }

        public static float getSpeed() {
            return speed;
        }

        public static void setDirection(float newDirection) {
            player.direction = newDirection;
        }

        public static void setSpeed(float newSpeed) {
            player.speed = newSpeed;
        }

        public static float[] getPosition() {
            return position;
        }

        public static void setPosition(float[] position) {
            player.position = position;
        }

        public static void walk() {
            speed = walkSpeed;
        }

        public static void run() {
            speed = runSpeed;
        }

        public static void moveF() {
            double sin = Math.sin(Math.toRadians(direction));
            double cos = Math.cos(Math.toRadians(direction));
            position[0] += speed * sin;
            position[1] += speed * cos;

        }

        public static void moveB() {
            double sin = Math.sin(Math.toRadians(direction + 180));
            double cos = Math.cos(Math.toRadians(direction + 180));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }

        public static void moveBR() {
            double sin = Math.sin(Math.toRadians(direction + 135));
            double cos = Math.cos(Math.toRadians(direction + 135));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }

        public static void moveBL() {
            double sin = Math.sin(Math.toRadians(direction - 135));
            double cos = Math.cos(Math.toRadians(direction - 135));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }

        public static void moveFR() {
            double sin = Math.sin(Math.toRadians(direction + 45));
            double cos = Math.cos(Math.toRadians(direction + 45));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }

        public static void moveFL() {
            double sin = Math.sin(Math.toRadians(direction - 45));
            double cos = Math.cos(Math.toRadians(direction - 45));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }

        public static void moveR() {
            double sin = Math.sin(Math.toRadians(direction + 90));
            double cos = Math.cos(Math.toRadians(direction + 90));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }

        public static void moveL() {
            double sin = Math.sin(Math.toRadians(direction - 90));
            double cos = Math.cos(Math.toRadians(direction - 90));
            position[0] += speed * sin;
            position[1] += speed * cos;
        }
    }

    public static class settings {
        private static float sensitivity = 10;
        private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        private static int FOV = 70;

        public static float getSensitivity() {
            return sensitivity;
        }

        public static void setSensitivity(float sensitivity) {
            settings.sensitivity = sensitivity;
        }

        public static Dimension getScreenSize() {
            return screenSize;
        }

        public static void setScreenSize(Dimension screenSize) {
            settings.screenSize = screenSize;
        }

        public static int getFOV() {
            return FOV;
        }

        public static void setFOV(int FOV) {
            settings.FOV = FOV;
        }
    }
}

class gameplay extends JPanel implements ActionListener {
    int FPS = 0;
    long time = System.nanoTime();
    static boolean isW = false;
    static boolean isA = false;
    static boolean isS = false;
    static boolean isD = false;
    static boolean isESC = false;
    static boolean isSHIFT = false;


    public gameplay() {
        super();

        Timer timer = new Timer(10, this);
        timer.start();
        setBackground(Color.darkGray);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, game.settings.getScreenSize().width, game.settings.getScreenSize().height / 2);

        float curRayDirection = (game.player.getDirection() - ((float) game.settings.getFOV() / 2) + 360) % 360;
        float raysK = (float) game.settings.getFOV() / (float) game.settings.getScreenSize().width;
        for (int rayNum = 0; rayNum < game.settings.getScreenSize().width; rayNum++) {
            wall closestObject = new wall(new float[]{0, 0}, new float[]{0, 0}, Color.black);
            double closestDistance = 99999;
            double rayTG = Math.tan(Math.toRadians(90 - curRayDirection));
            float[] rayB = new float[]{10 + game.player.getPosition()[0], (float) (rayTG * 10) + game.player.getPosition()[1]};
            float[] playerPos = game.player.getPosition();
            float pixNum = 0;

            for (wall object : game.world.getObjects()) {
                float[] intersec = functions.getVectorsIntersec(object.getA(), object.getB(), playerPos, rayB);
                float[] objB = object.getB();
                float[] objA = object.getA();
                if (intersec.length != 2) continue;
                if (!(intersec[0] >= object.getB()[0] && intersec[0] <= object.getA()[0])) continue;
                if (!(intersec[1] >= Math.min(objA[1], objB[1]) && intersec[1] <= Math.max(objA[1], objB[1]))) continue;
                if ((curRayDirection >= 0 && curRayDirection < 180 && (intersec[0] - playerPos[0]) > 0) ||
                        ((curRayDirection >= 180 && curRayDirection < 360 && (intersec[0] - playerPos[0]) < 0))) {

                    double distance = Math.sqrt((intersec[0] - playerPos[0]) * (intersec[0] - playerPos[0]) + (intersec[1] - playerPos[1]) * (intersec[1] - playerPos[1]));
                    if (distance < closestDistance) {
                        closestDistance = distance;
                        closestObject = object;
                        pixNum = (intersec[0] - objB[0]) / (objA[0] - objB[0]);
                    }
                }

            }

            curRayDirection = (curRayDirection + raysK + 360) % 360;
            int screenHeight = game.settings.getScreenSize().height;
            if ((int) closestDistance > screenHeight) continue;
            int size = (int) Math.round((float) screenHeight * 20 / closestDistance);
            int start = (screenHeight - size) / 2;
            if (!closestObject.getColor().equals(Color.MAGENTA)) {
                g.setColor(closestObject.getColor());


                g.drawLine(rayNum, start, rayNum, start + size);
            } else {
                BufferedImage texture = closestObject.getTexture();
                var line = texture.getSubimage((int) (texture.getWidth() * pixNum), 0, 1, texture.getHeight());
                g.drawImage(line, rayNum, start, 1, size, this);
            }


        }
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.drawString(String.valueOf(FPS), 15, 25);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
        if (isSHIFT) game.player.run();
        else game.player.walk();
        if (isW && isD) game.player.moveFR();
        else if (isW && isA) game.player.moveFL();
        else if (isW) game.player.moveF();
        else if (isS && isD) game.player.moveBR();
        else if (isS && isA) game.player.moveBL();
        else if (isD) game.player.moveR();
        else if (isA) game.player.moveL();
        else if (isS) game.player.moveB();
        FPS = (int) (1000000000 / (System.nanoTime() - time));
        time = System.nanoTime();
    }
}
