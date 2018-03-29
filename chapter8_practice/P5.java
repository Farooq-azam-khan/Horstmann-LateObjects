/*
P8.5 Implement a class SodaCan with methods getSurfaceArea() and getVolume().
In the constructor, supply the height and radius of the can.
*/
public class P5
{
  public static void main(String[] args)
  {
                    // radius and height
    SodaCan pepsi = new SodaCan(10.0, 10.0);
    System.out.println("volume: "
    + pepsi.getVolume() + "units^3 surfaceArea: " + pepsi.getSurfaceArea() +" units^2");

  }

}

class SodaCan
{
  private double radius;
  private double height = 0;

  private double volume;
  private double surface_area;

  public SodaCan()
  {
    this.radius = 0;
    this.height = 0;

    this.volume = 0.0;
    this.surface_area = 0.0;
  }
  public SodaCan(double radius, double height)
  {
    this.radius = radius;
    this.height = height;

    this.volume = calculateVolume();
    this.surface_area = calculateSurfaceArea();
  }
  public void setRadius(double radius)
  {
    this.radius = radius;
  }
  public void setHeight(double height)
  {
    this.height = height;
  }
  public void setSurfaceArea(double surface_area)
  {
    this.surface_area = surface_area;
  }
  public void setVolume(double volume)
  {
    this.volume = volume;
  }
  public double getVolume()
  {
    return this.volume;
  }
  public double getSurfaceArea()
  {
    return this.surface_area;
  }
  public double calculateSurfaceArea()
  {
    // area of 2 circles + area of rectangle
    // area of cirlce = pi r*r
    // area of rectangle = circumference * height
    return 3.14*this.radius*this.radius*2 + this.height*3.14*2*this.radius;
  }
  public double calculateRadius()
  {
    // TODO: implemelt getting radius with known volume and sa
    return 0.0;
  }
  public double calculateHeight()
  {
    // TODO: implemelt getting height with known volume and sa
    return 0.0;
  }
  public double calculateVolume()
  {
    // area of circle * height
    return 3.14*this.radius*this.height;
  }

}
