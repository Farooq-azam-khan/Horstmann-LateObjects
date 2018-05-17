import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class StackQueue
{
  public static void main(String[] args)
  {
    Stack<String> animals = new Stack<String>();
    animals.push("dog");
    animals.push("cat");
    animals.push("lion");
    System.out.println(animals + " size: " + animals.size());

    animals.pop();
    System.out.println(animals);

    Queue<String> movies = new LinkedList<String>();
    movies.add("tarzan");
    movies.add("star wars");
    movies.add("black panther");

    System.out.println(movies);

    movies.remove();
    System.out.println(movies);

    PriorityQueue<String> test = new PriorityQueue<String>();
    test.add("this is a test");
    test.add("does this have priority?");
    test.add("hence testing");

    System.out.println(test);
    test.remove();
    System.out.println(test);

    PriorityQueue<WorkOrder> things_to_do = new PriorityQueue<WorkOrder>();
    things_to_do.add(new WorkOrder(1, "clean room"));
    things_to_do.add(new WorkOrder(1, "study for exams"));
    things_to_do.add(new WorkOrder(2, "take out garbage"));
    things_to_do.add(new WorkOrder(3, "cook"));


    System.out.println(things_to_do);

    System.out.println("should remove 'clean room': " + things_to_do.remove());
    System.out.println("'exams'?: " + things_to_do.remove());

  }

}

class WorkOrder implements Comparable<WorkOrder>
{
  private int priority;
  private String order;
  WorkOrder(int priority, String order)
  {
    this.priority = priority;
    this.order = order;
  }
  public int getPriority(){return this.priority;}
  public String toString(){return this.order; }

  public int compareTo(WorkOrder other)
  {
    if (this.priority>other.getPriority()){return 1;}
    else if (this.priority<other.getPriority()){return -1;}
    else return 0;
  }
}
