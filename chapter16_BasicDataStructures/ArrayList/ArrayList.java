public class ArrayList
{
  private int currentSize;
  private Object[] buffer;

  // constructor
  public ArrayList()
  {
    final int INITIAL_SIZE = 10;
    buffer = new Object[INITIAL_SIZE];
    currentSize = 0;
  }

  // return size
  public int size()
  {
    return this.currentSize;
  }
  // get the i'th element
  public Object get(int index)
  {
    checkBounds(index);
    return buffer[index];
  }
  // remove the i'th element
  public Object remove(int index)
  {
    checkBounds(index);
    Object removeElement = buffer[index];

    // start from the index and go to the end of the list
    for (int i=index+1; i<this.currentSize; i++)
    {
      buffer[i-1] = buffer[i];
    }
    this.currentSize--;
    return removeElement;
  }
  // add to the end of arraylist
  public void addLast(Object element)
  {
    growBufferIfNecessary();
    buffer[this.currentSize] = element;
    this.currentSize++;
  }

  private void growBufferIfNecessary()
  {
    if (currentSize == buffer.length)
    {
      Object[] newBuffer = new Object[2*this.currentSize];
      // copy over element to new buffer
      for (int i=0; i<this.currentSize; i++)
      {
        newBuffer[i] = buffer[i];
      }
      // have the buffer point to the new buffer
      buffer = newBuffer;
    }
  }

  private void checkBounds(int index)
  {
    if (index <0 || index >= this.currentSize)
    {
      throw new IndexOutOfBoundsException("index is out of bounds");
    }
  }

  public String toString()
  {
    String ret = "{";
    for (int i=0; i<currentSize; i++)
    {
      if (i==currentSize-1)
      {
        ret += buffer[i];
      }
      else
      {
        ret+= buffer[i] + ", ";
      }
    }

    ret += "}";

    return ret;

  }

}
