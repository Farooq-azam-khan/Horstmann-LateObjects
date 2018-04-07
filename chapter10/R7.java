/**
10.7 You can exit a graphical program by calling System.exit(0). Describe how to provide
an Exit button that functions in the same way as closing the window. Should you
still call setDefaultCloseOperation on the frame?
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class R7 extends JFrame
{
  public static void main(String[] args)
  {
    JFrame frame = new R7();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public R7()
  {
    JButton exit_btn = new JButton("exit");
    exit_btn.addActionListener(new ExitListener());
    this.add(exit_btn);
    this.setTitle("R7");
    this.setSize(400, 400); 
  }

  private class ExitListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      System.exit(0);

    }
  }
}
