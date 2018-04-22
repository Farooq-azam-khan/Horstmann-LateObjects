import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// TODO fix runtime error
public class SerialDemo
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Bank khanBank;
    File file = new File("bank.dat");
    if (file.exists())
    {
      System.out.println("file exits");
      // create an object input stream
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
      khanBank = (Bank) (in.readObject());
      in.close();
    }
    else
    {
      System.out.println("file does not exist");
      khanBank = new Bank();
      khanBank.addAccount(new BankAccount(100, 20));
      khanBank.addAccount(new BankAccount(102, 2000));
    }
    // deposit money
    // BankAccount a = khanBank.find(100);
    // a.deposit(50);
    // System.out.println("BA:[" + a.getAccountNumber() + ", " + a.getBalance() + "]");
    // a = khanBank.find(102);
    // System.out.println("BA:[" + a.getAccountNumber() + ", " + a.getBalance() + "]");

    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
    out.writeObject(khanBank);
    out.close();


  }
}
