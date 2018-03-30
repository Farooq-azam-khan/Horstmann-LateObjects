/*
16.2
Consider a version of the LinkedList class of Section 16.1 in which the addFirst
method has been replaced with the following faulty version:
public void addFirst(Object element)
{
Node newNode = new Node();
first = newNode;
newNode.data = element;
newNode.next = first;
}
Develop a program ListTest with a test case that shows the error. That is, the
program should print a failure message with this implementation but not with the
correct implementation.
*/
import java.util.NoSuchElementException;

public class P2
{
  public static void main(String[] args)
  {
    // list test
    LinkedListForP2 testadd = new LinkedListForP2();
    testadd.add("hi");
    testadd.add("hello ll");
    testadd.add("prob 2");

    System.out.println(testadd.getFirstThree());
    System.out.println("As one can see above only the last element is being referenced");
    System.out.println("This is because first is referencing the latest node being created");




  }
}

class LinkedListForP2
{
  private Node first;

  public void add(String element)
  {
    Node newNode = new Node();
    first = newNode;
    newNode.data = element;
    newNode.next = first;
  }

  public String getFirstThree()
  {
    if (first == null && first.next == null && first.next.next == null)
    {
      throw new NoSuchElementException("add elements to list");
    }
    return first.data + ", " + first.next.data + ", " + first.next.next.data;

  }

  LinkedListForP2()
  {
    first = null;
  }
  class Node
  {
    private String data;
    private Node next;
  }
}
