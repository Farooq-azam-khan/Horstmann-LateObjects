import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class collection
{
  public static void main(String[] args)
  {
    Collection<String> arrlst = new ArrayList<String>();

    arrlst.add("this is an arraylist");
    // System.out.println(arrlst);

    LinkedList<String> names = new LinkedList<String>();
    names.add("bary allan");
    names.add("flash");
    names.add("speedy  gonzales");

    // System.out.println("removefirst: " + names.removeFirst());

    ListIterator<String> iterLinkedList = names.listIterator();
    while(iterLinkedList.hasNext())
    {
      // names.addFirst("j"); // cannot do, have to use iterator
      iterLinkedList.add("j");
      iterLinkedList.add("i");
      String iterLinkedList_next = iterLinkedList.next();
      System.out.println(iterLinkedList_next);
    }

    while(iterLinkedList.hasPrevious())
    {
      String iterLinkedList_next = iterLinkedList.previous();
      System.out.println(iterLinkedList_next);
      if (iterLinkedList_next == "j")
      {
        System.out.println("removed j");
        names.remove("j");
      }
    }

    // // can also use for each loop
    // for (String name : names)
    // {
    //   System.out.println("for each loop: " + name);
    //   if (name == "j")
    //   {
    //     names.remove("j");
    //
    //   }
    // }


  }
}
