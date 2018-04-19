public class QueueTester
{
  public static void main(String[] args)
  {
    QueueLinkedList qLL = new QueueLinkedList();
    qLL.addFirst("my name");
    // System.out.println(qLL);
    qLL.addFirst("add");
    // System.out.println(qLL);
    qLL.addFirst(10);
    System.out.println(qLL);

    qLL.removeFirst();
    System.out.println(qLL);
    qLL.removeFirst();
    System.out.println(qLL);

  }
}
