public class LinkedListTester
{
  public static void main(String[] args)
  {
    LinkedList myLL = new LinkedList();
    myLL.addFirst(new Object("hello LL"));
    myLL.addFirst(new Object("this is storing"));
    myLL.addFirst(new Object("strings"));

    System.out.println(myLL);

    // ListIterator iter = myLL.listIterator();
    // while(iter.hasNext())
    // {
    //   System.out.println("next element: " + iter.next());
    // }


    // System.out.println(myLL.getFirst());
    // myLL.removeFirst();
    // System.out.println(myLL.getFirst());
    // myLL.removeFirst();
    // System.out.println(myLL.getFirst());

  }
}
