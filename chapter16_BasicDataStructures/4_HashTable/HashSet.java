import java.util.NoSuchElementException;
import java.util.Iterator;

public class HashSet
{
  // create a 1-d array of node objs
  private Node[] buckets;
  private int currentSize; // keep track of num of elements (for f=n/l)

  public HashSet(int bucketsLength)
  {
    buckets = new Node[bucketsLength];
    currentSize = 0;
  }

  /**
    checks if an element exists in hashset
    @param x: looking for this obj
    @return true if x is in hashset
  */
  public boolean contains(Object x)
  {
    // get the hash code
    int h = x.hashCode();
    // if hc is negative make it positive
    if (h < 0)
    {
      h = -h;
    }
    // get the index
    h = h%buckets.length;
    // get the node in that index
    Node current = buckets[h];
    // traverse through linked list
    while(current != null)
    {
      // if found return true
      if(current.data.equals(x))
      {
        return true;
      }
      // go to the next element
      current = current.next;
    }
    return false;
  }

  /**
    adds element to hash set
    @param x : element to add
    @return true if added false otherwise
  */
  public boolean add(Object x)
  {

    // could call contains method
    int h = x.hashCode();
    if (h<0)
    {
      h = -h;
    }
    h = h% buckets.length;

    Node current = buckets[h];
    while(current != null)
    {
      // dont add if element is in set
      if(current.data.equals(x))
      {
        return false;
      }
      current = current.next;
    }

    // add element if while loop does not return false
    Node newNode = new Node();
    newNode.data = x;
    newNode.next = buckets[h];
    buckets[h] = newNode;
    currentSize++;
    return true;
  }

  /**
    @param x object to remove
    @return true if removed else fasle
  */
  public boolean remove(Object x)
  {
    int h = x.hashCode();
    if(h<0){h=-h;}
    h = h%buckets.length;

    Node current = buckets[h];
    Node previous = null;
    while(current!=null)
    {
      // if you find data
      if(current.data.equals(x))
      {
        // check if its the fist one
        if (previous == null)
        {
          // remove it this way
          buckets[h] = current.next;
        }
        else
        {
          // if not first element remove this way
          previous.next = current.next;
        }
        currentSize--;
        return true;
      }
      previous = current;
      current = current.next;
    }
    // if not found return false
    return false;
  }

  /**
  iterator
  */
  public Iterator iterator()
  {
    return new HashSetIterator();
  }

  // return size of hash set
  public int size()
  {
    return this.currentSize;
  }

  // node class
  class Node
  {
    public Object data;
    public Node next;
  }

  class HashSetIterator implements Iterator
  {
    private int bucket;
    private Node current;
    // constructor
    HashSetIterator()
    {
      current = null;
      bucket = -1;
    }

    // checks if next element exists
    public boolean hasNext()
    {
      // check if current linked list is not empty
      if (current != null && current.next != null)
      {
        return true;
      }
      // check if buckets array is not empty
      for(int b = bucket+1; b<buckets.length; b++)
      {
        if (buckets[b] != null)
        {
          return true;
        }
      }
      // otherwise there is no next element
      return false;
    }

    public Object next()
    {
      if (current != null && current.next != null)
      {
        current = current.next; // go to next element in bucket
      }
      else
      {
        // go to next bucket
        do
        {
          bucket++;
          // if gone through every element
          if (bucket == buckets.length)
          {
            // throw exception
            throw new NoSuchElementException();
          }
          current = buckets[bucket];
        }
        while (current == null);
      }
      return current.data;
    }

    // TODO: add this operation and test the class
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}
