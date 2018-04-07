/**
P10.1
Write a program that shows a square frame filled with 100 buttons labeled 1 to 100.
Nothing needs to happen when you press any of the buttons.
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class P1
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    for (int i=0; i<100; i++)
    {
      panel.add(new JButton(i+"th button"));
    }

    frame.add(panel);
    frame.setSize(500, 500);
    frame.setTitle("P1: 100 buttons");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}
