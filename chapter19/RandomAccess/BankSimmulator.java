import java.io.IOException;
import java.util.Scanner;

public class BankSimmulator
{
  public static void main(String[] args) throws IOException
  {
    Scanner in = new Scanner(System.in);
    BankData data = new BankData();
    try
    {
      data.open("bank.dat");
      boolean done = false;
      while(!done)
      {
        System.out.print("Account Number: ");
        int account_number = in.nextInt();
        System.out.print("Amount to Deposit: ");
        double deposit_amount = in.nextDouble();

        // get the random access position
        int position = data.find(account_number);
        // create a bank account object
        BankAccount account;
        // check if position is in file
        if (position >= 0)
        {
          // have bank accout equal to value at that position
          account = data.read(position);
          account.deposit(deposit_amount);
          System.out.println("new balance: " + account.getBalance());
        }
        else
        {
          // create new bank account if not found in file
          account = new BankAccount(account_number, deposit_amount);
          position = data.size();
          System.out.println("added new bank account");
        }

        data.write(position, account);
        System.out.print("done(Y/N): ");
        if (in.next().equals("y"))
        {
          done = true;
        }




      }

    }
    finally
    {
      data.close();
    }
  }
}
