/*
16.4
Add a method size to our implementation of the LinkedList class that computes the
number of elements in the list by following links and counting the elements until the
end of the list is reached.

16.6 Add an instance variable currentSize to our implementation of the LinkedList class.
Modify the add, addLast, and remove methods of both the linked list and the list iterator
to update the currentSize variable so that it always contains the correct size. Change
the size method of Exercise P16.4 so that it simply returns the value of this instance
variable.

*/
public class P4P6
{
  public static void main(String[] args)
  {
    LinkedList sizetest = new LinkedList();
    System.out.println("current size of ll is: " + sizetest.size());
    sizetest.addFirst("hi");
    sizetest.addFirst("testing size");
    System.out.println("elements: " + sizetest);
    System.out.println("size now: " + sizetest.size());

    ListIterator iter = sizetest.listIterator();
    iter.next();
    iter.add("here we are testing iter add method ");
    iter.next();
    iter.add("the size will increase");

    System.out.println("elements: " + sizetest);
    System.out.println("size after adding element in iterator: " + sizetest.size());
  } // end of main method
} // end of P4P6 class
