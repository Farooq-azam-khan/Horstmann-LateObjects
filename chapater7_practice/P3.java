/*
P7.3
Repeat Exercise P7.2, but allow the user to specify the file name on the commandline.
If the user doesn’t specify any file name, then prompt the user for the name.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class P3
{
  public static void main(String[] args)
  {
    if (args.length == 2)
    {
      String inputFileName = args[0];
      String outputFileName = args[1];
      runOperation(inputFileName, outputFileName);
    }
    else
    {
      usage();
    }
  }

  public static void runOperation(String inputFileName, String outputFileName)
  {
    try
    {
      Scanner in = new Scanner(new File(inputFileName));
      PrintWriter out = new PrintWriter(outputFileName);

      int lineNum = 0;
      while(in.hasNextLine())
      {
        lineNum++;
        String line = in.nextLine();
        line = "/* " + lineNum + " */ " + line;
        out.println(line); 
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
    System.out.println("[inputfile] [outputfile]");
  }
}
