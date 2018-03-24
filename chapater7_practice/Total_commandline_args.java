import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Total_commandline_args
{
  public static void main(String[] args)
  {
    String inputFileName = "input.txt";
    String outputFileName = "output.txt";

    if (args.length ==2)
    {
      inputFileName = args[0];
      outputFileName = args[1];
    }
    else if (args.length == 1 && args[0] == "-u")
    {
      usage();
      return ;
    }
    else
    {
      usage();
      return ; // terminaltes program cannot use 0 or null must be only "return;"
    }

    try
    {
      File inputFile = new File(inputFileName);
      Scanner in = new Scanner(inputFile);
      PrintWriter out = new PrintWriter(outputFileName);

      double total = 0;
      int counter = 0;
      while(in.hasNextDouble())
      {
        double value = in.nextDouble();
        counter++;
        out.printf("number %2d: %15.2f\n", counter, value);
        total += value;
      }
      out.println("------------------------------");
      out.printf("Total: %19.2f\n", total);

      in.close();
      out.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("input file not found");
    }
    finally
    {
      System.out.println("goodbye");
    }
  }

  public static void usage()
  {
    System.out.println("usage: java Total_commandline_args [inputFileName].txt [outputFileName].txt");
  }
}
