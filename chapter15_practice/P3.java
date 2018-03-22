/*
P15.3
Use a stack to reverse the words of a sentence.
Keep reading words until you have a word that ends in a period, adding them onto a stack.
When you have a word with a period, pop the words off and print them.
Stop when there are no more words in the input.
For example, you should turn the input
Mary had a little lamb. Its fleece was white as snow.
into
Lamb little a had mary. Snow as white was fleece its.
Pay attention to capitalization and the placement of the period.
*/
import java.util.Stack;
import java.util.Scanner;

public class P3
{
  public static String sentence = "Mary had a little lamb. Its fleece was white as snow.";
  public static void main(String[] args)
  {
    Stack<String> words = new Stack<String>();
    Stack<String> backwords = new Stack<String>();

    int sentence_length = sentence.length();

    // get each word
    Scanner in = new Scanner(sentence);
    while (in.hasNext())
    {
      String word = in.next();
      words.push(word); // push word to stack
      if (word.contains(".")) // check for end of sentence
      {
        int size = words.size(); // check size of stack
        for (int i=0; i<size; i++)
        {
          String removed = words.pop(); // pop words based on stacks size
          // print words backwords 
          if (i==0)
          {
            String first_char = removed.substring(0,1);
            first_char = first_char.toUpperCase();
            System.out.print(first_char+removed.substring(1, removed.length()-1) + " ");
          }
          else if (i == size-1)
          {
            String first_char = removed.substring(0,1);
            first_char = first_char.toLowerCase();
            System.out.print(first_char+removed.substring(1) + ". ");
          }
          else
          {
            System.out.print(removed + " ");
          }
        }
      }
    }
  }
}
