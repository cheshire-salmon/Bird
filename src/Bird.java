import java.awt.*;

public class Bird {

	public Rectangle birdBorders;
	public final int step = 10;
	public boolean flyUp = false;

	public Bird(Rectangle birdBorders) {
		this.birdBorders = birdBorders;
	}

	public void fly() {
		birdBorders.setLocation((int) birdBorders.getX(), (int) birdBorders.getY() + step);
	}

	public void flyUp() {
		if (flyUp) {
			birdBorders.setLocation((int) birdBorders.getX(), (int) birdBorders.getY() - 60);
		}
	}

	public Rectangle getBirdBorders() {
		return this.birdBorders;
	}

	public void drawBird(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) birdBorders.getX(), (int) birdBorders.getY(), (int) birdBorders.getWidth(), (int) birdBorders.getHeight());
	}
}