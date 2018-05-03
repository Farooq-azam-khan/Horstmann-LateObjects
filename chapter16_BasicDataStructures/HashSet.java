public class HashSet
{
  private Node[] buckets;
  private int currentSize;

  public HashSet(int bucketsSize)
  {
    buckets = new Node[bucketsSize];
  }
  /*
    "MAD (multiply-add-divide) method" use used for hash code compression.
    Choose a prime number p larger than the length L of the hash
    table and two values a and b between 1 and p – 1.
    Then reduce h to ((a h + b) % p) % L.
  */
  public int MADcompression(Object x)
  {
    int h = x.hashCode();
    int prime = this.getPrimeNumber();
    int a = 1;
    int l = buckets.length;
    int b = prime - 1;
    h = ((a*h+b)% prime )%l;
    return h;
  }

  private int getPrimeNumber()
  {
    for(int i=buckets.length; i<5*buckets.length; i++)
    {
      if(this.isPrime(i))
      {
        return i;
      }
    }
    return 2;
  }

  private boolean isPrime(int num)
  {
    for (int i = 1; i<num; i++)
    {
      if (num % i == 0)
      {
        return false;
      }
    }
    return true;
  }

  private class Node
  {
    public Object data;
    public Node next;
  }
}
