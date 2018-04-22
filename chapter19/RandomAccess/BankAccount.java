public class BankAccount
{
  private int accountNumber;
  private double balance;
  BankAccount(int accountNumber, double balance)
  {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }
  public double getBalance()
  {
    return this.balance;
  }
  public void deposit(double amount)
  {
    if (amount > 0)
    {
      this.balance += amount;
    }
  }
  public int getAccountNumber()
  {
    return this.accountNumber;
  }
}
