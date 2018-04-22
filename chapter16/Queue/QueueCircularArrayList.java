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
  public boolean isEmpty()
  {
    return currentSize == 0;
  }

  // add element to tail of queue
  public void addFirst(Object element)
  {
    growBufferIfNecessary();
    currentSize++;
    buffer[tail] = element;
    // gives circular nature
    tail = (tail+1)%buffer.length;
  }

  public Object removeFirst()
  {
    if (currentSize == 0)
    {
      throw new NoSuchElementException();
    }
    Object removed = buffer[head];
    head = (head+1) % buffer.length;
    currentSize--;
    return removed;
  }

  private void growBufferIfNecessary()
  {
    if (currentSize == buffer.length)
    {
      Object[] biggerBuffer = new Object[2*currentSize];
      for(int i=0; i<currentSize; i++)
      {
        biggerBuffer[i] = buffer[(head+1) % buffer.length];
      }
      head = 0;
      tail = currentSize;
      buffer = biggerBuffer;
    }
  }

}
