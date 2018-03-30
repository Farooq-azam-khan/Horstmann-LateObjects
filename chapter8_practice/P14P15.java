/*
P8.14
Write static methods:
• public static double sphereVolume(double r)
• public static double sphereSurface(double r)
• public static double cylinderVolume(double r, double h)
• public static double cylinderSurface(double r, double h)
• public static double coneVolume(double r, double h)
• public static double coneSurface(double r, double h)
that compute the volume and surface area of a sphere with a radius r, a cylinder with
a circular base with radius r and height h, and a cone with a circular base with radius r
and height h. Place them into a class Geometry.
Then write a program that prompts the
user for the values of r and h, calls the six methods, and prints the results.

P8.15
Solve Exercise P8.14 by implementing classes Sphere, Cylinder, and Cone. Which
approach is more object-oriented?
*/

public class P14P15
{
  public static void main(String[] args)
  {
    double r = 10;
    double h = 100;
    System.out.println("r: " + r +" h: "+ h);
    System.out.println("----------------------");
    System.out.printf("sphere(V):     %10.2f units^3\n",  Sphere.sphereVolume(r));
    System.out.printf("sphere(SA):    %10.2f units^2\n",  Sphere.sphereSurface(r));
    System.out.printf("cylinder(V):   %10.2f units^3\n",  Cylinder.cylinderVolume(r, h));
    System.out.printf("cylinder(SA):  %10.2f units^2\n",  Cylinder.cylinderSurface(r, h));
    System.out.printf("cone(V):       %10.2f units^3\n",  Cone.coneVolume(r, h));
    System.out.printf("cone(SA):      %10.2f units^2\n",  Cone.coneSurface(r, h));

    Sphere sph = new Sphere(r);
    Cylinder cyl = new Cylinder(r, h);
    Cone con = new Cone(r, h);

    System.out.printf("sphere(V):     %10.2f units^3\n", sph.getVolume());
    System.out.printf("sphere(SA):    %10.2f units^2\n", sph.getSurfaceArea());
    System.out.printf("cylinder(V):   %10.2f units^3\n", cyl.getVolume());
    System.out.printf("cylinder(SA):  %10.2f units^2\n", cyl.getSurfaceArea());
    System.out.printf("cone(V):       %10.2f units^3\n", con.getVolume());
    System.out.printf("cone(SA):      %10.2f units^2\n", con.getSurfaceArea());
  }
}

class Sphere
{
  private double r;
  public Sphere(double r)
  {
    this.r = r;
  }

  public double getVolume()
  {
    return (4.0/3.0)*Math.PI*this.r*this.r*this.r;
  }
  public double getSurfaceArea()
  {
    return 4.0*Math.PI*this.r*this.r;
  }

  public static double sphereVolume(double r)
  {
    return (4.0/3.0)*Math.PI*r*r*r;
  }
  public static double sphereSurface(double r)
  {
    return 4.0*Math.PI*r*r;
  }
}

class Cylinder
{
  private double r;
  private double h;
  public Cylinder(double r, double h)
  {
    this.r = r;
    this.h = h;
  }

  public double getVolume()
  {
    return Math.PI*this.r*this.r*this.h;
  }
  public double getSurfaceArea()
  {
    return 2*Math.PI*this.r*this.r + this.h*2*this.r*Math.PI;
  }
  public static double cylinderVolume(double r, double h)
  {
    return Math.PI*r*r*h;
  }
  public static double cylinderSurface(double r, double h)
  {
    return 2*Math.PI*r*r + h*2*r*Math.PI;
  }
}

class Cone
{
  private double r;
  private double h;
  public Cone(double r, double h)
  {
    this.r = r;
    this.h = h;
  }

  public double getVolume()
  {
    return (1.0/3.0) * Math.PI*this.r*this.r*this.h;
  }
  public double getSurfaceArea()
  {
    return Math.PI * this.r * (this.r + Math.sqrt(this.h*this.h+this.r*this.r) );
  }
  public static double coneVolume(double r, double h)
  {
    return (1.0/3.0) * Math.PI*r*r*h;
  }
  public static double coneSurface(double r, double h)
  {
    return Math.PI * r * (r + Math.sqrt(h*h+r*r) );
  }
}
