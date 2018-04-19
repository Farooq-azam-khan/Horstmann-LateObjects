public class QueueLinkedList
{
  private Node first;
  private Node last;
  private int currentSize = 0;

  // first in first out (FIFO)
  public void addFirst(Object element)
  {
    first = new Node(element, first);
    if (currentSize == 0)
    {
      last = first;
    }
    currentSize++;
  }

  public Object removeFirst()
  {
    Node tempFirst = first;
    Node previous;
    Object lastData = new Object();
    while(true)
    {
      previous = tempFirst;
      tempFirst = tempFirst.next;
      if (tempFirst == null)
      {
        break;
      }
      // find the last element
      if (tempFirst == last)
      {
        lastData = last.data;
        last = previous;
        // System.out.println("last is now: " + last.data);
      }
    }

    return lastData;
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
        ret += tempFirst.data + "(first in)";
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
