/*
P7.4
Write a program that reads a file containing two columns of floating-point numbers.
Prompt the user for the file name. Print the average of each column.
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class P4
{
  public static void main(String[] args)
  {
    try
    {
      System.out.print("file name: ");
      Scanner in = new Scanner(System.in);
      in = new Scanner(new File(String.valueOf(in.next())));

      while(in.hasNextDouble())
      {
        Double num1 = in.nextDouble();
        Double num2 = in.nextDouble();
        Double avg = (num1+num2) / 2;
        System.out.printf("avg: %.2f\n", avg); 
      }

      in.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }


  }
}
