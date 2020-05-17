import java.awt.*;
import java.util.*;

public class Obstacle {
    private Rectangle obstacleBorders;
    private final int obstacleWidth = 60;
    private int step;

    public Obstacle(int step) {
        this.step = step;
        Random rnd = new Random();
        int obstacleHeight = rnd.nextInt(150) + 200;
        int obstacleOffset = rnd.nextInt(500);
        obstacleBorders = new Rectangle(Game.bgWidth, obstacleOffset, obstacleWidth, obstacleHeight);
    }

    public Rectangle getObstacleBorders() {
        return this.obstacleBorders;
    }


    public void createObstacle(Graphics g) {

        g.setColor(Color.RED);

        g.fillRect((int) obstacleBorders.getX(), (int) obstacleBorders.getY(), (int) obstacleBorders.getWidth(),
                (int) obstacleBorders.getHeight());
    }

    public void redrawObstacle() {
        obstacleBorders.setLocation((int) obstacleBorders.getX() - step, (int) obstacleBorders.getY());
    }
}