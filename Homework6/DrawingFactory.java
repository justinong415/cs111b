/*
Author: Justin Ong
Date: 17 Dec 2017
Course: CS111B
Homework: #6 Drawing Factory
Objective: A paint program with buttons for coloring, entering texts, and erasing
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingFactory extends Frame implements ActionListener, MouseMotionListener
{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Double w = screenSize.getWidth();
    private Double h = screenSize.getHeight();
    private int iw = w.intValue();
    private int ih = h.intValue();

    Label l = new Label("BLACK");
    Label m = new Label("");

    Canvas drawCanvas = new Canvas();

    //*****************************DrawingFactory()*****************************
    public DrawingFactory()
    {
        //frame and title
        Label title = new Label("Drawing Factory", Label.CENTER);
        title.setFont(new Font("Helvetica Neue", Font.BOLD,25));
        title.setBackground(Color.WHITE);
        setSize(iw, ih);
        closeFrame(this);

        //label for selected color
        l.setBounds(50,25,150,20);
        l.setBackground(Color.WHITE);
        m.setBounds(50, 45, 150, 20);
        m.setBackground(Color.WHITE);
        add(l);
        add(m);

        //textfield input
        TextField tf = new TextField("add text here!");

        //create drawing canvas
        drawCanvas.setBounds(0, 0, iw, ih);
        drawCanvas.setBackground(Color.WHITE);
        drawCanvas.setVisible(true);

        //create buttons
        Button redButton = new Button("red");
        Button greenButton = new Button("green");
        Button blueButton = new Button("blue");
        Button blackButton = new Button("black");
        Button yellowButton = new Button("yellow");
        Button textfieldButton = new Button("text field");
        Button eraseButton = new Button("eraser");
        Button clearButton = new Button("clear all");

        //create buttons panel and set BoxLayout for it
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new BoxLayout( buttonPanel, BoxLayout.Y_AXIS));

        //add buttons to buttons panel
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(blackButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(textfieldButton);
        buttonPanel.add(tf);
        buttonPanel.add(eraseButton);
        buttonPanel.add(clearButton);

        //*****************************addActionListeners*****************************
        redButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                l.setText("RED");
                Graphics g = drawCanvas.getGraphics();
            }
        });

        greenButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("GREEN");
                Graphics g = drawCanvas.getGraphics();
            }
        });

        blueButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("BLUE");
                Graphics g = drawCanvas.getGraphics();
            }
        });

        blackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("BLACK");
                Graphics g = drawCanvas.getGraphics();
            }
        });

        yellowButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("YELLOW");
                Graphics g = drawCanvas.getGraphics();
            }
        });

        textfieldButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("TEXTFIELD");
                m.setText(tf.getText());
                Graphics g = drawCanvas.getGraphics();
            }
        });

        eraseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l.setText("ERASER");
                Graphics g = drawCanvas.getGraphics();
            }
        });

        //*****************************addMouseMotionListener()*****************************
        drawCanvas.addMouseMotionListener(new MouseMotionListener()
        {
            public void mouseDragged(MouseEvent me)
            {
                m.setText("mouseDragged");
                m.setText("x = " + me.getX() + " y = " + me.getY());
                Graphics g = drawCanvas.getGraphics();
                if (l.getText().equals("RED"))
                {
                    g.setColor(Color.RED);
                    g.fillOval(me.getX(), me.getY(), 10, 10);
                }
                else if (l.getText().equals("GREEN"))
                {
                    g.setColor(Color.GREEN);
                    g.fillOval(me.getX(), me.getY(), 10, 10);
                }
                else if (l.getText().equals("BLUE"))
                {
                    g.setColor(Color.BLUE);
                    g.fillOval(me.getX(), me.getY(), 10, 10);
                }
                else if (l.getText().equals("BLACK"))
                {
                    g.setColor(Color.BLACK);
                    g.fillOval(me.getX(), me.getY(), 10, 10);
                }
                else if (l.getText().equals("YELLOW"))
                {
                    g.setColor(Color.YELLOW);
                    g.fillOval(me.getX(), me.getY(), 10, 10);
                }
                else if (l.getText().equals("ERASER"))
                {
                    g.setColor(Color.WHITE);
                    g.fillOval(me.getX(), me.getY(), 30, 30);
                }
                else if (l.getText().equals("TEXTFIELD"))
                {
                    String message = tf.getText();
                    g.drawString(message, me.getX(), me.getY());
                }
            }

            public void mouseMoved(MouseEvent me) {}
        });

        //*****************************clearButton*****************************
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                l.setText("BLACK");
                Graphics g = drawCanvas.getGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0,0, iw, ih);
            }
        });

        //add panels to frame, make frame visible
        this.add(drawCanvas);
        this.add(buttonPanel, BorderLayout.EAST);
        this.add(title, BorderLayout.NORTH);

        setVisible(true);
    }

    //*****************************actionPerformed()*****************************
    public void actionPerformed(ActionEvent ae){}

    //*****************************mouseDragged()*****************************
    public void mouseDragged(MouseEvent me){}

    //*****************************mouseMoved()*****************************
    public void mouseMoved(MouseEvent me){}

    //*****************************closeFrame()*****************************
    public static void closeFrame(Frame f)
    {
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);;
            }
        });
    }

    //*****************************main()*****************************
    public static void main(String args[])
    {
        new DrawingFactory();
    }
}