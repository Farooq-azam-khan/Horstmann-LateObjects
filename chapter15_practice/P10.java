/*
15.10
Reimplement Exercise P15.9 so that the keys of the map are objects of class Student.
A student should have a first name, a last name, and a unique integer ID. For grade
changes and removals, lookup should be by ID. The printout should be sorted
by last name. If two students have the same last name, then use the first name as a
tie breaker. If the first names are also identical, then use the integer ID. Hint: Use
two maps.
*/

import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class P10
{

  public static void main(String[] args)
  {
    Map<Integer, Student> students = new TreeMap<Integer, Student>();
    Map<Student, String> studentsRanks = new TreeMap<Student, String>();
    // added some test cases
    Student gauss = new Student("friedrich", "gauss");
    Student leibniz = new Student("dontknow", "leibniz");
    Student euler = new  Student("euler", "euler");
    Student newton = new Student("issac", "newton");
    students.put(gauss.getID(), gauss);
    students.put(leibniz.getID(), leibniz);
    students.put(euler.getID(), euler);
    students.put(newton.getID(), newton);

    studentsRanks.put(gauss, "A+");
    studentsRanks.put(leibniz, "A++");
    studentsRanks.put(euler, "A+");
    studentsRanks.put(newton, "A+++");
    // System.out.println(studentsRanks);

    try
    {
      // what the user can do:
      // add / remove student
      // modify grades
      // print all grades
      System.out.println("\t 1. add student");
      System.out.println("\t 2. remove student");
      System.out.println("\t 3. modify grade");
      System.out.println("\t 4. print all grades");

      System.out.println("\t q. quit");
      System.out.print("What would you like to do: ");

      Scanner in = new Scanner(System.in);
      String user_action = in.next();

      while (!user_action.equals("q"))
      {
        if (user_action.equals("1"))
        {
          System.out.println("user want to add student");
          System.out.print("info needed: ");
          System.out.println("student [first_name] [last_name] and [grade]");
          System.out.println("---------------------");
          System.out.printf("first name: ");
          Scanner get_info = new Scanner(System.in);
          String fname = get_info.next();

          System.out.printf("last name: ");
          get_info = new Scanner(System.in);
          String lname = get_info.next();


          System.out.printf("grade: ");
          get_info = new Scanner(System.in);
          String grade = get_info.next();

          System.out.println("adding/modifying: " + fname + " " + lname + " with grade: "+ grade);
          studentsRanks.put(new Student(fname, lname), grade);
        }

        else if (user_action.equals("2"))
        {
          System.out.println("user want to remove student");
          System.out.println("info needed: student [id]");
          System.out.println("---------------------");
          System.out.printf("id: ");
          Scanner get_info = new Scanner(System.in);
          Integer id = Integer.valueOf(get_info.nextInt());

          // find the student with that id
          Set<Integer> students_id_set = students.keySet();
          for (Integer student_id : students_id_set)
          {
            if (student_id == id)
            {
              // remove him/her
              studentsRanks.remove(students.get(student_id));
            }
          }
        }

        else if (user_action.equals("3"))
        {
          System.out.println("user want to modify grade");
          System.out.println("info needed: student [id] [new_grade]");
          System.out.println("---------------------");

          // get id
          System.out.printf("id: ");
          Scanner get_info = new Scanner(System.in);
          Integer id = Integer.valueOf(get_info.nextInt());

          // get new grade
          System.out.printf("new grade: ");
          get_info = new Scanner(System.in);
          String new_grade = get_info.nextLine();

          // find the student with that id
          Set<Integer> students_id_set = students.keySet();
          for (Integer student_id : students_id_set)
          {
            if (student_id == id)
            {
              // modify him/her
              studentsRanks.put(students.get(student_id), new_grade);
            }
          }
        }

        else if (user_action.equals("4"))
        {
          System.out.println("user want to print map");
          System.out.println("---------------------");
          Set<Student> student_set = studentsRanks.keySet();
          for (Student student : student_set)
          {
            System.out.println(student + ": " + studentsRanks.get(student));
          }
        }
        else
        {
          System.out.println("invalid input");
        }

        System.out.println("---------------------");
        System.out.print("What would you like to do: ");
        in = new Scanner(System.in);
        user_action = in.next();
      }
    }
    catch(NoSuchElementException e)
    {
      System.out.println(e.getMessage());
    }
  }


}

class Student implements Comparable<Student>
{
  private String fname;
  private String lname;
  private Integer id;
  static int count = 0; // keeps track of how many have been created

  Student(String fname, String lname)
  {
    count++; // increments count
    this.id = count; // represents the ith count
    this.fname = fname;
    this.lname = lname;
  }
  public String getLastName()
  {
    return this.lname;
  }
  public String getFirstName()
  {
    return this.fname;
  }
  public Integer getID()
  {
    return this.id;
  }

  public String toString()
  {
    return String.format("%s[id:%s fname:%s lname:%s]",
    this.getClass().getName(), this.id, this.fname, this.lname);
  }

  public int compareTo(Student other)
  {
    // check if last names are same
    if (this.lname.compareTo(other.getLastName()) == 0)
    {
      // sort by first name (if last name are same)
      if (this.fname.compareTo(other.getFirstName()) == 0)
      {
        // sort by id
        if (this.id<other.getID()) {return 1;}
        else if (this.id>other.getID()) {return -1;}
        else {return 0;}
      }
      else
      {
        return this.fname.compareTo(other.getFirstName());
      }
    }
    else
    {
      return this.lname.compareTo(other.getLastName());
    }
  }
}
