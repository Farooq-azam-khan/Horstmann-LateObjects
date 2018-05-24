public class BinaryTree
{
  /** Instance Variables */
  private Node root;

  /** Constructors */
  public BinaryTree(Object rootData, BinaryTree left, BinaryTree right)
  {
    this.root = new Node();
    this.root.data = rootData;
    this.root.left = left.root;
    this.root.right = right.root;
  }
  public BinaryTree(Object rootData)
  {
    this.root = new Node();
    this.root.data = rootData;
  }

  public BinaryTree()
  {
    this.root = null;
  }

  public class Node
  {
    public Object data;
    public Node left;
    public Node right;

    public String toString()
    {
      String ret = data + "\n";
      ret += "(left) " + left.data + "(right) " + right.data;
      return ret;
    }
  }

  public int height()
  {
    return BinaryTree.height(root);
  }

  // static method for getting height
  public static int height(Node n)
  {
    if (n==null)
    {
      return 0;
    }
    else
    {
      return 1+Math.max(height(n.left), height(n.right));
    }
  }

  /**
    method: print the tree
  */
  public String toString()
  {
    String ret = this.root.toString();
    return "\n" + ret;
  }
}
