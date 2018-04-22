public class StackArrayList
{
  public Object[] buffer;
  public int currentSize;
  StackArrayList()
  {
    final int INITIAL_SIZE = 10;
    buffer = new Object[INITIAL_SIZE];
    currentSize = 0;
  }

  public void push(Object element)
  {
    growIfNecessary();
    // add to end
    buffer[currentSize] = element;
    this.currentSize++;
  }

  // removes the last element in arraylist
  public Object pop()
  {
    Object lastElement = buffer[this.currentSize-1];
    buffer[currentSize-1] = null;
    currentSize--;
    return lastElement;
  }

  private void growIfNecessary()
  {
    if (currentSize == buffer.length)
    {
      Object[] biggerBuffer = new Object[2*currentSize];
      for(int i=0; i<currentSize; i++)
      {
        biggerBuffer[i] = buffer[i];
      }
      buffer = biggerBuffer;
    }
  }

  public String toString()
  {
    String ret = getClass().getName() + "{";
    for(int i=currentSize-1; i>=0; i--)
    {
      if (i==0)
      {
        ret += buffer[i] + " (first in)"; 
      }
      else
      {
        ret += buffer[i] + ", ";
      }

    }

    ret += "}";
    return ret;
  }
}
