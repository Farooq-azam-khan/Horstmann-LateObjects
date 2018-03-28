import java.util.Scanner;

public class handlebalance
{
  public static void main(String[] args)
  {
    double balance = 100.0;
    System.out.print("withdraw amount: ");
    Scanner in = new Scanner(System.in);
    double amount = in.nextDouble();
    if (amount > balance)
    {
      throw new IllegalArgumentException("Amount exceeds balance");
    }
    balance -= amount;
    System.out.println("balance: " + balance);

  }
}
