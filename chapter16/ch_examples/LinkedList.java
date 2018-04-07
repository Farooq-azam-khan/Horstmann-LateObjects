import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

class LinkedList
{
  // first node in linked list
  private Node first;

  // constructor
  public LinkedList()
  {
    this.first = null;
  }

  // gets the first element in linked list
  public Object getFirst()
  {
    // throw exception if first element does not exit
    if (first == null)
    {
      throw new NoSuchElementException("Linked List is empty");
    }
    // get the data of the first node
    return this.first.data;
  }

  // adds an element to the begining of the list
  public void addFirst(Object element)
  {
    // create a new node object
    Node new_node_element = new Node();
    // assign the data and the element beign passed int
    new_node_element.data = element;
    // the next node to this new_node_element will be the first element
    new_node_element.next = this.first;
    // the first node will be the new node: adding to beginning of linked list
    this.first = new_node_element;
  }

  // remove first element in linked list
  public Object removeFirst()
  {
    if (this.first == null)
    {
      throw new NoSuchElementException("Linked List is Empty");
    }
    // reference to the element in the first node
    Object element = this.first.data;

    // first element is now the the next element which was reference by first
    this.first = this.first.next;

    // return reference to that node
    return element;
  } // end of removeFirst method

  public ListIterator listIterator()
  {
    return new LinkedListIterator();
  }


  // Private Node Class (sotres reference to the data and next node)
  private class Node
  {
    public Object data;
    public Node next;
  }

  // Private LinkedList iterator
  class LinkedListIterator implements ListIterator
  {
    private Node position;        // keeps track of its last element it iterated over
    private Node previous;        // keeps track of the node two steps before
    private boolean isAfterNext;  // tracks if next method has been called

    public LinkedListIterator()
    {
      position = null;
      previous = null;
    }

    public Object next()
    {
      if (!hasNext())
      {
        throw new NoSuchElementException("no such element found");
      }
      this.previous = this.position; // used to remember for removal
      this.isAfterNext = true;

      // if first position is empty then it is the first one
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

    public boolean hasNext()
    {
      // check if the current position is null
      if (this.position == null)
      {
        return first != null;
      }
      else
      {
        // check if the next element is not null
        return this.position.next != null;
      }
    } // end of hasNext element

    // remove element at the current iteration position
    public void remove()
    {
      if (isAfterNext == false)
      {
        throw new IllegalStateException("did not call next");
      }
      if (this.position == first)
      {
        removeFirst();
      }
      else
      {
        this.previous.next = this.position.next; // current position will be removed
      }
      this.position = this.previous;
      isAfterNext = false;
    } // end of remove method

    // add element at the current iteration position
    public void add(Object element)
    {
      // if the current position is emplty
      if (this.position == null)
      {
        // add it to the begining of the list iterator
        addFirst(element);
        // reference the node object so that it can be stored in the linked list
        this.position = first;
      }
      else
      {
        // create a new node
        Node newNode = new Node();
        // add the data to that node
        newNode.data = element;
        // have the next element in the node be whatever the current position
        // of next is pointing to
        newNode.next = this.position.next;
        // have the current node point to the new node
        this.position.next = newNode;
      }
      isAfterNext = false;
    } // endof add method

    public void set(Object element)
    {
      if (!isAfterNext)
      {
        throw new IllegalStateException("cannot set something here, must call next method");
      }
      position.data = element;

    }



  } // end of iterator class

  public String toString()
  {
    String ret = getClass().getName()+"{";

    ListIterator iter = this.listIterator();
    while(iter.hasNext())
    {
      ret += iter.next() + ", ";
    }
    ret += "}";
    return ret;
  } // end of tostring method
}
