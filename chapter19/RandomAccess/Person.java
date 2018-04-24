public class Person
{
  private int age;        // 4 bytes
  private double height;  // 8 bytes
  private double weight;  // 8 bytes

  //                  total: 20 bytes

  public Person(int age, double height, double weight)
  {
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  public double getWeight(){return this.weight; }
  public int getAge(){return this.age;}
  public double getHeight(){return this.height;}
  public String toString()
  {
    return String.format("%s[age: %d height: %.2f weight: %.2f]",
    getClass().getName(), age, height, weight);
  }
}
