public class BinaryTree
{
  /** Instance Variables */
  private Node root;

  /** Constructor */
  public BinaryTree(Object rootData, BinaryTree left, BinaryTree right)
  {
    this.root = new Node();
    this.root.data = rootData;
    this.root.left = left.root;
    this.root.right = right.root;

  }

  private class Node
  {
    public Object data;
    public Node left;
    public Node right;
  }

  public int height()
  {
    return height(root); 
  }

  // static method for getting height
  public static int height(Node n)

  if (n==null){return 0;}
  else {
    return 1+Math.max(height(n.left), height(n.right));
  }
}
