import java.io.IOException;
import java.io.RandomAccessFile;

public class BankData
{
  private RandomAccessFile file;
  public static final int INT_SIZE = 4; // for account
  public static final int DOUBLE_SIZE = 8; // for balance
  public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE;

  public BankData()
  {
    file = null;
  }

  /** opens data in the file
  @param filename
   */
  public void open(String filename) throws IOException
  {
    if (file != null)
    {
      file.close();
    }
    else
    {
      file = new RandomAccessFile(filename, "rw");
    }
  }

  /**
  return the size
  */
  public int size() throws IOException
  {
    return (int)(file.length() / RECORD_SIZE);
  }

  /**
  close the data file
  */
  public void close() throws IOException
  {
    if (file != null)
    {
      file.close();
    }
    else
    {
      file = null;
    }
  }

  public BankAccount read(int pos) throws IOException
  {
    file.seek(pos * RECORD_SIZE);
    int accountNumber = file.readInt();
    double balance = file.readDouble();
    return new BankAccount(accountNumber, balance);
  }

  public int find(int accountNumber) throws IOException
  {
    for (int i=0; i<this.size(); i++)
    {
      file.seek(i*RECORD_SIZE);
      int a = file.readInt();
      if (a == accountNumber)
      {
        return i;
      }
    }
    return -1;
  }

  public void write(int n, BankAccount ba) throws IOException
  {
    file.seek(n*RECORD_SIZE);
    file.writeInt(ba.getAccountNumber());
    file.writeDouble(ba.getBalance());

  }


}
