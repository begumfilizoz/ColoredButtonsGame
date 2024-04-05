import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 * GamePanel
 */

public class GamePanel extends JPanel {
    public static int score = 10;
    public static int buttons = 0;
    private int depth;
    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private final int RED_B;
    private final int GREEN_B;
    private final int BLUE_B;
    private int c1;
    private int c2;
    private int c3;
    private int c4;
    private ActionListener listener1;
    private ActionListener listener2;
    private ActionListener listener3;
    private ActionListener listener4;
    private GamePanel panel;
    private GamePanel panel1;
    private GamePanel panel2;
    private GamePanel panel3;
    private GamePanel panel4;



    public GamePanel( int depth, JFrame frame )
    {
        this.panel = this;
        this.depth = depth;
        this.frame = frame;
        this.frame.setTitle("Score: " + score );
        panel = this;
        RED_B = 0;
        GREEN_B = 1;
        BLUE_B = 2;
        this.setLayout(new GridLayout(2, 2));
        listener1 = new ButtonListener1();
        listener2 = new ButtonListener2();
        listener3 = new ButtonListener3();
        listener4 = new ButtonListener4();
        if ( depth == 0 )
        {
            Random rand = new Random();
            buttons += 4;
            button1 = new JButton();
            c1 = rand.nextInt(3);
            if ( c1 == RED_B )
            {
                button1.setBackground(Color.RED);
            }
            else if ( c1 == GREEN_B )
            {
                button1.setBackground(Color.GREEN);
            }
            else
            {
                button1.setBackground(Color.BLUE);
            }
            button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button1.setOpaque(true);
            this.add(button1);
            button2 = new JButton();
            c2 = rand.nextInt(3);
            if ( c2 == RED_B )
            {
                button2.setBackground(Color.RED);
            }
            else if ( c2 == GREEN_B )
            {
                button2.setBackground(Color.GREEN);
            }
            else
            {
                button2.setBackground(Color.BLUE);
            }
            button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button2.setOpaque(true);
            
            this.add(button2);
            button3 = new JButton();
            c3 = rand.nextInt(3);
            if ( c3 == RED_B )
            {
                button3.setBackground(Color.RED);
            }
            else if ( c3 == GREEN_B )
            {
                button3.setBackground(Color.GREEN);
            }
            else
            {
                button3.setBackground(Color.BLUE);
            }
            button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button3.setOpaque(true);
            
            this.add(button3);
            button4 = new JButton();
            c4 = rand.nextInt(3);
            if ( c4 == RED_B )
            {
                button4.setBackground(Color.RED);
            }
            else if ( c4 == GREEN_B )
            {
                button4.setBackground(Color.GREEN);
            }
            else
            {
                button4.setBackground(Color.BLUE);
            }
            button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button4.setOpaque(true);
            
            this.add(button4);   
            if ( c1 == c2 && c1 == c3 && c1 == c4 )
            {
                button1.setBackground(Color.gray);
                button2.setBackground(Color.gray);
                button3.setBackground(Color.gray);
                button4.setBackground(Color.gray);
                buttons -= 4;
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                score += 10;
                this.frame.setTitle("Score: " + score);
            }
            button1.addActionListener(listener1);
            button2.addActionListener(listener2);
            button3.addActionListener(listener3);
            button4.addActionListener(listener4);

            if ( score <= 0 || buttons == 0 )
            {
                int again = JOptionPane.showConfirmDialog(frame ,"Do you want to play again?","Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if ( again == JOptionPane.YES_OPTION)
                {
                    score = 10;
                    buttons = 0;
                    this.frame.setVisible(false);
                    this.frame = new GameFrame();
                    this.frame.setResizable(false);
                    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.frame.setVisible(true);
                    
                }
                else if ( again == JOptionPane.NO_OPTION )
                {
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
            }
    

        }
        if ( depth > 0 )
        {
            panel1 = new GamePanel( depth - 1, this.frame);
            this.add(panel1);
            panel2 = new GamePanel( depth - 1, this.frame);
            this.add(panel2);
            panel3 = new GamePanel( depth - 1, this.frame);
            this.add(panel3);
            panel4 = new GamePanel( depth - 1, this.frame);
            this.add(panel4);
        }  
    }

    // Action listener for Update button
    class ButtonListener1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            score -= 1;
            frame.setTitle("Score: " + score );
            Random rand = new Random();
            int color = rand.nextInt(3);
            if ( color == RED_B )
            {
                button1.setBackground(Color.RED);
            }
            else if ( color == GREEN_B )
            {
                button1.setBackground(Color.GREEN);
            }
            else
            {
                button1.setBackground(Color.BLUE);
            }
            //button.setBorderPainted(false);
            button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button1.setOpaque(true);
           
            if ( button1.getBackground() == button2.getBackground() && button1.getBackground() == button3.getBackground() 
            && button1.getBackground() == button4.getBackground())
            {
                button1.setBackground(Color.gray);
                button2.setBackground(Color.gray);
                button3.setBackground(Color.gray);
                button4.setBackground(Color.gray);
                buttons -= 4;
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                score += 10;
                frame.setTitle("Score: " + score);
            }

            if ( score <= 0 || buttons == 0 )
            {
                int again = JOptionPane.showConfirmDialog(frame ,"Do you want to play again?","Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if ( again == JOptionPane.YES_OPTION)
                {
                    score = 10;
                    buttons = 0;
                    frame.setVisible(false);
                    frame = new GameFrame();
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    
                }
                else if ( again == JOptionPane.NO_OPTION )
                {
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }

    // Action listener for Update button
    class ButtonListener2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            score -= 1;
            frame.setTitle("Score: " + score );
            Random rand = new Random();
            int color = rand.nextInt(3);
            if ( color == RED_B )
            {
                button2.setBackground(Color.RED);
            }
            else if ( color == GREEN_B )
            {
                button2.setBackground(Color.GREEN);
            }
            else
            {
                button2.setBackground(Color.BLUE);
            }
            //button.setBorderPainted(false);
            button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button2.setOpaque(true);
           
            if ( button1.getBackground() == button2.getBackground() && button1.getBackground() == button3.getBackground() 
            && button1.getBackground() == button4.getBackground())
            {
                button1.setBackground(Color.gray);
                button2.setBackground(Color.gray);
                button3.setBackground(Color.gray);
                button4.setBackground(Color.gray);
                buttons -= 4;
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                score += 10;
                frame.setTitle("Score: " + score);
            }
            if ( score <= 0 || buttons == 0 )
            {
                int again = JOptionPane.showConfirmDialog(frame ,"Do you want to play again?","Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if ( again == JOptionPane.YES_OPTION)
                {
                    score = 10;
                    buttons = 0;
                    frame.setVisible(false);
                    frame = new GameFrame();
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    
                }
                else if ( again == JOptionPane.NO_OPTION )
                {
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }

    // Action listener for Update button
    class ButtonListener3 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            score -= 1;
            frame.setTitle("Score: " + score );
            Random rand = new Random();
            int color = rand.nextInt(3);
            if ( color == RED_B )
            {
                button3.setBackground(Color.RED);
            }
            else if ( color == GREEN_B )
            {
                button3.setBackground(Color.GREEN);
            }
            else
            {
                button3.setBackground(Color.BLUE);
            }
            //button.setBorderPainted(false);
            button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button3.setOpaque(true);
   
            if ( button1.getBackground() == button2.getBackground() && button1.getBackground() == button3.getBackground() 
            && button1.getBackground() == button4.getBackground())
            {
                button1.setBackground(Color.gray);
                button2.setBackground(Color.gray);
                button3.setBackground(Color.gray);
                button4.setBackground(Color.gray);
                buttons -= 4;
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                score += 10;
                frame.setTitle("Score: " + score);
            }
            if ( score <= 0 || buttons == 0 )
            {
                int again = JOptionPane.showConfirmDialog(frame ,"Do you want to play again?","Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if ( again == JOptionPane.YES_OPTION)
                {
                    score = 10;
                    buttons = 0;
                    frame.setVisible(false);
                    frame = new GameFrame();
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
                else if ( again == JOptionPane.NO_OPTION )
                {
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }

    // Action listener for Update button
    class ButtonListener4 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            score -= 1;
            frame.setTitle("Score: " + score );
            Random rand = new Random();
            int color = rand.nextInt(3);
            if ( color == RED_B )
            {
                button4.setBackground(Color.RED);
            }
            else if ( color == GREEN_B )
            {
                button4.setBackground(Color.GREEN);
            }
            else
            {
                button4.setBackground(Color.BLUE);
            }
            //button.setBorderPainted(false);
            button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button4.setOpaque(true);
        
            if ( button1.getBackground() == button2.getBackground() && button1.getBackground() == button3.getBackground() 
            && button1.getBackground() == button4.getBackground())
            {
                button1.setBackground(Color.gray);
                button2.setBackground(Color.gray);
                button3.setBackground(Color.gray);
                button4.setBackground(Color.gray);
                buttons -= 4;
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                score += 10;
                frame.setTitle("Score: " + score);
            }
            if ( score <= 0 || buttons == 0 )
            {
                int again = JOptionPane.showConfirmDialog(frame ,"Do you want to play again?","Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if ( again == JOptionPane.YES_OPTION)
                {
                    score = 10;
                    buttons = 0;
                    frame.setVisible(false);
                    frame = new GameFrame();
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    
                }
                else if ( again == JOptionPane.NO_OPTION )
                {
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }

    public int getScore()
    {
        return score;
    }
    
}