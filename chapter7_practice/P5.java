/*
P7.5
Write a program that asks the user for a file name and prints the number of characters,
words, and lines in that file.
*/

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class P5
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println("fileName: ");
      Scanner in = new Scanner(System.in);
      in = new Scanner(new File(String.valueOf(in.next())));

      int lines = 0;
      int words = 0;
      int chars = 0;
      System.out.println("Calculating number of Lines, words and characters");
      while(in.hasNextLine())
      {
        lines++;
        String line = in.nextLine();
        Scanner line_word = new Scanner(line);
        while(line_word.hasNext())
        {
          words++;
          String word = line_word.next();
          chars+=word.length();
        }

      }
      in.close();
      System.out.println("Lines: " + lines + " words: " + words + " letters: " + chars);
    }
    catch (FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }


  }
}
