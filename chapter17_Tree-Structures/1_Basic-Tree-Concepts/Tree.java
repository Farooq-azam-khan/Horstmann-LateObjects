import java.util.List;
import java.util.ArrayList;

/**
  class: Tree
  usage: contains a reference to its root (which is a list of node objects)
*/
public class Tree
{
  private Node root;
  private class Node
  {
    public Object data;
    public List<Node> children;

    /**
      recursive helper function to calculate size
    */
    public int size()
    {
      int sum = 0;
      for (Node child:children)
      {
        sum=sum+child.size();
      }
      return 1+sum;
    }

    /**
      recursively find leaves in node

      - If n is a leaf, the leaf count is 1
      Otherwise
      Let c1 ... cn be the children of n
      The leaf count is leafCount(c1) + ...
      + leafCount(cn)
    */
    public int leafLength()
    {
      boolean isLeaf = children.size() == 0;
      if (isLeaf){return 1;}
      else
      {
        int sum = 0;
        for (Node child:children)
        {
          sum += child.leafLength();
        }
        return sum;
      }
    }

    public String toString()
    {
      String ret = String.valueOf(data);
      return ret;
    }
  }
  public Tree(Object rootData)
  {
    this.root = new Node();
    this.root.data = rootData;
    this.root.children = new ArrayList<Node>();
  }
  public void addSubtree(Tree subtree)
  {
    root.children.add(subtree.root);
  }

  // get the size of the overall tree
  public int size()
  {
    // useful to have empty tree
    if (root == null){return 0;}
    return root.size();
  }

  public String getChildren(boolean node)
  {
    if (this.root == null)
    {
      return null;
    }
    String ret = "";
    if (node){ ret += "(root): "+this.root.data + "\n";}
    ret+= "(children): "+this.root.children;
    return ret;
  }

  public int getLeafLength()
  {
    if (root==null){return 0;}
    return root.leafLength();
  }
}
