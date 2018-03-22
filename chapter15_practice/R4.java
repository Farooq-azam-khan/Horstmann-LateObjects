/*
Explain what the following code prints. Draw a picture of the linked list after each
step.
LinkedList<String> staff = new LinkedList<String>();
staff.addFirst("Harry");
staff.addFirst("Diana");
staff.addFirst("Tom");
System.out.println(staff.removeFirst());
System.out.println(staff.removeFirst());
System.out.println(staff.removeFirst());
*/
import java.util.LinkedList;
public class R4
{
  public static void main(String[] args)
  {
    LinkedList<String> staff = new LinkedList<String>();
    staff.addFirst("Harry");
    staff.addFirst("Diana");
    staff.addFirst("Tom");
    System.out.println(staff.removeFirst());
    System.out.println(staff.removeFirst());
    System.out.println(staff.removeFirst()); 
  }
}
