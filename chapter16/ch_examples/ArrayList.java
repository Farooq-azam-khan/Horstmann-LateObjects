import java.lang.IndexOutOfBoundsException;
public class ArrayList
{
  /*
  An array list maintains a reference to an array of elements that we call the buffer.
  The buffer is large enough to hold all elements in the collection—in fact, it is usually
  larger to allow for adding additional elements. When the buffer gets full, it is replaced
  by a larger one.
  */
  private Object[] buffer;
  private int currentSize;

  // constructor
  public ArrayList()
  {
    final int INITIAL_SIZE = 10;
    this.buffer = new Object[INITIAL_SIZE];
    // eventhough INITIAL_SIZE is 10 the number of elements is 0
    this.currentSize = 0;
  } // end of ArrayList constructor method

  public int size()
  {
    return this.currentSize;
  }

  private void checkBounds(int n)
  {
    if (n < 0 || n >= currentSize)
    {
      throw new IndexOutOfBoundsException();
    }
  } // end of checkBounds method

  // O(1)
  public Object get(int pos)
  {
    checkBounds(pos);
    return buffer[pos];
  } // end of get method

  // O(1)
  public void set(int pos, Object element)
  {
    checkBounds(pos);
    buffer[pos] = element;
  } // end of set method

  // O(n)
  public Object remove(int pos)
  {
    checkBounds(pos);
    Object removed = buffer[pos];
    for (int i=pos+1; i<currentSize; i++)
    {
      buffer[i-1] = buffer[i];
    }
    currentSize--;
    return removed;
  } // end of remove method

  // O(1)+ : amortized over multiple periods
  public boolean addLast(Object newElement)
  {
    growBufferIfNecessary();
    currentSize++;
    buffer[currentSize-1] = newElement;
    return true;
  } // end of addLast method

  public void growBufferIfNecessary()
  {
    // check elements have filled the ArrayList
    if (currentSize == buffer.length)
    {
      // create a new buffer twice as large
      Object[] newBuffer = new Object[2*buffer.length];
      // copy the elements into the new buffer
      for (int i=0; i<buffer.length; i++)
      {
        newBuffer[i] = this.buffer[i];
      }
      // set the new buffer to the instance variable
      this.buffer = newBuffer;
    }
  } // end of growBufferIfNecessary method

  public String toString()
  {
    String ret = getClass().getName()+"{";
    for (int i=0; i<currentSize-1; i++)
    {
      ret += buffer[i] +", ";
    }
    return ret+ buffer[currentSize-1] + "}";
  }
} // end of ArrayList class
