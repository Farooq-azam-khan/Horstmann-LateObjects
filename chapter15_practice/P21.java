/*
15.21
Write a program that checks whether a sequence of HTML tags is properly nested.
For each opening tag, such as <p>, there must be a closing tag </p>. A tag such as <p>
may have other tags inside, for example
<p> <ul> <li> </li> </ul> <a> </a> </p>
The inner tags must be closed before the outer ones. Your program should process a
file containing tags. For simplicity, assume that the tags are separated by spaces, and
that there is no text inside the tags.
*/

import java.util.Stack;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class P21
{
  // file name used for test
  public static String htmlFileName = "index.html";

  public static void main(String[] args) throws FileNotFoundException
  {

    // prepare a stack for all the tags
    Stack<String> html_tags = new Stack<String>();

    // load file and the file into the scanner
    File htmlFile = new File(htmlFileName);
    Scanner in = new Scanner(htmlFile);

    // iterate over the tags (here whitespace is used as delimiter
    // but more complicated regex can be used to look at tags)
    while (in.hasNext())
    {
      // get the word
      String tag = in.next();

      // get the opening tag
      if (tag.contains("<") && tag.contains(">") && !tag.contains("/"))
      {
        String opeing_tag = tag;
        // push it to stack
        html_tags.push(opeing_tag);
      }
      // get the closing tag
      else if (tag.contains("<") && tag.contains(">") && tag.contains("/"))
      {
        String closing_tag = tag;

        // get the contents of the closing tag and the stack's first element
        String closing_tag_contents = closing_tag.substring(2, closing_tag.length()-1);
        String stack_contents = html_tags.peek().substring(1, html_tags.peek().length()-1);

        // if they match then pop it from stack
        if (closing_tag_contents.equals(stack_contents))
        {
          html_tags.pop();
        }
        // break because incorrect html file
        else
        {
          System.out.println("tags do not match");
          break;
        }

      }
    }
    if (html_tags.isEmpty())
    {
      System.out.println("all tags have a closing partner");
    }

    in.close(); 

  }
}
