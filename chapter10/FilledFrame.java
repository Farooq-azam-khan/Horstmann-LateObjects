import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FilledFrame extends JFrame
{
  // frame info
  private final int FRAME_WIDTH = 300;
  private final int FRAME_HEIGHT = 300;

  // components
  private JButton button;
  private JPanel panel;
  private JLabel label;

  public FilledFrame()
  {
    // run instance method
    createComponents();

    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    // sets the title of frame
    this.setTitle("welcome to section 10.1");
  }
  private void createComponents()
  {
    // JPanel
    panel = new JPanel();

    // JComponents
    button = new JButton("click button");
    label = new JLabel("display label");

    panel.add(button);
    panel.add(label);
    this.add(panel);
  }
}
