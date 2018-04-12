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
        done = true;
      }
      else
      {
        out.write(encrypt(next));
      }
    }
  }

  public void decryptStream(InputStream in, FileOutputStream out)
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
    out.write("\n".getBytes()); 
  }
  public void setEncryptionKey(int key)
  {
    this.key = key;
  }
  private int encrypt(int msg)
  {
    return (msg+this.key)% 256;
  }
  public int decrypt(int msg)
  {
    return (msg-this.key)% 256;
  }

}
