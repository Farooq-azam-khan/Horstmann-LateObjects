public class QueueTester
{
  public static void main(String[] args)
  {
    QueueLinkedList qLL = new QueueLinkedList();
    qLL.addLast("first");
    qLL.addLast("second");
    qLL.addLast("third");
    qLL.addLast("fourth");
    qLL.addLast("fifth");
    System.out.println(qLL);

    qLL.removeFirst();
    System.out.println(qLL);
    qLL.removeFirst();
    System.out.println(qLL);
    qLL.removeFirst();
    System.out.println(qLL);

    QueueCircularArrayList circular_queue = new QueueCircularArrayList();
    circular_queue.addTail("first");
    circular_queue.addTail("second");
    circular_queue.addTail("thrid");
    circular_queue.addTail("fourth");
    circular_queue.addTail("fifth");
    System.out.println(circular_queue);
    circular_queue.removeHead();
    System.out.println(circular_queue);
    circular_queue.removeHead();
    System.out.println(circular_queue);
  }
}
