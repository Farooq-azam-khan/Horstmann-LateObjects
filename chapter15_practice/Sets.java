// import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator; 
public class Sets
{
  public static void main(String[] args)
  {
    Set<String> ts_names = new TreeSet<String>();
    Set<Integer> hs_age = new HashSet<Integer>();

    ts_names.add("harry potter");
    ts_names.add("hermionie graner");
    ts_names.add("ron weasly");
    ts_names.add("hogwarts");

    hs_age.add(11);
    hs_age.add(11);
    hs_age.add(11) ;
    hs_age.add(1000);

    System.out.println(ts_names);
    System.out.println(hs_age);

    System.out.println("removed hogwarts not a person");

    ts_names.remove("hogwarts");
    hs_age.remove(1000);
    ts_names.remove("reomve nonexistent element");
    hs_age.remove(20);


    System.out.println(ts_names);
    System.out.println(hs_age);

    // add some random elements
    ts_names.add("nevil longbotton");
    ts_names.add("voldemort");
    ts_names.add("draco malfoy");
    ts_names.add("nagini");
    ts_names.add("the dark army");

    hs_age.add(13);
    hs_age.add(50);
    hs_age.add(15);
    hs_age.add(40);
    hs_age.add(30);

    // for each loop
    for(String name : ts_names)
    {
      System.out.println("for each: " + name);
    }
    // for each loop
    for(Integer age : hs_age)
    {
      System.out.println("for each: " + age);
    }

    Iterator iter = ts_names.iterator();
    while (iter.hasNext())
    {
      System.out.println("iterator: " + iter.next());
    }

    Iterator hs_iter = hs_age.iterator();
    while(hs_iter.hasNext())
    {
      System.out.println("iterator: " + hs_iter.next());
    }
  }



}
