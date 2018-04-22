public class StackLinkedList
{
  private Node first;

  // stack is LIFO (last in first out)
  // same as addFirst()
  public void push(Object element)
  {
    first = new Node(element, first);
    // newNode.data = element;
    // // point next to what first.next is pointing to
    // newNode.next = first;
    // first = newNode;
  }
  public Object peek()
  {
    return first.data; 
  }

  // remove the last added element in stack (ie the first element in linked list)
  // same as removeFirst()
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


  /**
  class: Node
  */
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
