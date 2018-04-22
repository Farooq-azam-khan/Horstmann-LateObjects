import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class LinkedList
{
  // Linked List takes note of the first element
  private Node first;

  // counter for number of element in linked list
  private int numElements = 0;

  // get the first element in the linked list
  public Object getFirst()
  {
    if (this.first == null)
    {
      throw new NoSuchElementException("First element in list is not definied");
    }
    return this.first.data;
  }

  // add to the begining of the linked list
  public void addFirst(Object element)
  {
    Node newNode = new Node();
    newNode.data = element;
    // have the new nodes next element point to the current first element
    newNode.next = this.first;
    // the first element is not the new node
    this.first = newNode;

    // increment the number of elements counter
    this.numElements++;
  }

  // remove the first element
  public Object removeFirst()
  {
    if (this.first == null)
    {
      throw new NoSuchElementException("first element is not defined");
    }
    Object element = this.first.data; // needed to return the data of the removed element
    // have the first element point to the next element
    this.first = this.first.next;

    return element;
  }

  // iterate through linked list
  public LinkedListIterator listIterator()
  {
    return new LinkedListIterator();
  }

  public String toString()
  {
    // iterates with a temporary var pointion to first
    Node tempFirst = this.first;
    String ret = "(size - " + this.numElements + ") | {";
    while(true)
    {
      ret += tempFirst.data + ", ";
      tempFirst = tempFirst.next;

      if (tempFirst == null)
      {
        ret = ret.substring(0, ret.length()-2);
        break;
      }
    }
    ret += "}";

    return ret;
  }
  // ------------------------ ITERATOR CLASS ------------------------
  private class LinkedListIterator implements ListIterator
  {
    Node position; // last visited element
    Node previous; // element before last visited element
    boolean isAfterNext; // checks if next method has been called

    LinkedListIterator()
    {
      position = null;
      previous = null;
      isAfterNext = false;

    }

    // iterate through the element
    public Object next()
    {
      if (!this.hasNext())
      {
        throw new NoSuchElementException("iterator did not find next element");
      }
      previous = position; // assign position to previous for removing element
      isAfterNext = true;
      // if there is noting in linked list then assign position to it
      if (this.position == null)
      {
        this.position = first;
      }
      else
      {
        this.position = position.next;
      }
      return position.data;
    }

    // check if the next element exists
    public boolean hasNext()
    {
      if (this.position == null)
      {
        return first != null;
      }
      else
      {
        return this.position != null;
      }
    }

    // remove the element at the current position
    public Object remove()
    {
      if (!isAfterNext)
      {
        throw new IllegalStateException(".next() was not called");
      }
      if (this.position == first)
      {
        removeFirst();
      }
      else
      {
        this.previous.next = this.position.next;
      }
      position = previous;
      isAfterNext = false;
      return new Object();
    }

    public void add(Object element)
    {
      if (position == null)
      {
        addFirst(element);
        position = first;
      }
      else
      {
        Node newNode = new Node();
        newNode.data = element;
        // newNode's next element is the position's next reference
        newNode.next = this.position.next;
        // position's new next element is this node
        this.position.next = newNode;
        // the current position is at the new node
        this.position = newNode;
      }
      isAfterNext = false;

    }

    public void set(Object element)
    {
      if (!isAfterNext)
      {
        throw new IllegalStateException("did not call next before setting");
      }
      this.position.data = element;

    }
  }
  // ------------------------ NODE CLASS ----------------------------
  // node class stores data and reference to next element
  private class Node
  {
    public Object data;
    public Node next;
  }
}
