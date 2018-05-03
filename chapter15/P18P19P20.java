/*
15.18
(TODO:q18 how would one use a hashcode)
A labeled point has x- and y-coordinates and a string label.
Provide a class LabeledPoint with a constructor
LabeledPoint(int x, int y, String label) and hashCode and
equals methods. Two labeled points are considered the same when they have the
same location and label.

(TODO:q19 how would one use a hashcode)
15.19 Reimplement the LabeledPoint class of the preceding exercise by
storing the location
in a java.awt.Point object.
Your hashCode and equals methods should call the hashCode
and equals methods of the Point class.

15.20
Modify the LabeledPoint class of Exercise P15.18
so that it implements the Comparable
interface. Sort points first by their x-coordinates.
If two points have the same x-coordinate, sort them by their y-coordinates.
If two points have the same x- and y-coordinates, sort them by their label.
*/

import java.util.TreeSet;
import java.util.Set;

public class P18P19P20
{
  public static void main(String[] args)
  {
    Set<LabelPoint> points = new TreeSet<LabelPoint>();
    for (int i=0; i<10; i++)
    {
      points.add(new LabelPoint(i+"th label", i, i+1));
    }

    points.add(new LabelPoint("1th added label", 0, 1.2));

    System.out.println(points);

    LabelPoint lp1 = new LabelPoint("testing equal", 1, 1);
    LabelPoint lp2 = new LabelPoint("testing equal", 1, 1);
    System.out.println("p1 and p2 are equal: " + lp1.equals(lp2));
  }
}

class LabelPoint implements Comparable<LabelPoint>
{
  private String label;
  private double x;
  private double y;
  public LabelPoint(String label, double x, double y)
  {
    this.label = label;
    this.x = x;
    this.y = y;
  }
  public String getLabel(){return this.label;}
  public double getX(){return this.x;}
  public double getY(){return this.y;}
  public String toString(){return this.label+": x="+this.x+" y="+this.y;}
  public boolean equals(LabelPoint other)
  {
    return (this.x==other.getX())&&(this.y==other.getY())&&(this.label.equals(other.getLabel()));
  }

  public int compareTo(LabelPoint other)
  {
    if(this.x == other.getX())
    {
      if (this.y == other.getY())
      {
        return this.label.compareTo(other.getLabel());
      }
      else if (this.y>other.getY())
      {
        return 1;
      }
      else
      {
        return -1;
      }

    }
    else if (this.x > other.getX())
    {
      return 1;
    }
    else
    {
      return -1;
    }
  }
}
