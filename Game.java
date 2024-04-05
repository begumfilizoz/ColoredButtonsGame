import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new GameFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
