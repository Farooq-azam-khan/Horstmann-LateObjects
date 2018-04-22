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
      System.out.print("Input File: ");
      String inputFileName = in.next();
      System.out.print("Output File: ");
      String outputFileName = in.next();
      System.out.print("(e) encrypt or (d) decrypt or (c) crack: ");
      String action = in.next();
      System.out.print("Key: ");
      int key = in.nextInt();

      InputStream inStream = new FileInputStream(inputFileName);
      OutputStream outStream = new FileOutputStream(outputFileName, true);

      CaesarCipher cipher = new CaesarCipher(key);
      if (action.equals("e"))
      {
        cipher.encryptStream(inStream, outStream);
      }
      else if (action.equals("d"))
      {
        cipher.decryptStream(inStream, outStream);
      }
      else if (action.equals("c"))
      {
        FileOutputStream crackStream = new FileOutputStream(outputFileName, true);
        for (int i=1; i<256; i++)
        {
          cipher.setKey(i);
          cipher.decryptStream(inStream, crackStream);
        }
        crackStream.close(); 
      }
      inStream.close();
      outStream.close();
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }

  }
}
