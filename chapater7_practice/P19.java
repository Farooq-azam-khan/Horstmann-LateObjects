/*
7.19 After the switch in the figure below closes, the voltage (in volts)
across the capacitor
is represented by the equation
v(t) = B(1 − e−t (RC) )
Suppose the parameters of the electric circuit are B = 12 volts, R = 500 Ω, and
C = 0.25 μF. Consequently
v(t) = 12(1 − e−0.008t )
where t has units of μs.
Read a file params.txt containing the values for B, R, C, and
the starting and ending values for t.
Write a file rc.txt of values for the time t and the
corresponding capacitor voltage v(t),
where t goes from the given starting value to
the given ending value in 100 steps.
In our example, if t goes from 0 to 1,000 μs, the
twelfth entry in the output file would be:
110 7.02261
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P19
{
  public static void main(String[] args)
  {
    try
    {
      // get input file: p19_data_file.txt
      // System.out.print("Data file: ");
      // Scanner in = new Scanner(System.in);
      // String inputFile = String.valueOf(in.next());

      // get output file
      // System.out.print("Output file: ");
      // in = new Scanner(System.in);
      // String outputFile = String.valueOf(in.next());

      String inputFile = "p19_data_file.txt";
      String outputFile = "p19_output_file.txt";

      // open inputfile and output file
      Scanner in = new Scanner(new File(inputFile));
      PrintWriter out = new PrintWriter(outputFile);

      System.out.println("inputfile: " + inputFile);
      System.out.println("outputfile: " + outputFile);

      in.nextLine(); // skip first line
      in.useDelimiter(","); // csv

      // manually get values
      double B = in.nextDouble();
      double R = in.nextDouble();
      double C = in.nextDouble();
      double t_start = in.nextDouble();
      double t_end = in.nextDouble();
      double t_step = in.nextDouble();

      System.out.println("contants: ");
      System.out.printf("B:%.2f R:%.2f C:%.2f t-start:%.2f t-end:%.2f\n",
      B, R, C, t_start, t_end);

      out.printf("B:%.2f R:%.2f C:%.2f t-start:%.2f t-end:%.2f\n",
      B, R, C, t_start, t_end);
      out.printf("time(mu s) | voltage(volts)\n");
      out.println("---------------------------");

      for (double time_i=t_start; time_i<=t_end; time_i+=t_step)
      {
        double voltage = capacitorVoltage(time_i, B, R, C);
        out.printf("%10.1f | %11.2f\n", time_i, voltage);
      }

      in.close();
      out.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(NoSuchElementException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static double capacitorVoltage(double time, double B, double R, double C)
  {
    return B*( 1-Math.exp( -(time)/(R*C) ));
  }
}
