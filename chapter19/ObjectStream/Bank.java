import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable
{
  private ArrayList<BankAccount> accounts;
  public Bank()
  {
    accounts = new ArrayList<BankAccount>();
  }

  public void addAccount(BankAccount ba)
  {
    accounts.add(ba);
  }

  public BankAccount find(int accountNumber)
  {
    for (BankAccount account : accounts)
    {
      if (account.getAccountNumber() == accountNumber)
      {
        return account;
      }
    }
    return null;
  }
}
