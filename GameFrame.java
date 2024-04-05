import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel panel;
    private JButton button;
    private int depth;

    public GameFrame()
    {
        setSize(800, 800);
        panel = new GamePanel(2, this);
        this.add( panel );
    }

    public int getScore()
    {
        return panel.getScore();
    }
}
