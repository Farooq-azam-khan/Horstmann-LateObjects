/*
9.20
Change the CheckingAccount class in How To 9.1
so that a $1 fee is levied for deposits
or withdrawals in excess of three free monthly transactions.
Place the code for computing the fee into a separate method
that you call from the deposit and withdraw methods.
*/
public class P20
{
  public static void main(String[] args)
  {
    BankAccount ba1 = new CheckingAccount(100);
    System.out.println("initial: ($)" + ba1.getBalance());
    ba1.withdraw(10);
    System.out.println("withdraw ($10): ($)" + ba1.getBalance());
    ba1.withdraw(10);
    System.out.println("withdraw ($10+$1 fee): ($)" + ba1.getBalance());
    System.out.println("----------------------------");

    CheckingAccount ba2 = new CheckingAccount(100);
    System.out.println("initial: ($)" + ba2.getBalance());
    ba2.withdraw(10);
    System.out.println("withdraw ($10): ($)" + ba2.getBalance());
    ba2.increaseMonthCounter();
    ba2.increaseMonthCounter();
    ba2.increaseMonthCounter();
    ba2.withdraw(10);
    System.out.println("withdraw ($10+$1 fee): ($)" + ba2.getBalance());
  }
}

class CheckingAccount extends BankAccount
{
  private int monthCounter;
  public CheckingAccount(double balance)
  {
    super.deposit(balance);
    this.monthCounter = 0;
  }
  public void withdraw(double amount)
  {
    if (this.monthCounter<3)
    {
      super.withdraw(amount);
    }
    else
    {
      super.withdraw(amount);
      double bal = super.getBalance();
      super.setBalance(bal-1);
    }
  }
  public void deposit(double amount)
  {
    if (this.monthCounter<3)
    {
      super.deposit(amount);
    }
    else
    {
      super.deposit(amount-1);
    }
  }
  public void increaseMonthCounter()
  {
    this.monthCounter++;
    System.out.println("increased mc: " + this.monthCounter);
  }
}

class BankAccount
{
  private double balance;
  BankAccount(double balance)
  {
    this.balance = balance;
  }
  BankAccount() {}
  public void withdraw(double amount)
  {
    if (amount > this.balance)
    {
      throw new IllegalArgumentException("you cannot withdraw that much");
    }
    this.balance -= amount;
  }

  public void deposit(double amount)
  {
    this.balance += amount;
  }
  public void setBalance(double balance)
  {
    this.balance = balance;
  }

  public double getBalance()
  {
    return this.balance;
  }
}
