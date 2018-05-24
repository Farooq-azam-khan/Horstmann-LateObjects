public class BinarySearchTree
{
  private Node root;
  public BinarySearchTree()
  {
    this.root = null;
  }

  public void add(Comparable obj)
  {
    Node newNode = new Node();
    newNode.data = obj;
    newNode.left = null;
    newNode.right = null;
    if (this.root == null)
    {
      this.root = newNode;
    }
    else
    {
      this.root.addNode(newNode);
    }
  }

  public boolean find(Comparable obj)
  {
    Node current = root;
    while(current != null)
    {
      int d = current.data.compareTo(obj);
      // if root node is obj
      if (d == 0) { return true; }
      else if (d > 0) { current = current.left; }
      else if (d < 0 ) { current = current.right; }
    }
    return false;
  }

  public void remove(Comparable obj)
  {
    Node toBeRemoved = root;
    Node parent = null;
    boolean found = false;
    while(!found && toBeRemoved != null)
    {
      int d = toBeRemoved.data.compareTo(obj);
      if (d == 0) { found = true; }
      else
      {
        parent = toBeRemoved;
        if (d > 0) { toBeRemoved = toBeRemoved.left; }
        else { toBeRemoved = toBeRemoved.right; }
      }
    }

    if (!found){ return ; }
    else
    {
      // if one child is empty
      if (toBeRemoved.left == null || toBeRemoved.right == null)
      {
        Node newChild;
        if (toBeRemoved.left == null)
        {
          newChild = toBeRemoved.right;
        }
        else
        {
          newChild = toBeRemoved.left;
        }

        if (parent == null)
        {
          root = newChild;
        }
        else if (parent.left == toBeRemoved)
        {
          parent.left = newChild;
        }
        else
        {
          parent.right = newChild;
        }
        return ;
      }
      // neighter subtree is empty

      // find smallest element of right subtree
      Node smallestParent = toBeRemoved;
      Node smallest = toBeRemoved.right;
      while(smallest.left != null)
      {
        smallestParent = smallest;
        smallest = smallest.left;
      }
      // move contents, unlink child
      toBeRemoved.data = smallest.data;
      if (smallestParent == toBeRemoved)
      {
        smallestParent.left = smallest.right;
      }
      else
      {
        smallestParent.left = smallest.right;
      }
    }
  }
  public void print()
  {
    print(root);
    System.out.println();
  }
  private static void print(Node parent)
  {
    if (parent==null){return ;}
    print(parent.left);
    System.out.print(parent.data + " ");
    print(parent.right);
    System.out.println(); 
  }

  class Node
  {
    public Comparable data;
    public Node left;
    public Node right;
    public void addNode(Node newNode)
    {
      int comp = newNode.data.compareTo(data);
      if (comp < 0)
      {
        if (left == null)
        {
          left = newNode;
        }
        else
        {
          left.addNode(newNode);
        }
      }
      else if (comp > 0)
      {
        if (right == null)
        {
          right = newNode;
        }
        else
        {
          right.addNode(newNode);
        }
      }
    }
  }
}
