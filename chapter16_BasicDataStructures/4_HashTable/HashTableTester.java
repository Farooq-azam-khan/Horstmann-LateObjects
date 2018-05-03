public class HashTableTester
{
  public static void main(String[] args)
  {
    System.out.println("get the hash code of an object and compress it");

    // get the hashcode
    int hc = "hello world".hashCode();
    // make the hc positive for mod operator
    if (hc < 0){hc *= -1;}
    int arrayLength = 10;
    int position = hc % arrayLength;

    System.out.println("hc: " + hc);
    System.out.println("compressed hc: " + position);
  }
}
