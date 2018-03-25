/*
P7.9
Write a program that reads each line in a file, reverses its lines, and writes them to
another file.
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class P9
{
  public static void main(String[] args)
  {
    if (args.length == 2)
    {
      reverse(args[0], args[1]);
    }
    else
    {
      usage();
      System.exit(0);
    }
  }
  public static void reverse(String infile, String outfile)
  {
    try
    {
      ArrayList<String> lines = new ArrayList<String>();
      Scanner in = new Scanner(new File(infile));
      PrintWriter out = new PrintWriter(outfile);

      // add line to arraylist
      while(in.hasNextLine())
      {
        lines.add(in.nextLine());
      }

      // add lines backwards to file
      for (int i=lines.size()-1; i>=0; i--)
      {
        out.println(lines.get(i));
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
