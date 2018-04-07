import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class ChartComponent extends JComponent
{
  public void paintComponent(Graphics g)
  {
    g.fillRect(10, 10, 200, 10);
    g.fillRect(10, 30, 300, 10);
    g.fillRect(10, 50, 100, 10);
    g.drawOval(30, 20, 100, 100);
    g.setColor(Color.YELLOW);
    g.fillOval(30, 20, 100, 100);
    g.setColor(Color.BLACK);
    g.drawLine(10, 500, 200, 40);

    g.drawString("Message", 400, 40);

  }
}
