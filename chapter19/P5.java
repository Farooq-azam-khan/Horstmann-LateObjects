/**
P19.5
Write a program that opens a binary file and prints all ASCII characters from that
file, that is, all bytes with values between 32 and 126. Print a new line after every 64
characters. What happens when you use your program with word processor documents?
With Java class files?
*/
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class P5
{
  public static void main(String[] args)
  throws IOException
  {

    InputStream inputfile = new FileInputStream("input.p5");

    int newLineCounter = 0;
    while(true)
    {
      int next = inputfile.read();

      if (next == -1)
      {
        break;
      }
      else if (next > 32 && next < 126)
      {
        newLineCounter++;
        System.out.print((char)(next));
        if (newLineCounter%64 == 0)
        {
          System.out.println("");
        }
      }
    }
    inputfile.close();

  }
}
