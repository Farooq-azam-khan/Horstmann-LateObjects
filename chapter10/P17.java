/**
P10.17
Write a program to plot the following face. Provide a class
FaceViewer and a class FaceComponent.
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JComponent;
// face viewer class
public class P17
{
  public static final int FRAME_WIDTH = 500;
  public static final int FRAME_HEIGHT = 500;

  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    JComponent face = new FaceComponent();
    frame.add(face);
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class FaceComponent extends JComponent
{
  public void paintComponent(Graphics g)
  {
    g.drawOval(100,100, 200, 200);
    g.drawOval(100+40, 100+40, 40, 40);
    g.drawOval(100+120, 100+40, 40, 40);
    g.drawLine(100+40, 100+150, 100+150, 100+150);
  }
}
