import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Total
{
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner console = new Scanner(System.in);
    System.out.print("Input File: ");
    String inputFileName = console.next();
    System.out.print("Output File: ");
    String outputFileName = console.next();

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
}
