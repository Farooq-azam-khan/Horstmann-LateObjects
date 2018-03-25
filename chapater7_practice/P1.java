/*
7.1
Write a program that carries out the following tasks:
Open a file with the name hello.txt.
Store the message "Hello, World!" in the file.
Close the file.
Open the same file again.
Read the message into a string variable and print it.
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class P1
{
  public static void main(String[] args)
  throws FileNotFoundException
  {
    String fileName = "hello.txt";
    PrintWriter out = new PrintWriter(fileName);
    out.println("Hello, World!");
    out.close();

    File read = new File(fileName);
    Scanner in = new Scanner(read);

    String words = "";
    while(in.hasNext())
    {
      words+=in.next();
    }
    in.close();
    System.out.println(words);


  }

}
