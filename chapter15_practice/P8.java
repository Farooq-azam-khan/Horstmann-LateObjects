/*
P15.8
Implement the sieve of Eratosthenes: a method for computing
prime numbers, known to the ancient Greeks. This method
will compute all prime numbers up to n. Choose an n.
First insert all numbers from 2 to n into a set. Then erase all
multiples of 2 (except 2); that is, 4, 6, 8, 10, 12, . . . . Erase
all multiples of 3; that is, 6, 9, 12, 15, . . . . Go up to n. Then
print the set.
*/
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
public class P8
{
  public static void main(String[] args)
  {

    int n = 1000; // choose n
    Set<Integer> prime = new HashSet<Integer>();

    // add number from 2 to n into a set
    for (int i=2; i<=n; i++)
    {
      prime.add(i);
    }

    // erase all multiples of 2, 3, 4, ..., n
    for (int i=2; i<=n; i++)
    {
      // set to store all multiples of i except i
      Set<Integer> multiples_i = new HashSet<Integer>();
      // find all the multiples of i
      for (Integer num:prime)
      {
        if (num!=i&&num%i==0)
        {
          multiples_i.add(num);
        }
      }

      // remove those multiples
      for (Integer num:multiples_i)
      {
        if (prime.contains(num))
        {
          prime.remove(num);
        }
      }

      // clear set of multiples for next i
      multiples_i.clear();
    }
    Set<Integer> mult_2 = new HashSet<Integer>();
    for (Integer num:prime)
    {
      if (num!=2&&num%2==0)
      {
        mult_2.add(num);
      }
    }
    for (Integer num:mult_2)
    {
      if (prime.contains(num))
      {
        prime.remove(num);
      }
    }

    System.out.println(prime);

  }
}
