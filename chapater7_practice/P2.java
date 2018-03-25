/*
7.2
Write a program that reads a file containing text.
Read each line and send it to the
output file, preceded by line numbers.
If the input file is:

Mary had a little lamb
Whose fleece was white as snow.
And everywhere that Mary went,
The lamb was sure to go!

Output:
/* 1 */ /* Mary had a little lamb */
/* 2 */ /* Whose fleece was white as snow. */
/* 3 */ /* And everywhere that Mary went, */
/* 4 */ /* The lamb was sure to go! */
/*
The line numbers are enclosed in /* */ /* delimiters so that the program can be used for
numbering Java source files.
Prompt the user for the input and output file names.
*/

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class P2
{
  public static void main(String[] args)
  throws FileNotFoundException
  {
    String inputFileName = "p2_input.txt";
    String outputFileName = "p2_output.txt";

    // System.out.println("input file: ");
    // Scanner inFileName = new Scanner(System.in);
    // inFileName.nextLine();
    // inputFileName = String.valueOf(inFileName);
    // System.out.println("output file: ");
    // Scanner outFileName = new Scanner(System.in);
    // outFileName.nextLine();
    // outputFileName = String.valueOf(outFileName);

    Scanner in = new Scanner(new File(inputFileName));
    PrintWriter out = new PrintWriter(outputFileName);

    int lineNum = 0;
    while(in.hasNextLine())
    {
      lineNum++;
      String line = String.valueOf(in.nextLine());
      line = "/* " + lineNum + " */ " + line;
      out.println(line);
    }

    in.close();
    out.close();
  }
}
