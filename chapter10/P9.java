/**
P10.9
Write a graphical application simulating a bank account. Supply text fields and buttons
for depositing and withdrawing money, and for displaying the current balance
in a label.
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;


public class P9
{
  // TODO: add some more features 
  public static void main(String[] args)
  {
    JFrame ba_frame = new BankAccountSimmulator();
    ba_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ba_frame.setVisible(true);
  }
}

class BankAccountSimmulator extends JFrame
{
  private double balance;
  private static final double INITIAL_BALANCE = 1000;

  JPanel main_panel, deposit_panel, withdraw_panel, transfer_panel, history_panel;
  JLabel show_balanceLabel, depositLabel, withdrawLabel, historyLabel, transferLabel, balanceLabel;
  JButton withdrawButton, depositButton, transferAmoutButton;
  JTextArea historyTA;

  JTextField depositAmoutTF, withdrawAmoutTF, transferToPersonTF;
  private static final int FIELD_WIDTH = 10;

  BankAccountSimmulator()
  {
    this.balance = INITIAL_BALANCE;

    main_panel = new JPanel(new GridLayout(4, 4));

    JPanel disp_bal = new JPanel();
    balanceLabel = new JLabel("Balance: $" + this.balance);
    disp_bal.add(balanceLabel);
    main_panel.add(disp_bal);

    createDeposit();
    createWithdraw();
    createTransfer();
    createHistory();

    this.add(main_panel);
    this.setSize(500, 600);
    this.setTitle("Bank Account Simmulator");
  }

  public void createDeposit()
  {
    deposit_panel = new JPanel();

    depositAmoutTF = new JTextField(FIELD_WIDTH);

    depositButton = new JButton("Deposit");
    depositButton.addActionListener(new DepositListener());

    // add to panles
    deposit_panel.add(new JLabel("Deposit"));
    deposit_panel.add(depositAmoutTF);
    deposit_panel.add(depositButton);
    main_panel.add(deposit_panel);
  }
  public void createWithdraw()
  {
    withdraw_panel = new JPanel();
    withdrawAmoutTF = new JTextField(FIELD_WIDTH);

    withdrawButton = new JButton("Withdraw");
    withdrawButton.addActionListener(new WithdrawListener());

    // add to panles
    withdraw_panel.add(new JLabel("Withdraw"));
    withdraw_panel.add(withdrawAmoutTF);
    withdraw_panel.add(withdrawButton);
    main_panel.add(withdraw_panel);
  }
  public void createTransfer()
  {
    transfer_panel = new JPanel();
    transferToPersonTF = new JTextField(FIELD_WIDTH);

    transferAmoutButton = new JButton("Transfer");
    transferAmoutButton.addActionListener(new TransferListener());



    // add to panels
    transfer_panel.add(new JLabel("Transfer To"));
    transfer_panel.add(new JTextField(FIELD_WIDTH));
    transfer_panel.add(new JLabel("Transfer Amout"));
    transfer_panel.add(transferToPersonTF);
    transfer_panel.add(transferAmoutButton);
    main_panel.add(transfer_panel);
  }
  public void createHistory()
  {
    history_panel = new JPanel();
    historyLabel = new JLabel("History");
    historyTA = new JTextArea(10, 30);

    // add to panels
    history_panel.add(historyLabel);
    history_panel.add(historyTA);
    main_panel.add(history_panel);
  }

  private class DepositListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (depositAmoutTF.getText().length() >=1)
      {
        System.out.println("deposit: " + Double.parseDouble(depositAmoutTF.getText()));
        balance += Double.parseDouble(depositAmoutTF.getText());
        System.out.println("bal: " + balance);
        balanceLabel.setText(String.format("Balance: $%.2f", balance));

        // add to historyTA
        // historyTA.append(String.format("depositing: %.2f\n",
        //  depositAmoutTF.getText()));
      }
    }
  }
  private class WithdrawListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (withdrawAmoutTF.getText().length() >=1)
      {
        System.out.println("withdraw: " + Double.parseDouble(withdrawAmoutTF.getText()));
        balance -= Double.parseDouble(withdrawAmoutTF.getText());
        System.out.println("bal: " + balance);
        balanceLabel.setText(String.format("Balance: $%.2f", balance));

        // add to historyTA
        // historyTA.append(String.format("Withdrawing: %.2f\n",
        //  withdrawAmoutTF.getText()));
      }
    }
  }

  private class TransferListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (transferToPersonTF.getText().length() >=1)
      {
        balance -= Double.parseDouble(transferToPersonTF.getText());
        balanceLabel.setText(String.format("Balance: $%.2f", balance));

        // add to historyTA
        // historyTA.append(String.format("Transfering: %.2f\n",
        //  transferToPersonTF.getText()));
      }
    }
  }


}
