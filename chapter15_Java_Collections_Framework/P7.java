import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

/*
P15.7
Write a program that reads text from a file and breaks it up into individual words.
Insert the words into a tree set. At the end of the input file, print all words, followed
by the size of the resulting set. This program determines how many unique words a
text file has.
*/
public class P7
{
  public static void main(String[] args) throws FileNotFoundException
  {
    Set<String> words = readFile(new File("input.txt"));

    System.out.println("words: " + words);
    System.out.println("size: " + words.size());

  }

  public static Set<String> readFile(File file) throws FileNotFoundException
  {
    Set<String> words = new TreeSet<String>();
    Scanner in = new Scanner(file);
    in.useDelimiter("[^a-zA-Z]+"); // dont use anything that is a letter

    while(in.hasNext())
    {
      String word = in.next();
      words.add(word);
    }

    in.close(); 

    return words;

  }

}
