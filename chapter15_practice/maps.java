import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

public class maps
{
  public static void main(String[] args)
  {
    Map<String, ArrayList<Integer>> favNums = new HashMap<String, ArrayList<Integer>>();
    ArrayList<Integer> jnums = new ArrayList<Integer>();
    ArrayList<Integer> rnums = new ArrayList<Integer>();
    ArrayList<Integer> jsnums = new ArrayList<Integer>();
    jnums.add(10);
    jnums.add(20);
    jnums.add(200);
    jsnums.add(1);
    jsnums.add(200);
    jsnums.add(35);
    rnums.add(10);
    rnums.add(20);
    rnums.add(200);

    favNums.put("juliet", jnums);
    favNums.put("romeo", rnums);
    favNums.put("jon snow", jsnums);

    System.out.println(favNums);

    // removing: also removes key
    // favNums.remove("jon snow");
    // System.out.println(favNums);

    // keySet
    Set<String> key_set = favNums.keySet();
    System.out.println("key_set: " + key_set);

    for (String key : key_set)
    {
      System.out.println("(key, value): " + key + " " + favNums.get(key)); 
    }



  }
}
