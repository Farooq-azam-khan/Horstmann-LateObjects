/*
P15.2
Write a method
public static void reverse(LinkedList<String> strings)
that reverses the entries in a linked list.
*/
import java.util.LinkedList;
import java.util.ListIterator;

public class P2
{

  public static void main(String[] args)
  {
    LinkedList<String> names = new LinkedList<String>();
    names.add("romeo");
    names.add("juliet");
    names.add("macbeth");
    names.add("lady macbeth");
    names.add("hamlet");

    System.out.println("---- linkedlist ----");
    for (String name:names)
    {
      System.out.println(name);
    }

    reverse(names);

    System.out.println("---- reverse(linkedlist) ----");
    for (String name:names)
    {
      System.out.println(name);
    }
  }
  public static void reverse(LinkedList<String> strings)
  {
    LinkedList<String> temp_str = new LinkedList<String>();
    ListIterator iter = strings.listIterator(strings.size());
    while(iter.hasPrevious())
    {
      String name = String.valueOf(iter.previous());
      temp_str.addFirst(name);
      iter.remove();
    }
    for (int i=0; i<temp_str.size(); i++)
    {
      strings.addFirst(temp_str.get(i));
    }
  }
}
