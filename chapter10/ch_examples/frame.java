import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class frame
{



  public static void main(String[] args)
  {
    // constructs the frame
    JFrame frame = new InvestmentFrame();
    // closes application when frame is closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // shows the frame
    frame.setVisible(true);

    // JFrame frame2 = new JFrame();
    // frame2.setSize(500, 400);
    // frame2.setTitle("2 frames in one programe");
    // // both frame and frame2 close when clicked
    // frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame2.setVisible(true);
  }

}
