public class StackTester
{
  public static void main(String[] args)
  {
    StackLinkedList stkLL = new StackLinkedList();
    StackArrayList stkAL = new StackArrayList();

    stkLL.push("first element");
    stkLL.push("second element");
    stkLL.push("third element");
    stkLL.push("fourth element");
    stkLL.push("fifth element");
    stkLL.push("clank");

    stkAL.push("first element");
    stkAL.push("second element");
    stkAL.push("third element");
    stkAL.push("fourth element");
    stkAL.push("fifth element");
    stkAL.push("clank");

    System.out.println(stkLL);
    System.out.println(stkAL);

    System.out.println(stkLL.pop()  + " == " + stkAL.pop());


  }
}
