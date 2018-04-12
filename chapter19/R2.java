/**
R19.2
Write a few lines of text to a new FileWriter("output1.txt", "UTF-8")
and the same text to a new FileWriter("output2.txt", "UTF-16").
How do the output files differ?
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class R2
{
  public static void main(String[] args)
  {
    // Scanner in = new Scanner(new File("r2_input.txt"), "UTF-8");
    try
    {
      PrintWriter out = new PrintWriter(new File("r2_input.txt"), "UTF-8");
      // out.println("this is section 19.1");
      out.close();

      // out = new PrintWriter("r2_input.txt", "UTF-16");
      // out.println("this is section 19.1");
      // out.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(UnsupportedEncodingException e)
    {
      System.out.println(e.getMessage());
    }

  }
}
