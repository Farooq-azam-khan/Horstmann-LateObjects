/**
P16.30 Implement the hash set in Section 16.4, using the "MAD (multiply-add-divide)
method" for hash code compression. For that method, you choose a prime number p
larger than the length L of the hash table and two values a and b between 1 and p – 1.
Then reduce h to ((a h + b) % p) % L.
*/

public class P30
{
  public static void main(String[] args)
  {
    // TODO: improve implementation
    HashSet hs = new HashSet(10);
    System.out.println(hs.MADcompression("hi"));

  }
}
