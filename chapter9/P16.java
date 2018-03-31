/*
P9.16
Write a method
public static Measurable maximum(Measurable[] objects)
that returns the object with the largest measure. Use that method to determine the
country with the largest area from an array of countries.
*/
public class P16
{
  public static void main(String[] args)
  {
    Country[] countries = new Country[5];
    countries[0] = new Country("usa", 100.0);
    countries[1] = new Country("australia", 200.0);
    countries[2] = new Country("canada", 300.0);
    countries[3] = new Country("india", 400.0);
    countries[4] = new Country("russia", 500.0);

    System.out.println("max area: " + maximum(countries).getMeasure());
  }
  public static Measurable maximum(Measurable[] objects)
  {
    Measurable max = objects[0];
    for (Measurable obj : objects)
    {
      if (obj.getMeasure() > max.getMeasure())
      {
        max = obj;
      }
    }

    return max;
  }
}

class Country implements Measurable
{
  private double area;
  private String name;
  Country(String name, double area)
  {
    this.name = name;
    this.area = area;
  }

  public double getMeasure()
  {
    return this.area;
  }
}

interface Measurable
{
  double getMeasure();
}
