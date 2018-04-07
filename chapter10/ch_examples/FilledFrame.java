import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    // this.setTitle("welcome to chapter 10");
  }
  private void createComponents()
  {
    // JPanel
    panel = new JPanel();

    // JComponents
    button = new JButton("click button");
    ActionListener listenForButton = new ButtonClickListener();
    button.addActionListener(listenForButton);
    label = new JLabel("display label");

    panel.add(button);
    panel.add(label);
    this.add(panel);
  }


  // action event listenrs for button
  public class ButtonClickListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      label.setText("button was clicked");
    }
  }

}
