import javax.swing.JFrame;

import javax.swing.JComponent;

public class ChartViewer
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.setTitle("10.4: chart example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComponent chart = new ChartComponent();
    frame.add(chart);

    frame.setVisible(true);
  }
}
