public class QueueLinkedList
{
  private Node first;
  private Node last;
  private int currentSize = 0;

  // first in first out (FIFO)
  public void addLast(Object element)
  {
    // create a node pointing to null
    Node newNode = new Node(element, null);
    // check if there is noting in the linked list
    if (first == null)
    {
      // first element will be newNode
      first = newNode;
      // last element will first element (in this case)
      last = first;
    }
    else
    {
      // last will point to the newNode
      last.next = newNode;
      // last will be assigned the new node
      last = newNode;
    }
    currentSize++;
  }
  public Object peek()
  {
    return first.data; 
  }
  // same as removeFirst
  public Object removeFirst()
  {
    if (first == null)
    {
      System.out.println("null pointer");
      return null;
    }
    else
    {
      Object first_element = first.data;
      // remove here
      first = first.next;
      currentSize--;
      return first_element;
    }
  }

  private class Node
  {
    public Object data;
    public Node next;
    public Node(){};
    public Node(Object data, Node next)
    {
      this.data = data;
      this.next = next;
    }

  }

  public String toString()
  {
    String ret = "{";
    Node tempFirst = first;

    while(true)
    {
      if (tempFirst == last)
      {
        ret += tempFirst.data;
        break;
      }
      else
      {
        ret += tempFirst.data + ", ";
        tempFirst = tempFirst.next;
      }
    }
    ret += "}";
    return ret;

  }
}
