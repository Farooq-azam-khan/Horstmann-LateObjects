/**
P19.6 Modify the BankSimulator program so that it is possible to delete an account.
To delete a record from the data file, fill the record with zeroes.

P19.7 The data file in Exercise P19.6 may end up with many deleted records that take up
space. Write a program that compacts such a file, moving all active records to the
beginning and shortening the file length. Hint: Use the setLength method of the
RandomAccessFile class to truncate the file length. Look up the method’s behavior in
the API documentation.
*/
// TODO: NOT YET FINISHED
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.IOException;

public class P6P7
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println("-------- Running Bank Simmulation --------");
      boolean done = false;
      BankData data = new BankData();
      data.open("bankdataP6.problem");
      Scanner in = new Scanner(System.in);

      while(!done)
      {
        System.out.print("Account Number: ");
        int acountNum = in.nextInt();
        System.out.println("Deposit: ");
        double bal = in.nextDouble();

        boolean delete = false;
        System.out.println("delete(y/n): ");
        String del_val = in.next();
        if (del_val.equals("y")){delete = true;}
        else if (del_val.equals("n")){delete = false;}

        if (delete)
        {
          // find the account number and put zeros in it
          int position = data.find(accountNum);
          if (position > 0)
          {
            data.write(new BankAccount(0, 0));
          }

        }

        System.out.print("done(y/n): ");
        if (in.next().equals("y")){done=true;}

      }

      data.close();
    }
  }
}


class BankAccount
{
  private int accountNumber;
  private double balance;
  BankAccount(int accountNumber, double balance)
  {
    this.accountNumber =accountNumber;
    this.balance = balance;
  }
  public double getBalance(){return this.balance;}
  public void deposit(double amount){if (amount >0){balance+=amount;}}
  public int getAccountNumber(){return this.accountNumber;}
  public String toString()
  {
    return String.format("%s[an: %d bal: $%.2f]", getClass().getName(), accountNumber, balance);
  }

}

class BankData
{
  public static final int ACCOUNT_SIZE = 4;
  public static final int BALANCE_SIZE = 8;
  public static final int RECORD_SIZE = ACCOUNT_SIZE+BALANCE_SIZE;

  RandomAccessFile file;
  BankData()
  {
    file = null;
  }

  public void open(String filename) throws IOException
  {
    if (file!=null){file.close();}
    else {file = new RandomAccessFile(filename, "rw");}
  }

  public void close() throws IOException
  {
    if (file!=null){file.close();}
    file = null;
  }
  public int size() throws IOException
  {return (int)(file.length()/RECORD_SIZE);}


  public BankAccount read(int pos) throws IOException
  {
    // get the file pointer position of the data
    file.seek(pos * RECORD_SIZE);
    int accountNumber = file.readInt();
    double balance = file.readDouble();
    return new BankAccount(accountNumber, balance);
  }

  public int find(int accountNumber) throws IOException
  {
    for(int i=0; i<this.size(); i++)
    {
      file.seek(i*RECORD_SIZE);
      int an_acc_num = file.readInt();
      double a_bal = file.readDouble();
      if (an_acc_num == accountNumber)
      {
        return i; // new BankAccount(an_acc_num, a_bal);
      }

    }
    return -1; // null;
  }
  public void write(int pos, BankAccount ba) throws IOException
  {
    file.seek(pos * RECORD_SIZE);
    file.writeInt(ba.getAccountNumber());
    file.writeDouble(ba.getBalance());

  }
}
