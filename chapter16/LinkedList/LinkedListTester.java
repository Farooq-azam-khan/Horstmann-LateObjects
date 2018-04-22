public class LinkedListTester
{
  public static void main(String[] args)
  {
    LinkedList myLL = new LinkedList();
    for (int i=0; i<100; i++)
    {
      myLL.addFirst(i);
    }
    // myLL.addFirst(10);
    // System.out.println(myLL.getFirst());
    // myLL.addFirst(11);
    // System.out.println(myLL.getFirst());
    // myLL.addFirst(200);
    // System.out.println(myLL.getFirst());
    //
    // System.out.println("removed: " + myLL.removeFirst());
    //
    // myLL.addFirst(2);
    // myLL.addFirst(2240);
    // myLL.addFirst(22);
    // myLL.addFirst(430);
    //
    System.out.println("linked list: " + myLL);

  }
}
