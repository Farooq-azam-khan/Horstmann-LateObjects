/**
P10.2
Enhance the ButtonViewer1 program in Section 10.2.1 so that it prints a message
"I was clicked n times!" whenever the button is clicked. The value n should be incremented
with each click.

P10.3
Enhance the ButtonViewer1 program in Section 10.2.1 so that it has two buttons, each
of which prints a message "I was clicked n times!" whenever the button is clicked.
Each button should have a separate click count.

P10.4
Enhance the ButtonViewer1 program in Section 10.2.1 so that it has two buttons
labeled A and B, each of which prints a message "Button x was clicked!", where x is
A or B.

P10.5
Implement a ButtonViewer1 program as in Exercise P10.3 using only a single listener
class. Hint: Pass the button label to the constructor of the listener.
*/

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P2P3P4P5 extends JFrame
{
  public static void main(String[] args)
  {
    JFrame frame = new P2P3P4P5();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private int b1_cc = 0;
  private int b2_cc = 0;
  JLabel label;

  public P2P3P4P5()
  {
    JPanel panel = new JPanel();
    JButton b1 = new JButton("buttonA");
    b1.addActionListener(new B1ClickCount());
    JButton b2 = new JButton("buttonB");
    b2.addActionListener(new B2ClickCount());
    label = new JLabel();

    panel.add(b1);
    panel.add(b2);
    panel.add(label);
    this.add(panel);
    this.setTitle("P10.2");
    this.setSize(400, 400);
  }

  private class B1ClickCount implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      b1_cc++;
      label.setText(
      String.format("Button A clicked: \n buttonA: %d clicks buttonB: %d clicks",
      b1_cc, b2_cc));
    }
  }

  private class B2ClickCount implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      b2_cc++;
      label.setText(
      String.format("Button B clicked: \n buttonA: %d clicks buttonB: %d clicks",
      b1_cc, b2_cc));
    }
  }
}
