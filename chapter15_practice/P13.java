/*
Insert all words from a large file (such as the novel "War and Peace", which is available
on the Internet) into a hash set and a tree set. Time the results. Which data
structure is faster?
*/

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P13
{
  public static String fileName = "war-and-peace.txt";
  public static void main(String[] args)
  throws FileNotFoundException
  {
    long startTime_ts = System.currentTimeMillis();
    testTreeSet();
    long endTime_ts = System.currentTimeMillis();
    System.out.println("treeSet took " + (endTime_ts - startTime_ts)*0.001 + " seconds");

    long startTime_hs = System.currentTimeMillis();
    testHashSet();
    long endTime_hs = System.currentTimeMillis();
    System.out.println("hashSet took " + (endTime_hs - startTime_hs)*0.001 + " seconds");


  }
  public static void testTreeSet()
  throws FileNotFoundException
  {
    Set<String> tree_set = new TreeSet<String>();
    Scanner in = new Scanner(new File(fileName));
    in.useDelimiter("[^a-zA-Z]+"); // separates words

    System.out.println("adding words to hash set");
    while(in.hasNext())
    {
      String word = in.next();
      tree_set.add(word);
    }
    System.out.println("finished adding "+tree_set.size()+" words to hash set");

  }

  public static void testHashSet() throws FileNotFoundException
  {
    Set<String> hash_set = new HashSet<String>();
    Scanner in = new Scanner(new File(fileName));
    in.useDelimiter("[^a-zA-Z]+"); // separates words

    System.out.println("adding words to hash set");
    while(in.hasNext())
    {
      String word = in.next();

      hash_set.add(word);
    }
    System.out.println("finished adding "+hash_set.size()+" words to hash set");
  }
}
