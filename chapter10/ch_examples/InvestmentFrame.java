import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class InvestmentFrame extends JFrame
{
  // frame info
  private final int FRAME_WIDTH = 300;
  private final int FRAME_HEIGHT = 300;

  // components
  private JPanel investment_panel;
  private JButton interest_button;
  private JLabel display_interest_label;
  private JTextArea historyTextArea;

  // instance
  private double balance;
  private static final double INTEREST_RATE = 5.0;
  private static final double INITIAL_BALANCE = 1000;

  public InvestmentFrame()
  {
    this.balance = INITIAL_BALANCE;
    // run instance method
    createInvestmentComponents();

    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setTitle("investment example");
  }

  public void createInvestmentComponents()
  {
    investment_panel = new JPanel();

    // button
    interest_button = new JButton("add interest");
    interest_button.addActionListener(new InterestButtonClickListener());

    // current balance
    display_interest_label = new JLabel();


    investment_panel.add(interest_button);
    investment_panel.add(display_interest_label);
    addHistory();
    
    this.add(investment_panel);
  }
  public void addHistory()
  {
    JPanel hist_panel = new JPanel();
    historyTextArea = new JTextArea();
    historyTextArea.setText("history: \n");
    historyTextArea.setEditable(false);
    hist_panel.add(historyTextArea);
    investment_panel.add(hist_panel);
  }

  private class InterestButtonClickListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      balance += balance*(INTEREST_RATE / 100.0);
      display_interest_label.setText(String.format("interest: $%.2f", balance));

      historyTextArea.append(String.format("$%.2f\n", balance));
    }
  }
}
