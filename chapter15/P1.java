/*
P1
Write a method
public static void downsize(LinkedList<String> employeeNames, int n)
that removes every nth employee from a linked list.
*/
import java.util.LinkedList;
public class P1
{
  public static void main(String[] args)
  {
    // method test
    LinkedList<String> employeeNames = new LinkedList<String>();
    int n = 4;

    employeeNames.addFirst("tommy");
    employeeNames.addFirst("timmy");
    employeeNames.addFirst("not timmy");
    downsize(employeeNames, n);

  }

  public static void downsize(LinkedList<String> employeeNames, int n)
  {
    // checking the nth posting
    int counter = 0;
    String remove_name = "";
    for (String name:employeeNames)
    {
      counter++;
      if (counter == n)
      {
        remove_name = name;
      }
    }
    System.out.println("removing: " + remove_name);
    employeeNames.remove(remove_name);
  }
}
