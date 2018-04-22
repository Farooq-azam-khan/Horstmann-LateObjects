public class QueueLinkedList
{
  private Node first;
  private Node last;
  private int currentSize = 0;

  // first in first out (FIFO)
  public void addLast(Object element)
  {
    Node newNode = new Node(element, null);
    if (first == null)
    {
      first = newNode;
      last = first;
    }
    else
    {
      last.next = newNode;
      last = newNode;

    }

    currentSize++;

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
