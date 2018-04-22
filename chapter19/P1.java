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
    String key = "";
    boolean encrypt_msg = true;
    String inputFileName = "";
    String outputFileName = "" ;
    if (args.length <=3 || args.length >5)
    {
      usage();
      System.exit(0);
    }
    else
    {
      if (args[0].equals("-d"))
      {
        encrypt_msg = false;
        if (args[1].equals("-k"))
        {
          key = args[2];
        }
        // System.out.println("args[3]: " + args[3]);
        inputFileName = args[3];
        outputFileName = args[4];
      }
      else if (args[0].equals("-k"))
      {
        key = args[1];
        inputFileName = args[2];
        outputFileName = args[3];
      }

    }
    System.out.println("key: " + key +
    " inputfile: " + inputFileName + " output: " + outputFileName+
    " encrypting: " + encrypt_msg);

    try
    {
      File inputFile = new File(inputFileName);
      Scanner in = new Scanner(inputFile);
      PrintWriter outputFile = new PrintWriter(outputFileName);

      RandomMonoalphabetCipher cipher = new RandomMonoalphabetCipher(key);

      if (encrypt_msg)
      {
        outputFile.println("encrypted message: ");
        while(in.hasNextLine())
        {
          String line = in.nextLine();

          Scanner line_processor = new Scanner(line);
          line_processor.useDelimiter("[^a-z]+");
          while(line_processor.hasNext())
          {
            String word = line_processor.next();
            outputFile.print(cipher.encrypt(word) + " ");
          }

          outputFile.println("");
        }

      }
      else
      {
        outputFile.println("decrypted message: ");
        while(in.hasNextLine())
        {
          String line = in.nextLine();
          // System.out.println("line: " + line);
          Scanner line_processor = new Scanner(line);
          line_processor.useDelimiter("[^a-z]+");
          while(line_processor.hasNext())
          {
            String word = line_processor.next();
            outputFile.print(cipher.decrypt(word) + " ");
          }

          outputFile.println("");
        }
      }

      outputFile.close();
      in.close(); 

    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }


    // RandomMonoalphabetCipher cipher = new RandomMonoalphabetCipher("feather");
    // System.out.println(cipher.encrypt("hello"));
    // System.out.println(cipher.decrypt("yhuup"));



  }
  public static void usage()
  {
    System.out.println("java P1 [-d] [-k] [inputfile] [outputfile]");

  }

  public static void encryptLine(String line)
  {
    System.out.println("line: " + line);
    Scanner line_processor = new Scanner(line);
    line_processor.useDelimiter("[^a-z]+");
    while(line_processor.hasNext())
    {
      String word = line_processor.next();
      System.out.println("word: " + word);
    }
  }
}
