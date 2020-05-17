import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Game extends JPanel implements KeyListener {
    private String bgFileName = "sky.jpg";
    public static int bgWidth;
    public static int bgHeight;
    public boolean running = true;
    private BufferedImage bg;
    private int bgX = 0;
    private Bird bird = new Bird(new Rectangle(60, 200, 60, 60));
    private Obstacle obstacle = new Obstacle(bird.step);

    public Game() {
        try {
            bg = ImageIO.read(new File(bgFileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        bgWidth = bg.getWidth();
        bgHeight = bg.getHeight();

        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(bgWidth, bgHeight));
    }

    public void moveObjects() {
        bird.fly();
        bgX = bgX - bird.step;
        obstacle.redrawObstacle();

        if (bird.flyUp) {
            bird.flyUp();
            bird.flyUp = false;
        }
        
        if (bird.getBirdBorders().intersects(obstacle.getObstacleBorders()) ||
            bird.getBirdBorders().getY() <= 0 ||
            bird.getBirdBorders().getY() >= Game.bgHeight) {
            running = false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = bgWidth;
        g.drawImage(bg, bgX % width, 0, this);
        g.drawImage(bg, (bgX % width) + bg.getWidth(), 0, this);
        bird.drawBird(g);
        obstacle.createObstacle(g);

        if (bgX >= 0) {
            g.drawImage(bg, (bgX % width) - bg.getWidth(), 0, this);
            bird.drawBird(g);
            obstacle.createObstacle(g);
        }

        if (obstacle.getObstacleBorders().getX() <= 0) {
            obstacle = new Obstacle(bird.step);
            obstacle.createObstacle(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKey = e.getKeyCode();

        if (pressedKey == KeyEvent.VK_UP) {
            bird.flyUp = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}
}