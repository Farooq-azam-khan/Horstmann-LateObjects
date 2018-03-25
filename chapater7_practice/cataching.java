import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class cataching
{
  public static void main(String[] args)
  {
    try
    {
      String filename = "doesnotexist.txt";
      File file = new File(filename);
      Scanner in = new Scanner(file);
      String input = in.next();
      int num = Integer.parseInt(input);

    }

    // catch(IOException e)
    // {
    //   System.out.println("Stack Trace: ");
    //   e.printStackTrace();
    //
    // }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());

    }
    //
    catch(NoSuchElementException e)
    {
      System.out.println("excuting nosuchelementexception");
      System.out.println(e.getMessage()); 

    }
    catch(NumberFormatException e)
    {
      System.out.println("Executing formatting error: ");
      System.out.println(e.getMessage());
    }

  }
}
