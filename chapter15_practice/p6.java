/*
15.6 Implement a to do list. Tasks have a priority between 1 and 9, and a description.
When the user enters the command add priority description, the program adds a new
task. When the user enters next, the program removes and prints the most urgent
task. The quit command quits the program. Use a priority queue in your solution.
*/

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
public class P6
{
  public static void main(String[] args)
  {
    try
    {
      Queue<ToDoList> todoList = new PriorityQueue<ToDoList>();
      System.out.println("What would you like to do: ");
      System.out.println("\t add: add a new activity todo");
      System.out.println("\t next: get the most urget task");
      System.out.println("\t q: quit");
      Scanner in = new Scanner(System.in);
      String input = in.next();
      while (!input.equals("q"))
      {
        // add a task
        if (input.equals("add"))
        {
          // get activity
          System.out.print("Activity description: ");
          Scanner get_activity = new Scanner(System.in);
          String description = get_activity.nextLine();

          // get priority
          System.out.print("Priority(1-9):  ");
          Integer priority = Integer.valueOf(get_activity.nextInt());

          todoList.add(new ToDoList(priority, description));

          System.out.print("your activity of: " + description +
          " with priority of " + priority );
          System.out.println(" was added to queue");

          System.out.println("priority queue: " + todoList);
        }

        // show next task
        else if (input.equals("next"))
        {
          System.out.println("you next task is: " );
          System.out.println(todoList.remove());
          System.out.println("priority queue: " + todoList);
        }

        System.out.println("What else would you like to do: ");
        System.out.println("\t add: add a new activity todo");
        System.out.println("\t next: get the most urget task");
        System.out.println("\t q: quit");
        in = new Scanner(System.in);
        input = in.next();
      }

    }
    catch (InputMismatchException e)
    {
      System.out.println(e.getMessage());
    }
    catch (NoSuchElementException e)
    {
      System.out.println(e.getMessage());
    }


  }
}

class ToDoList implements Comparable<ToDoList>
{
  private String activity;
  private Integer priority;
  ToDoList(Integer priority, String activity)
  {
    this.activity = activity;
    this.priority = priority;
  }
  public Integer getPriority()
  {
    return this.priority;
  }
  public String toString()
  {
    return this.priority+": "+this.activity;
  }

  public int compareTo(ToDoList other)
  {
    if (this.priority>other.getPriority()) { return 1; }
    else if (this.priority<other.getPriority()) {return -1; }
    else {return 0; }
  }
}
