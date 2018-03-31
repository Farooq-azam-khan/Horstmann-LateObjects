/*
P9.12
A labeled point has x- and y-coordinates and a string label.
Provide a class LabeledPoint with a constructor
LabeledPoint(int x, int y, String label) and a toString
method that displays x, y, and the label.
*/

public class P12
{
  public static void main(String[] args)
  {
    LabeledPoint lp1 = new LabeledPoint(10, 20, "hi");
    System.out.println(lp1); 

  }
}

class LabeledPoint
{
  private int x;
  private int y;
  private String label;
  public LabeledPoint(int x, int y, String label)
  {
    this.x = x;
    this.y = y;
    this.label = label;
  }
  public String toString()
  {
    return getClass().getName()+"[x: "+this.x +" y: "+this.y+" label: "+this.label+"]";
  }
}
