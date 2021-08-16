/*
Author: Justin Ong
Date: 4 Dec 2017
Course: CS111B
Extra Credit Assignment #2
Objective:
 - Applet that has a circle and 6 buttons
 - Buttons can move, inflate, and deflate circle
 - Circle cannot go beyond buttons or screen
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControlCircleApp
{
    static class ButtonsCircleFrame extends Frame
    {
        private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        private Double w = screenSize.getWidth();
        private Double h = screenSize.getHeight();
        private int x = w.intValue()/2;
        private int y = h.intValue()/2;
        private int a = 100;
        private int b = 100;

        private Button deflate;

        //*****************************constructor*****************************
        public ButtonsCircleFrame()
        {
            Button left = new Button("Left");
            Button up = new Button("Up");
            Button right = new Button("Right");
            Button down = new Button("Down");
            Button inflate = new Button("Inflate");
            deflate = new Button("Deflate");
            add(left);
            add(up);
            add(right);
            add(down);
            add(inflate);
            add(deflate);
            setSize(w.intValue(), h.intValue());
            setTitle("Shape and Buttons");
            setLayout(new FlowLayout());
            setVisible(true);

            left.addActionListener(new LeftListener());
            up.addActionListener(new UpListener());
            right.addActionListener(new RightListener());
            down.addActionListener(new DownListener());
            inflate.addActionListener(new InflateListener());
            deflate.addActionListener(new DeflateListener());

        }

        //*****************************LeftListener*****************************
        class LeftListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                int tmpLeftX = x;
                x -= 10;

                if ( x >= 0)
                {
                    repaint();
                }
                else
                {
                    x = tmpLeftX;
                }
            }
        }

        //*****************************UpListener*****************************
        class UpListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                int maxY = deflate.getLocation().y + deflate.getHeight();
                int tmpY = y;
                y -= 10;

                if ( y >= maxY)
                {
                    repaint();
                }
                else
                {
                    y = tmpY;
                }
            }
        }

        //*****************************RightListener*****************************
        class RightListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                int tmpRightX = x;
                x += 10;

                if ( x <= (w.intValue() - a))
                {
                    repaint();
                }
                else
                {
                    x = tmpRightX;
                }
            }
        }

        //*****************************DownListener*****************************
        class DownListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                int tmpBottomY = y;
                y += 10;
                int maxY = deflate.getLocation().y + deflate.getHeight() + 14; //14 = padding
                if ( y <= (h.intValue() - b - maxY))
                //if ( y <= (h.intValue() - (180)))
                {
                    repaint();
                }
                else
                {
                    y = tmpBottomY;
                }
            }
        }

        //*****************************InflateListener*****************************
        class InflateListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                a += 10;
                b += 10;
                repaint();
            }
        }

        //*****************************DeflateListener*****************************
        class DeflateListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                a -= 10;
                b -= 10;
                repaint();
            }
        }

        //*****************************paint()*****************************
        public void paint(Graphics g)
        {
            g.setColor(Color.orange);
            g.fillOval(x,y,a,b);
        }
    }

    public static void closeFrame(Frame f)
    {
        f.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //*****************************main()*****************************
    public static void main(String args[])
    {
        ButtonsCircleFrame buttonsCircleFrame = new ButtonsCircleFrame();
        closeFrame(buttonsCircleFrame);
    }
}