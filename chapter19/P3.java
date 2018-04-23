/**
P19.3 Vigenère cipher. The trouble with a monoalphabetic cipher
is that it can be easily broken by frequency analysis.
The so-called Vigenère cipher overcomes this problem by encoding a
letter into one of several cipher letters, depending on its position in the
input document. Choose a keyword, for example TIGER. Then encode the first
letter of the input text.
That is, the encoded alphabet is just the regular alphabet shifted to start at T,
the first letter of the keyword TIGER.
The second letter is encrypted according to this map.
The third, fourth, and fifth letters in the input text are encrypted using the alphabet
sequences beginning with characters G, E, and R.
Because the key is only five letters long,
the sixth letter of the input text is encrypted in the same way as the first.
Write a program that encrypts or decrypts an input text using this cipher.
Use command line arguments as in Exercise P19.1.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.PrintWriter;

public class P3
{
  public static void main(String[] args)
  {
    if (args.length <4 || args.length > 5)
    {
      usage();
      System.exit(0);
    }

    String inputFileName = "";
    String outputFileName = "";
    String key = "";
    boolean encrypting = true;

    if (args[0].equals("-d"))
    {
      if (args[1].equals("-k"))
      {
        key = args[2];
        encrypting = false;
        inputFileName = args[3];
        outputFileName = args[4];
      }
    }
    else if (args[0].equals("-k"))
    {
      key = args[1];
      inputFileName = args[2];
      outputFileName = args[3];
    }

    // System.out.println("key: " + key + " encrypting: " + encrypting + " inputFileName: " + inputFileName + " outputFileName: " + outputFileName);

    try
    {
      Scanner in = new Scanner(new File(inputFileName));
      PrintWriter out = new PrintWriter(outputFileName);

      VigenereCipher cipher = new VigenereCipher("tiger");

      if (encrypting)
      {
        while(in.hasNextLine())
        {
          // encrypt line by line
          String encrypted_line = cipher.encrypt(in.nextLine());
          out.println(encrypted_line);
        }
      }
      else
      {
        while(in.hasNextLine())
        {
          // decrypt line by line
          String decrypted_line = cipher.decrypt(in.nextLine());
          out.println(decrypted_line);
        }
      }

      in.close();
      out.close();
    }

    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
  }
  public static void usage()
  {
    System.out.println("usage: java P3 [optional=-d] -k [key] [inputfile] [outputfile]");
  }
}



class VigenereCipher
{
  private String key;
  private static final int LETTERS = 26;
  public VigenereCipher(String key)
  {
    this.key = key;
  }

  public String encrypt(String msg)
  {
    String encrypted_msg = "";

    int key_counter = 0; // amount of times characters have to be encrypted
    for (int i=0; i< msg.length(); i++)
    {
      char ch = msg.charAt(i);
      char base;
      char key_ch = key.charAt(key_counter%key.length()); // get the character for encryption

      if (ch >= 'a' && ch <= 'z')
      {
        base = 'a';
        encrypted_msg += getEncryptedLetter(base, key_ch, ch);
        key_counter++; // (does not account for non-alphabetical chars)
      }
      else if (ch >= 'A' && ch <= 'Z')
      {
        base = 'A';
        // capitalize key_ch
        key_ch = String.valueOf(key_ch).toUpperCase().charAt(0);
        encrypted_msg += getEncryptedLetter(base, key_ch, ch);
        key_counter++;
      }
      else
      {
        encrypted_msg += String.valueOf(ch);
      }

    }

    return encrypted_msg;
  }

  public String decrypt(String msg)
  {
    String decrypted_msg = "";

    int key_counter = 0; // amount of times characters have to be encrypted
    for (int i=0; i< msg.length(); i++)
    {
      char ch = msg.charAt(i);
      char base;
      char key_ch = key.charAt(key_counter%key.length()); // get the character for encryption

      // System.out.print("ch: " + ch + " key_ch: " + key_ch + " ");
      if (ch >= 'a' && ch <= 'z')
      {
        base = 'a';
        decrypted_msg += getDecryptedLetter(base, key_ch, ch);
        key_counter++; // (does not account for non-alphabetical chars)
      }
      else if (ch >= 'A' && ch <= 'Z')
      {
        base = 'A';
        // capitalize key_ch
        key_ch = String.valueOf(key_ch).toUpperCase().charAt(0);
        decrypted_msg += getDecryptedLetter(base, key_ch, ch);
        key_counter++;
      }
      else
      {
        decrypted_msg += String.valueOf(ch);

        // System.out.println("");
      }

    }

    return decrypted_msg;
  }

  private String getEncryptedLetter(char base, char key_ch, char ch)
  {
    int char_index = ch - base;
    int key_index = key_ch - base;
    int encrypted_index = (char_index + key_index)%LETTERS;
    char encrypted_char = (char)((encrypted_index)+base);
    return String.valueOf(encrypted_char);

  }
  private String getDecryptedLetter(char base, char key_ch, char ch)
  {
    int char_index = ch - base;
    int key_index = key_ch - base;

    int decrypted_index = (Math.abs(char_index - key_index + LETTERS))%LETTERS;
    char decrypted_char = (char)((decrypted_index)+base);
    return String.valueOf(decrypted_char);
  }
}
