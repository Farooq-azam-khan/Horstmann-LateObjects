public class StackLinkedList
{
  private Node first;

  // stack is LIFO (last in first out)
  public void push(Object element)
  {
    Node newNode = new Node();
    newNode.data = element;
    // point next to what first.next is pointing to
    newNode.next = first;
    first = newNode;
  }

  public Object pop()
  {
    if (first == null)
    {
      System.out.println("first is null");
      return null;
    }
    else
    {
      Object element = first.data;
      first = first.next;
      return element;
    }
  }

  public boolean isEmpty()
  {
    return first==null;
  }
  private class Node
  {
    public Object data;
    public Node next;
  }

  public String toString()
  {
    Node tempFirst = this.first;
    String ret = getClass().getName() + "{";
    while(true)
    {
      if (tempFirst.next==null)
      {
        ret += tempFirst.data + " (first in)";
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
