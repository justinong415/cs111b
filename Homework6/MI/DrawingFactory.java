// Author: Makhmud Islamov
// Date: 12/19/2017
// Homework assignment: 6
// Objective: create Drawing Factory app
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import com.sun.java_cup.internal.runtime.Symbol;

import javafx.scene.layout.Pane;

public class DrawingFactory extends Frame implements ActionListener, MouseMotionListener
{
    Button b1, b2, b3,b4, b5, b6;
    Label l1, l2;
    TextField tf;
    Panel p1, p2;
    Dimension d;
    String str;
    //*************************************main()*******************************************/
    public static void main(String...args) 
    {
        DrawingFactory df =  new DrawingFactory();
        closeFrame(df);
    }
    //*************************************DrawingFactory()*******************************************/
    public DrawingFactory()
    {
        // settting screensize and background color
        Toolkit tk = Toolkit.getDefaultToolkit();
        d = tk.getScreenSize();
        setSize(d.width, d.height);
        setBackground(Color.WHITE);
      l1 = new Label("Drawing Factory");
      b1 = new Button("Black");
      b2 = new Button("Green");
      b3 = new Button("Red");
      b4 = new Button("Blue");
      b5 = new Button("Erase");
      b6 = new Button("Clear");
      l2 = new Label("Type a symbol below");
      tf = new TextField(10);
      p1 = new Panel(new GridLayout(8,1)); // put all the button inside p1
      p1.add(b1);
      p1.add(b2);
      p1.add(b3);
      p1.add(b4);
      p1.add(b5);
      p1.add(b6);  
      p1.add(l2);
      p1.add(tf);
      add(p1, BorderLayout.EAST); 
      p2 = new Panel();
      p2.add(l1);
      add(p2, BorderLayout.NORTH);
      b1.setForeground(Color.BLACK);//changing color of label
      b2.setForeground(Color.GREEN);
      b3.setForeground(Color.RED);
      b4.setForeground(Color.BLUE);//changing color of label
      b1.addActionListener(this);// catching the action event
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);// catching the action event
      b5.addActionListener(this);
      b6.addActionListener(this);
      addMouseMotionListener(this);
      setVisible(true);
    }
    //*************************************closeFrame()*******************************************/
    public static void closeFrame(Frame f)
    {
      f.addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent we)
        {
          System.exit(0);
        }
      });
    }
    //*************************************actionPerformed()*******************************************/
    public void actionPerformed(ActionEvent ae)//this method is called when you click a button.
    {  str = ae.getActionCommand();
        Graphics g = getGraphics();
        // clearing screen     
        if(str.equals("Clear")) repaint();
    }
    //*************************************mouseDragged()*******************************************/
    public void mouseDragged(MouseEvent me)
    {   
        Graphics g = getGraphics();      
        if(str.equals("Black")) g.setColor(Color.BLACK);
        else if(str.equals("Green")) g.setColor(Color.GREEN);
        else if(str.equals("Red")) g.setColor(Color.RED);
        else if (str.equals("Blue")) g.setColor(Color.BLUE);
        else if (str.equals("Erase")) g.setColor(Color.WHITE);
        // symbol as a brush = getText from textfield
        if(tf.getText().length() !=0)
        {
            g.drawString(tf.getText(), me.getX(), me.getY());
        }
        else if (tf.getText().length()==0)
        {
            g.fillOval(me.getX(), me.getY(), 10,10); 
        }
              
    }
    //*************************************mouseMoved()*******************************************/
    public void mouseMoved(MouseEvent me)
    {
    }
}