/**
R10.4
What happens if you add a button and a label directly to a JFrame without using a
JPanel? What happens if you add the label first? Try it out, by modifying the program
in Section 10.1.2, and report your observations.
*/
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
