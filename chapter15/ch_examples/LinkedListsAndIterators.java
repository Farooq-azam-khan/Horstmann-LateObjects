import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListsAndIterators
{
  public static void main(String[] args)
  {
    LinkedList<String> names = new LinkedList<String>();

    names.addLast("this is a list of names");
    names.addLast("i cannot have this itertaor");
    names.addLast("why did i call this variable names");
    names.addLast("hi");

    ListIterator iter = names.listIterator();
    System.out.println(iter.next());

    iter.next();
    iter.add("this is added after the iterator goes over the second element");
    iter.next();
    iter.remove();
    System.out.println(names); 

  }
}
