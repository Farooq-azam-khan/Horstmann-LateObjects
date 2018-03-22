/*
P14
Write a program that reads a Java source file and produces an index of all identifiers
in the file. For each identifier, print all lines in which it occurs. For simplicity, we
will consider each string consisting only of letters, numbers, and underscores
an identifer. Declare a Scanner in for reading from the source file and call
in.useDelimiter("[^A-Za-z0-9_]+"). Then each call to next returns an identifier.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;


public class P14
{
  public static final String fileName = "test" + ".java";
  //  delimiter, line numbers
  public static Map<String, ArrayList<Integer>> identifier = new TreeMap<String, ArrayList<Integer>>();

  public static void main(String[] args)
  throws FileNotFoundException
  {

    // Scanner in = new Scanner(new File(fileName));

    // get all identifiers
    get_all_identifiers();
    //
    get_line_numbers();

    //
    Set<String> key_set = identifier.keySet();
    for (String key : key_set)
    {
      System.out.println(key + " : " + identifier.get(key));
    }

  }

  public static void get_all_identifiers()
  throws FileNotFoundException
  {
    ArrayList<Integer> test = new ArrayList<Integer>();
    Scanner in = new Scanner(new File(fileName));
    in.useDelimiter("[^A-Za-z0-9_]+");
    while(in.hasNext())
    {
      String delim = in.next().trim();
      identifier.put(delim, test);
    }
  }

  public static void get_line_numbers()
  throws FileNotFoundException
  {
    // for each key go through each line and add that line number
    Set<String> key_set = identifier.keySet();
    for (String key : key_set)
    {
      ArrayList<Integer> line_number = new ArrayList<Integer>();

      // go through the file
      Scanner in = new Scanner(new File(fileName));
      in.useDelimiter("[^A-Za-z0-9_]+");
      int lineNumberCounter = 0;
      while(in.hasNextLine())
      {
        lineNumberCounter++;
        String line = in.nextLine();
        if (line.contains(key))
        {
          line_number.add(lineNumberCounter);
          // System.out.println("found "+ key + " at line: " + lineNumberCounter);
        }
      }
      identifier.put(key, line_number);


    }
  }


}
