import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaesarCipher
{
  public static int key = 3;
  public static void main(String[] args)
  {
    String inputFileName = "decrypt.txt";
    boolean e_msg = false;

    try
    {
      File inputFile = new File(inputFileName);
      Scanner in = new Scanner(inputFile);

      while(in.hasNextLine())
      {
        System.out.println(in.nextLine());
      }
    }

    catch (FileNotFoundException e)
    {
      System.out.println("Could not find file");
      System.out.println("would you like to encrypt a message (y/n): ");
      Scanner e_a_msg = new Scanner(System.in);
      String response = e_a_msg.next();

      if (response.equals("y"))
      {
        e_msg = true;
        Encrypt();
      }
      else
      {
        return ;
      }
    }
    finally
    {
      System.out.println("goodbye");
    }

  }

  public static void Encrypt()
  {
    System.out.println("what is your message: ");
    Scanner msg = new Scanner(System.in);
    String encrypted_msg = caesar_cipher(msg.next(), key);
    System.out.println("here is your encrypted message: " + encrypted_msg);
  }

  public static String caesar_cipher(String msg, int key)
  {
    int msg_len = msg.length();
    String e_msg = "";
    int BASE;
    int NUM_LETTERS = 26;

    for (int i=0; i<msg_len; i++)
    {
      char e_ch;
      char ch = msg.charAt(i);
      int int_ch = (int)ch;
      if (ch >= 'A' && ch <= 'Z')
      {
        BASE = 'A';
        int int_base = (int)BASE;
        int e_num = ((int_ch-BASE+key)%NUM_LETTERS)+BASE;
        e_ch = (char)e_num;
        System.out.println("old ch: " + ch +" new ch: " +e_ch);
        e_msg += String.valueOf(e_ch);
      }
      else if (ch >= 'a' && ch <= 'z')
      {
        BASE = 'a';
        int int_base = (int)BASE;
        int e_num = ((int_ch-BASE+key)%NUM_LETTERS)+BASE;
        e_ch = (char)e_num;
        System.out.println("old ch: " + ch +" new ch: " +e_ch);
        e_msg += String.valueOf(e_ch);
      }
      else
      {
        e_msg += String.valueOf(ch);
      }
    }

    return e_msg;
  }
}
