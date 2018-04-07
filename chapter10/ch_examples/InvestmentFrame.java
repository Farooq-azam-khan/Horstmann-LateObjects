import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class InvestmentFrame extends JFrame
{
  // frame info
  private final int FRAME_WIDTH = 400;
  private final int FRAME_HEIGHT = 250;

  // components
  private JPanel investment_panel, main_panel, history_panel;
  private JButton interest_button;
  private JLabel display_interest_label;

  private JTextArea historyTextArea;
  private final int AREA_ROWS = 10;
  private final int AREA_COLUMNS = 30;

  private int FIELD_WIDTH = 10;
  private JTextField get_interest;

  // instance
  private double balance;
  private static final double INTEREST_RATE = 5.0;
  private static final double INITIAL_BALANCE = 1000;

  public InvestmentFrame()
  {
    this.balance = INITIAL_BALANCE;

    main_panel = new JPanel(new GridLayout(4, 4));
    // run instance method
    createInvestmentComponents();

    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setTitle("investment example");
  }

  public void createInvestmentComponents()
  {
    investment_panel = new JPanel();

    // text field
    JLabel ir = new JLabel("interest rate: ");
    get_interest = new JTextField(FIELD_WIDTH);
    // button
    interest_button = new JButton("add interest");
    interest_button.addActionListener(new InterestButtonClickListener());

    // current balance
    display_interest_label = new JLabel();

    investment_panel.add(ir);
    investment_panel.add(get_interest);
    investment_panel.add(interest_button);
    investment_panel.add(display_interest_label);
    main_panel.add(investment_panel);
    addHistory();

    this.add(main_panel);
  }
  public void addHistory()
  {
    history_panel = new JPanel();
    historyTextArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
    historyTextArea.setText("history: \n");
    historyTextArea.setEditable(false);
    history_panel.add(historyTextArea);
    main_panel.add(history_panel);
  }

  private class InterestButtonClickListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if (get_interest.getText().length() >= 1)
      {
        double rate = Double.parseDouble(get_interest.getText());
        balance += balance*(rate / 100.0);
        display_interest_label.setText(String.format("interest: $%.2f", balance));
        historyTextArea.setText("");
        historyTextArea.append(String.format("$%.2f\n", balance));
      }
      else
      {
        historyTextArea.setText("no rate given\n");
      }
    }
  }
}
