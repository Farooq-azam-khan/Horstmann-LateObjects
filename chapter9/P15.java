/*
P9.15
A person has a name and a height in centimeters.
Use the average method in Section 9.6 to process a collection of Person objects.
*/
public class P15
{
  public static void main(String[] args)
  {
    Person[] ppl = new Person[5];
    ppl[0] = new Person("danny", 10.0);
    ppl[1] = new Person("danny", 10.0);
    ppl[2] = new Person("danny", 10.0);
    ppl[3] = new Person("danny", 10.0);
    ppl[4] = new Person("danny", 10.0);

    System.out.println("avg height: " + average(ppl)); 
  }
  public static double average(Person[] people)
  {
    if (people.length == 0){return 0.0;}
    int sum = 0;
    for (Person p : people)
    {
      sum+=p.getHeight();
    }
    return sum/(double)(people.length);
  }
}

class Person
{
  private String name;
  private double height;
  Person(String name, double height)
  {
    this.name = name;
    this.height = height;
  }
  public double getHeight()
  {
    return this.height;
  }
}
