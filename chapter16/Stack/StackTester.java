public class StackTester
{
  public static void main(String[] args)
  {
    StackLinkedList stkLL = new StackLinkedList();
    StackArrayList stkAL = new StackArrayList();

    stkLL.push(35);
    stkLL.push(23);
    stkLL.push("my name");
    stkLL.push(10);
    stkLL.push(10);
    stkLL.push("clank");

    stkAL.push(35);
    stkAL.push(23);
    stkAL.push("my name");
    stkAL.push(10);
    stkAL.push(10);
    stkAL.push("clank");

    System.out.println(stkLL);
    System.out.println(stkAL);

    System.out.println(stkLL.pop()  + " == " + stkAL.pop()); 


  }
}
