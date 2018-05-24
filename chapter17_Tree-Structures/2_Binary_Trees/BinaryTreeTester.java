public class BinaryTreeTester
{
  public static void main(String[] args)
  {
    BinaryTree btcll = new BinaryTree("students?");
    BinaryTree btclr = new BinaryTree("dorms?");
    BinaryTree btcl = new BinaryTree("college", btcll, btclr);

    BinaryTree btcrr = new BinaryTree("tuition?");
    BinaryTree btcrl = new BinaryTree("computer science?");
    BinaryTree btcr = new BinaryTree("departmet", btcrl, btcrr);

    BinaryTree bt = new BinaryTree("university", btcl, btcr);

    System.out.println("height: " + bt);
  }
}
