package com.justinong;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorFactory {

  public static void main(String[] args) {
    new ColorFactoryFrame();
  }

  /*Internal Classes*/
  static class ColorFactoryFrame extends Frame implements ItemListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Double w = screenSize.getWidth();
    private Double h = screenSize.getHeight();

    //These variables are needed to be modified in the methods outside of the Constructor `public ColorFactoryFrame()`
    Scrollbar redSlider, greenSlider, blueSlider;
    Label redBarLabel, greenBarLabel, blueBarLabel;
    CheckboxGroup cbg;

    //Constructor
    public ColorFactoryFrame() {
      //Set up frame
      Frame frame = new Frame();
      frame.setTitle("Color Factory");
      frame.setSize(w.intValue(), h.intValue());
      closeFrame(frame);

      frame.add(getLabel("Color Factory"), BorderLayout.NORTH);

      //Objects for Panel 1: Circle
      CirclePanel circleComponent = new CirclePanel();

      //Objects for Panel 2: Sliders
      redSlider = new Scrollbar(Scrollbar.HORIZONTAL, 60, 0, 0, 255);
      Label redSliderValue = new Label("Red");
      greenSlider = new Scrollbar(Scrollbar.HORIZONTAL, 60, 0, 0, 255);
      Label greenSliderValue = new Label("Green");
      blueSlider = new Scrollbar(Scrollbar.HORIZONTAL, 60, 0, 0, 255);
      Label blueSliderValue = new Label("Blue");

      //Objects for Panel 3: Bars
      RectangleComponent redBar = new RectangleComponent(Color.RED);
      RectangleComponent greenBar = new RectangleComponent(Color.GREEN);
      RectangleComponent blueBar = new RectangleComponent(Color.BLUE);

      String redValue = String.valueOf(redSlider.getValue());
      String greenValue = String.valueOf(greenSlider.getValue());
      String blueValue = String.valueOf(greenSlider.getValue());

      redBarLabel = new Label(redValue);
      greenBarLabel = new Label(greenValue);
      blueBarLabel = new Label(blueValue);

      //Objects for Panel 4: Radio buttons
      Checkbox decimal, octal, binary, hex;
      cbg = new CheckboxGroup();
      decimal = new Checkbox("Decimal", cbg, false);
      octal = new Checkbox("Octal", cbg, false);
      binary = new Checkbox("Binary", cbg, false);
      hex = new Checkbox("Hex", cbg, false);

      //Main Panel:
      Panel mainPanel = new Panel();
      mainPanel.setLayout(new GridLayout(2, 2));

      //Add panel 1
      mainPanel.add(circleComponent);

      //Add panel 2
      Panel P2 = new Panel();
      P2.setLayout(new GridLayout(3, 2));

      //Set up listeners for sliders
      redSlider.addAdjustmentListener(new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
          redBar.updateHeight(e.getValue()); //Change height of the bar
          Color newColor = new Color(e.getValue(), greenSlider.getValue(), blueSlider.getValue());
          circleComponent.updateColor(newColor); //Set new color to oval
          updateDisplayRGBValue(cbg); //Update display label below the bar
        }
      });

      greenSlider.addAdjustmentListener(new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
          greenBar.updateHeight(e.getValue());
          Color newColor = new Color(redSlider.getValue(), e.getValue(), blueSlider.getValue());
          circleComponent.updateColor(newColor);
          updateDisplayRGBValue(cbg);
        }
      });

      blueSlider.addAdjustmentListener(new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
          blueBar.updateHeight(e.getValue());
          Color newColor = new Color(redSlider.getValue(), greenSlider.getValue(), e.getValue());
          circleComponent.updateColor(newColor);
          updateDisplayRGBValue(cbg);
        }
      });

      P2.add(redSlider);
      P2.add(redSliderValue);
      P2.add(greenSlider);
      P2.add(greenSliderValue);
      P2.add(blueSlider);
      P2.add(blueSliderValue);

      mainPanel.add(P2);

      //Add panel 3
      Panel P3 = new Panel();
      P3.setLayout(new GridLayout(2, 3));
      P3.add(redBar);
      P3.add(greenBar);
      P3.add(blueBar);
      P3.add(redBarLabel);
      P3.add(greenBarLabel);
      P3.add(blueBarLabel);
      mainPanel.add(P3);

      //Add panel 4
      Panel P4 = new Panel();
      P4.setLayout(new GridLayout(4, 1));

      decimal.addItemListener(this);
      octal.addItemListener(this);
      binary.addItemListener(this);
      hex.addItemListener(this);

      P4.add(decimal);
      P4.add(octal);
      P4.add(binary);
      P4.add(hex);
      mainPanel.add(P4);

      //Set up padding for West and East (might remove)
      frame.add(mainPanel, BorderLayout.CENTER);
//      int paddingSize = 200;
//      Panel westPadding = new Panel();
//      westPadding.setSize(paddingSize, 100);
//      Panel eastPadding = new Panel();
//      eastPadding.setSize(paddingSize, 100);
//      frame.add(westPadding, BorderLayout.WEST);
//      frame.add(eastPadding, BorderLayout.EAST);

      //Set frame visible
      frame.setVisible(true);
    }

    //Methods
    public static void closeFrame(Frame f) {
      f.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      });
    }

    private Label getLabel(String labelText) {
      Font font = new Font("Roboto", Font.PLAIN, 20);
      Label label = new Label(labelText, Label.CENTER);
      label.setSize(100, 20);
      label.setFont(font);
      return label;
    }

    private void updateDisplayRGBValue(CheckboxGroup cbg) {
      String red = String.valueOf(redSlider.getValue());
      String green = String.valueOf(greenSlider.getValue());
      String blue = String.valueOf(blueSlider.getValue());

      Checkbox selectedCheckBox = cbg.getSelectedCheckbox();

      if (selectedCheckBox != null) {

        if (selectedCheckBox.getLabel().equals("Octal")) {
          red = String.valueOf(Integer.toOctalString(redSlider.getValue()));
          green = String.valueOf(Integer.toOctalString(greenSlider.getValue()));
          blue = String.valueOf(Integer.toOctalString(blueSlider.getValue()));

        } else if (selectedCheckBox.getLabel().equals("Binary")) {
          red = String.valueOf(Integer.toBinaryString(redSlider.getValue()));
          green = String.valueOf(Integer.toBinaryString(greenSlider.getValue()));
          blue = String.valueOf(Integer.toBinaryString(blueSlider.getValue()));

        } else if (selectedCheckBox.getLabel().equals("Hex")) {
          red = String.valueOf(Integer.toHexString(redSlider.getValue()));
          green = String.valueOf(Integer.toHexString(greenSlider.getValue()));
          blue = String.valueOf(Integer.toHexString(blueSlider.getValue()));

        }
      }
      redBarLabel.setText(red);
      greenBarLabel.setText(green);
      blueBarLabel.setText(blue);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      updateDisplayRGBValue(cbg);
    }
  }

  static class CirclePanel extends Component {
    private Color color;

    CirclePanel() {
      color = new Color(60, 60, 60);
    }

    @Override
    public void paint(Graphics g) {
      g.setColor(color);
      g.fillOval(100, 100, 400, 300);
    }

    public void updateColor(Color color) {
      this.color = color;
      repaint();
    }
  }

  static class RectangleComponent extends Component {
    private Color color;
    private int height;

    RectangleComponent(Color color) {
      height = 60;
      this.color = color;
    }

    @Override
    public void paint(Graphics g) {
      g.setColor(color);
      g.fillRect(5, 5, 60, height);
    }

    public void updateHeight(int height) {
      this.height = height;
      repaint();
    }
  }
}
