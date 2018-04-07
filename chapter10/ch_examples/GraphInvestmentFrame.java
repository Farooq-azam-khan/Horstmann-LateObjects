import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphInvestmentFrame extends JFrame
{
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 400;

  private static final int CHART_WIDTH = 300;
  private static final int CHART_HEIGHT = 300;

  private static final int DEFAULT_RATE = 5;
  private static final int INITIAL_BALANCE = 1000;

  private JLabel rateLabel;
  private JButton rateButton;
  private JTextField rateField;
  private GraphInterestRate chart;
  private double balance;

  GraphInvestmentFrame()
  {
    balance = INITIAL_BALANCE;
    chart = new GraphInterestRate(3 * INITIAL_BALANCE);
    chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
    chart.append(INITIAL_BALANCE);

    createTextField();
    createButton();
    createPanel();
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setTitle("10.4: Graphing Investment price");
  }
  public void createTextField()
  {
    rateLabel = new JLabel("Interest Rate");
    final int FIELD_WIDTH = 10;
    rateField = new JTextField(FIELD_WIDTH);
    rateField.setText("" + DEFAULT_RATE);

  }
  public void createButton()
  {
    rateButton = new JButton("Add Interest");
    rateButton.addActionListener(new AddIRAL());

  }
  public void createPanel()
  {
    JPanel panel = new JPanel();
    panel.add(rateLabel);
    panel.add(rateField);
    panel.add(rateButton);
    panel.add(chart);
    this.add(panel);

  }

  private class AddIRAL implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      double rate = Double.parseDouble(rateField.getText());
      double interest = balance * (rate / 100.0);
      balance += interest;
      chart.append(balance);
    }
  }
}
