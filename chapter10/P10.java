/**
P10.10
Write a graphical application describing an earthquake, as in Section 3.3.
Supply a text field and button for entering the strength of the earthquake.
Display the earthquake description in a label.
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class P10
{
  // TODO: add some more features
  public static void main(String[] args)
  {
    JFrame frame = new EarthQuakeDescription();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class EarthQuakeDescription extends JFrame
{
  JPanel main_panel;
  JLabel returnDescriptionLabel;
  JTextField enterStrengethTF;
  JButton enterStrengthButton;

  EarthQuakeDescription()
  {
    main_panel = new JPanel();
    enterStrengthButton = new JButton("enter mag");
    returnDescriptionLabel = new JLabel();
    enterStrengthButton.addActionListener(new GetStrengthListener());
    enterStrengethTF = new JTextField(10);

    // add to panel and frame
    main_panel.add(new JLabel("Strength"));
    main_panel.add(enterStrengethTF);
    main_panel.add(enterStrengthButton);
    main_panel.add(returnDescriptionLabel);

    this.add(main_panel);

    // frame constants
    this.setSize(500, 600);
    this.setTitle("Earthquake Simmulator");
  }


  private class GetStrengthListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (enterStrengethTF.getText().length() >=1)
      {
        double mag = Double.parseDouble(enterStrengethTF.getText());
        if (mag >= 8.0)
        {
          returnDescriptionLabel.setText("Most structures fall");
        }
        else if (mag >= 7.0)
        {
          returnDescriptionLabel.setText("Many buildings destroyed");
        }
        else if (mag >= 6.0)
        {
          returnDescriptionLabel.setText("Many buildings considerably damaged, some collapse");
        }
        else if (mag >= 4.5)
        {
          returnDescriptionLabel.setText("Damage to poorly constructed buildings");
        }
        else
        {
          returnDescriptionLabel.setText("No destruction of buildings");
        }
      }
    }
  }


}
