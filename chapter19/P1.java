/**
P19.1 Random monoalphabet cipher.
The Caesar cipher, which shifts all letters by a fixed
amount, is far too easy to crack. Here is a better idea. For the key,
don’t use numbers but words. Suppose the key word is FEATHER.
Then first remove duplicate letters, yielding FEATHR,
and append the other letters of the alphabet in reverse order.
Write a program that encrypts or decrypts a file using this cipher. The key word is
specified with the -k command line option. The -d command line option specifies
decryption. For example, java Encryptor -d -k FEATHER encrypt.txt output.txt
decrypts a file using the keyword FEATHER. It is an error not to supply a keyword.
*/

// TODO: implement alg
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P1
{
  public static void main(String[] args)
  {
    String input_file_name = "";
    String output_file_name = "";
    boolean isDecryption = false;
    String key = "";

    if (args.length <= 3 || args.length > 4)
    {
      usage();
      System.exit(0);
    }
    else
    {

      if (args[0].equals("-d"))
      {
        isDecryption = true;
        key = args[1].substring(1+1+1);
        input_file_name = args[2];
        output_file_name = args[3];
      }
      else if (args[0].contains("-k"))
      {
        isDecryption = false;
        key = args[0].substring(1+1+1);
        input_file_name = args[3];
        output_file_name = args[4];
      }
    }

    try
    {
      File input_file = new File(input_file_name);

      PrintWriter output_file = new PrintWriter(output_file_name);
      Scanner in = new Scanner(input_file);

      String msg = "";
      String key = removeDupliateLetters(key);
      ImprovedCaesarCipher icc = new ImprovedCaesarCipher(key);

      while(in.hasNextLine())
      {
        msg += in.nextLine();
        String encrypted_msg = icc.encrypt(msg);

        out.println(encrypted_msg);
      }

      in.close();
      out.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static void removeDublicateLetters(String key)
  {
    int result = "";
    for (int i=0; i<key.length(); i++)
    {
      String c = String.valueOf(key.charAt(i));
      if (!result.contains(c))
      {
        result += c;
      }
    }
    return c;
  }
  public static void usage()
  {
    System.out.println("java P1 -d=decrypt -k=key [key] [input].txt [output].txt");
  }
}

class ImprovedCaesarCipher
{
  String key;
  public int alphabet_length = 26;
  public char base;
  public ImprovedCaesarCipher(String key)
  {
    this.key = key;
  }

  private char getBase(char c)
  {
    if (msg.charAt(i) > 'a' && msg.charAt(i) < 'z')
    {
      base = 'a';
    }
    else if (msg.charAt(i) > 'A' && msg.charAt(i) < 'Z')
    {
      base = 'A';
    }
    return base;
  }
  public String encrypt(String msg)
  {
    for (int i=0; i<msg.length; i++)
    {
      base = getBase(msg.charAt(i));
    }

  }
  public String decrypt(String msg, String key)
  {

  }
  public String crack(String msg)
  {

  }
}
