import javax.swing.JComponent;
import java.awt.Graphics;
import java.util.ArrayList;

public class GraphInterestRate extends JComponent
{
  private ArrayList<Double> vals;
  private Double max_val;
  GraphInterestRate(double max_val)
  {
    vals = new ArrayList<Double>();
    this.max_val = max_val;
  }

  public void append(double val)
  {
    vals.add(val);
    repaint();
  }
  public void paintComponent(Graphics g)
  {
    final int GAP = 5;
    final int BAR_HEIGHT = 10;

    int y = GAP;
    for (Double val: vals)
    {
      int bar_width = (int)(this.getWidth() * val / max_val);
      g.fillRect(10, y, bar_width, BAR_HEIGHT);
      y = GAP + y + BAR_HEIGHT;

    }


  }
}
