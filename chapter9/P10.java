/*
P9.10
The Rectangle class of the standard
Java library does not supply a method to compute
the area or the perimeter of a rectangle.
Provide a subclass BetterRectangle of the
Rectangle class that has getPerimeter and getArea methods.
Do not add any instance variables.
In the constructor, call the setLocation and setSize methods of the Rectangle
class. Provide a program that tests the methods that you supplied.
*/

import java.awt.Rectangle;

public class P10
{
  public static void main(String[] args)
  {
    BetterRectangle br = new BetterRectangle(0, 0, 20, 5);
    System.out.println("Perimeter: " + br.getPerimeter());
    System.out.println("Area: " + br.getArea());

  }
}

class BetterRectangle extends Rectangle
{
  public BetterRectangle(int x, int y, int width, int height)
  {
    setLocation(x, y); 
    setSize(width, height);
  }

  public double getPerimeter()
  {
    return getWidth()*2 + getWidth()*2;
  }
  public double getArea()
  {
    return getWidth()*getWidth();
  }
}
