/*
7.8
Write a program that replaces each line of a file with its reverse
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class P8
{
  public static void main(String[] args)
  {
    if (args.length == 1)
    {
      String inputFileName = args[0];
      reverse(inputFileName);
    }
    else
    {
      usage();
      System.exit(0);
    }
  }

  public static void reverse(String infile)
  {
    try
    {
      // record line into arraylist
      ArrayList<String> lines = new ArrayList<String>();
      Scanner in = new Scanner(new File(infile));
      while(in.hasNextLine())
      {
        lines.add(in.nextLine());
      }
      in.close();

      // System.out.println(lines);
      // write to same file with reverse
      PrintWriter out = new PrintWriter(infile);
      out.println("I am reading a new line into this file and the arraylist");
      for (String line : lines)
      {
        String rev_line = reverseLine(line);
        out.println(rev_line);
      }
      out.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());

    }
  }

  public static String reverseLine(String line)
  {
    String rev_line = "";
    int line_len = line.length();
    for (int i=line_len-1; i>=0; i--)
    {
      rev_line+=String.valueOf(line.charAt(i));
    }

    return rev_line;
  }

  public static void usage()
  {
    System.out.println("[inputfile]");
  }
}
