import javax.swing.*;

public class Main {
    private static int sleepTime = 50; // ms

    public static void main(String[] args) {
        JFrame jf = new JFrame("I Believe I Can Fly");
        Game game = new Game();
        jf.setSize(game.bgWidth, game.bgHeight);
        jf.add(game);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        while (game.running) {
            game.moveObjects();
            game.repaint();

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}