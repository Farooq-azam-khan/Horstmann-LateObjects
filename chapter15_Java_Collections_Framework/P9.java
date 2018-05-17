/*
P9
Write a program that keeps a map in which both keys and
values are strings—the names of students and their course
grades. Prompt the user of the program to add or remove students, to modify grades,
or to print all grades. The printout should be sorted by name and formatted like this:
Carl: B+
Joe: C
Sarah: A
*/

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Set;

public class P9
{
  public static void main(String[] args)
  {
    Map<String, String> studentRank = new HashMap<String, String>();

    studentRank.put("Carl", "B+");
    studentRank.put("Joe", "C");
    studentRank.put("Sarah", "A");


    // what the user can do:
    // add / remove student
    // modify grades
    // print all grades
    System.out.println("1. add student/modify grades");
    System.out.println("2. remove student");
    System.out.println("3. print all grades");
    System.out.println("q. quit");
    System.out.print("What would you like to do: ");

    Scanner in = new Scanner(System.in);
    String user_action = in.next();

    while (!user_action.equals("q"))
    {
      if (user_action.equals("1"))
      {
        System.out.println("user want to add student");
        System.out.println("info needed: student [name] and [grade]");
        System.out.println("---------------------");
        System.out.printf("name: ");
        Scanner get_info = new Scanner(System.in);
        String name = get_info.next();
        System.out.printf("grade: ");
        get_info = new Scanner(System.in);
        String grade = get_info.next();
        System.out.println("adding/modifying: " + name + " with grade: "+ grade);
        studentRank.put(name, grade);
      }

      else if (user_action.equals("2"))
      {
        System.out.println("user want to remove student");
        System.out.println("info needed: student [name]");
        System.out.println("---------------------");
        System.out.printf("name: ");
        Scanner get_info = new Scanner(System.in);
        String name = get_info.next();
        studentRank.remove(name);
        System.out.println("removed "+ name);
      }
      else if (user_action.equals("3"))
      {
        System.out.println("user want to print map");
        System.out.println("---------------------");
        Set<String> student_set = studentRank.keySet();
        for (String student : student_set)
        {
          System.out.println(student + ": " + studentRank.get(student));
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
}
