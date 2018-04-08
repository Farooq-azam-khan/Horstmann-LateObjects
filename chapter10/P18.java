/**
P10.18
Draw a "bull's eye"—a set of concentric rings in alternating black and white colors.
Hint: Fill a black circle, then fill a smaller white circle on top, and so on. Your program
should be composed of classes BullsEyeComponent and BullsEyeViewer.
*/



import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Color;
// face viewer class
public class P18
{
  public static final int FRAME_WIDTH = 500;
  public static final int FRAME_HEIGHT = 500;

  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    JComponent face = new BullsEyeComponent();
    frame.add(face);
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class BullsEyeComponent extends JComponent
{
  public void paintComponent(Graphics g)
  {
    // TODO: MAKE IT CENTERED; 
    int x = 100;
    int y = 100;
    int r = 200;

    g.drawOval(x, y, r, r);
    g.setColor(Color.BLACK);
    g.fillOval(x, y, r, r);

    // x = (x)/2;
    // y = (y)/2;
    r = (int) (r/1.5);
    g.setColor(Color.WHITE);
    g.fillOval(x, y, r, r);

    // x = (x)/2;
    // y = (y)/2;
    r = (int) (r/1.5);
    g.setColor(Color.BLACK);
    g.fillOval(x, y, r, r);

    // x = (x)/2;
    // y = (y)/2;
    r = (int) (r/1.5);
    g.setColor(Color.WHITE);
    g.fillOval(x, y, r, r);

    // x = (x)/2;
    // y = (y)/2;
    r = (int) (r/1.5);
    g.setColor(Color.BLACK);
    g.fillOval(x, y, r, r);
  }
}
