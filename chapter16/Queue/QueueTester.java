public class QueueTester
{
  public static void main(String[] args)
  {
    QueueLinkedList qLL = new QueueLinkedList();
    qLL.addLast("first");
    qLL.addLast("second");
    qLL.addLast("thrid");
    System.out.println(qLL);

    qLL.removeFirst();
    System.out.println(qLL);


  }
}
