import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
public class R4
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame();
    frame.add(new JLabel("hello this is the label"));
    frame.add(new JButton("this is the button"));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("R4");
    frame.setSize(500, 500);
    frame.setVisible(true);

  }
}
