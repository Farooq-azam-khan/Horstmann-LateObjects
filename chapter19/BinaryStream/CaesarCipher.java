import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class CaesarCipher
{
  private int key;
  public CaesarCipher(int key)
  {
    this.key = key;
  }

  public void encryptStream(InputStream in, OutputStream out)
  throws IOException
  {
    boolean done = false;
    while(!done)
    {
      int next = in.read();
      if (next == -1)
      {
        System.out.println("next: " + next);
        done = true;
      }
      else
      {
        int encrypted = encrypt(next);
        System.out.println("writing: " + encrypted + " to file");
        out.write(encrypted);
      }
    }
  }

  public void setKey(int key)
  {
    this.key = key;
  }

  public void decryptStream(InputStream in, OutputStream out)
  throws IOException
  {
    boolean done = false;
    while(!done)
    {
      int next = in.read();
      if (next == -1)
      {
        done = true;
      }
      else
      {
        out.write(decrypt(next));
      }
    }
  }

  public void crackStream(InputStream in, FileOutputStream out)
  throws IOException
  {
    boolean done = false;
    while(!done)
    {
      int next = in.read();
      if (next == -1)
      {
        done = true;
      }
      else
      {
        out.write(decrypt(next));
      }
    }
  }

  public void setEncryptionKey(int key)
  { this.key = key; }

  // encrypt the (8bit/1byte) integer passed in
  private int encrypt(int msg)
  { return (msg+this.key)% 256; }

  public int decrypt(int msg)
  { return (msg-this.key)% 256; }
}
