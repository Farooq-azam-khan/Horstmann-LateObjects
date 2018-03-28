import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;

public class throwclause
{
  public static void main(String[] args)
  throws FileNotFoundException, NoSuchElementException, NumberFormatException
  {
    Scanner in = new Scanner(new File("doesnotexist.txt"));
    String input = in.next();
    System.out.println(input);
    int num = Integer.parseInt(input);
    System.out.println(num); 


  }

}
