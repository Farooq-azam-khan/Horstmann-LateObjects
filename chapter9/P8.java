/*
P9.8
Implement a superclass Person.
Make two classes, Student and Instructor, that inherit
from Person. A person has a name and a year of birth.
A student has a major, and an instructor has a salary.
Write the class declarations, the constructors, and the methods toString for all classes.
Supply a test program that tests these classes and methods.
*/

public class P8
{
  public static void main(String[] args)
  {
    Person p1 = new Person("jamal", 1970);
    Person p2 = new Instructor("harry", 1975, 40000);
    Student p3 = new Student("khan", 1995, "computer science");

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
  }
}

class Instructor extends Person
{
  private double salary;
  public Instructor(String name, int birth_year, double salary)
  {
    super(name, birth_year);
    this.salary = salary;
  }
  public Instructor(){}
  public void setSalary()
  {
    this.salary = salary;
  }
  public double getSalary()
  {
    return this.salary;
  }

  public String toString()
  {
    return getClass().getName()+ "["+super.toString()+" salary:"+ this.salary+"]";
  }

}
class Student extends Person
{
  private String major;
  public Student(String name, int birth_year, String major)
  {
    super(name, birth_year);
    this.major = major;
  }
  public Student(){}

  public void setMajor()
  {
    this.major = major;
  }

  public String getMajor()
  {
    return this.major;
  }
  public String toString()
  {
    return getClass().getName()+ "["+super.toString()+" major:"+ this.major+"]";
  }

}
class Person
{
  private String name;
  private int birth_year;

  public Person()
  {

  }
  public Person(String name)
  {
    this.name = name;
  }
  public Person(String name, int birth_year)
  {
    this.name = name;
    this.birth_year = birth_year;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setBirthYear(int year)
  {
    this.birth_year = year;
  }
  public String getName()
  {
    return this.name;
  }
  public int getBirthYear()
  {
    return this.birth_year;
  }

  public String toString()
  {
    return getClass().getName() + "[name:"+this.name+" birth_year: "+this.birth_year+"]";
  }

}
