import java.io.File;
import java.util.Scanner;

import java.io.InputStream;
import java.io.OutputStream;

import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public class CaesarEncryptor
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    try
    {
      // System.out.print("Input File: ");
      // String input_file = in.next();
      String input_file = "my_encryption_msg.fak";
      // System.out.print("Output File: ");
      String output_file = "decryption_msg.fak";
      // String output_file = in.next();
      // System.out.print("Encryption Key: ");
      // int encryption_key = in.nextInt();

      boolean append = true;

      for (int key=1; key<256; key++)
      {
        CaesarCipher caesar_cipher = new CaesarCipher(key);

        InputStream input_stream = new FileInputStream(input_file);
        FileOutputStream output_stream = new FileOutputStream(output_file, append);

        caesar_cipher.decryptStream(input_stream, output_stream);

        output_stream.close();
        input_stream.close();
      }

      // for (int key=0; key<256; key++)
      // {
      //   caesar_cipher = new CaesarCipher(key);
      //
      //   InputStream input_stream = new FileInputStream(input_file);
      //   FileOutputStream output_stream = new FileOutputStream(output_file, append);
      //
      //   caesar_cipher.decryptStream(input_stream, output_stream);
      //
      //   output_stream.close();
      //   input_stream.close();
      // }
      // close

    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }

  }
}
