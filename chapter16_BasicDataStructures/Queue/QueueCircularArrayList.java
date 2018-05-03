import java.util.NoSuchElementException;

public class QueueCircularArrayList
{
  private Object[] buffer;
  private int currentSize;
  private int head;
  private int tail;

  QueueCircularArrayList()
  {
    final int INITIAL_SIZE = 10;
    buffer = new Object[INITIAL_SIZE];
    currentSize = 0;
    head = 0;
    tail = 0;
  }

  // return true if queue is empty
  public boolean isEmpty(){ return currentSize == 0;}

  // add element to tail of queue
  public void addTail(Object element)
  {
    growBufferIfNecessary();
    currentSize++;
    buffer[tail] = element;
    // gives circular nature
    tail = (tail+1) % buffer.length;
  }

  public Object peek()
  {
    return buffer[head];
  }

  public Object removeHead()
  {
    // if queue is empty throw exception
    if (currentSize == 0)
    {
      throw new NoSuchElementException();
    }
    // remove first element (FIFO)
    Object removed = buffer[head];
    head = (head+1) % buffer.length;
    currentSize--;
    return removed;
  }

  private void growBufferIfNecessary()
  {
    // check if all the buffer is filled up
    if (currentSize == buffer.length)
    {
      // create a buffer twice as big
      Object[] biggerBuffer = new Object[2*currentSize];
      // copy the element to bigger buffer
      for(int i=0; i<currentSize; i++)
      {
        //                       eg (0+0) mod (10)
        //                          (0+1) mod (10)
        biggerBuffer[i] = buffer[(head+i) % buffer.length];
      }
      buffer = biggerBuffer;
      head = 0;
      tail = currentSize;
    }
  }

  public String toString()
  {
    String ret = "{";
    for (int i=head; i<tail; i++)
    {
      if (i == tail-1)
      {
        ret += buffer[i];
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
