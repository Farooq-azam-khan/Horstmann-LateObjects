import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.io.FileNotFoundException;

public class SpellCheck
{
  public static void main(String[] args)
  throws FileNotFoundException
  {
    Set<String> dict_words = readWords(new File("words.txt"));
    Set<String> novel_words = readWords(new File("aliceInWonderLand.txt"));


    for (String word : novel_words)
    {
      if (!dict_words.contains(word))
      {
        System.out.println("found: " + word);
      }
    }

  }

  public static Set<String> readWords(File fileName)
  throws FileNotFoundException
  {
    Set<String> words = new HashSet<String>();
    Scanner in = new Scanner(fileName);
    in.useDelimiter("[^a-zA-Z]+"); // do not use letters as delimiter

    // iterator over file
    while(in.hasNext())
    {
      words.add(in.next().toLowerCase());
    }

    return words;
  }
}
