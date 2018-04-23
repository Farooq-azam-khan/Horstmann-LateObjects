/**
P19.2
Letter frequencies. If you encrypt a file using the cipher of Exercise P19.1,
it will have all of its letters jumbled up, and will look as if there is no
hope of decrypting it without knowing the keyword.
Guessing the keyword seems hopeless, too. There are just too many possible keywords.
However, someone who is trained in decryption will be able to
 break this cipher in no time at all. The average letter frequencies
of English letters are well known. The most common letter is E,
which occurs about 13 percent of the time.
Here are the average frequencies of English letters:
A 8% H 4% O 7% V 1% B <1% I 7% P 3% W 2% C 3% J <1% Q <1% X <1%
D 4% K <1% R 8% Y 2% E 13% L 4% S 6% Z <1% F 3% M 3% T 9% G 2% N 8% U 3%.

Write a program that reads an input file and prints
the letter frequencies in that file. Such a tool will help a code breaker.
If the most frequent letters in an encrypted file
are H and K, then there is an excellent chance that
they are the encryptions of E and T.
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class P2
{
  public static Map<Character, Integer> frequencyMap = new TreeMap<Character, Integer>();
  public static void main(String[] args)
  {
    try
    {
      String inputFileName = "p2freq.txt";
      Scanner in = new Scanner(new File(inputFileName));

      while(in.hasNext())
      {
        String word = in.next();
        processCharacters(word);
      }
      System.out.println("Frequency in file: " + inputFileName + "\n" + frequencyMap);
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static void processCharacters(String word)
  {
    Set<Character> letter_set = frequencyMap.keySet();
    for(int i=0; i<word.length(); i++)
    {
      char ch = word.charAt(i);
      if (letter_set.contains(ch))
      {
        int occurence = frequencyMap.get(ch);
        frequencyMap.put(ch, ++occurence);
      }
      else
      {
        frequencyMap.put(ch, 1);
      }
    }
  }

}
