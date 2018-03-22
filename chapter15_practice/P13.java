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
  public static String fileName = "war-and-peace.txt"; // file to use

  public static void main(String[] args)
  throws FileNotFoundException
  {
    // timer starts
    long startTime_ts = System.currentTimeMillis();
    // use tree set
    testTreeSet();
    // timer ends
    long endTime_ts = System.currentTimeMillis();
    System.out.println("treeSet took " + (endTime_ts - startTime_ts)*0.001 + " seconds");

    long startTime_hs = System.currentTimeMillis();
    // use hash set
    testHashSet();
    long endTime_hs = System.currentTimeMillis();
    System.out.println("hashSet took " + (endTime_hs - startTime_hs)*0.001 + " seconds");
  }


  public static void testTreeSet()
  throws FileNotFoundException
  {
    // load tree set
    Set<String> tree_set = new TreeSet<String>();
    // load file
    Scanner in = new Scanner(new File(fileName));
    // separates words
    in.useDelimiter("[^a-zA-Z]+");

    System.out.println("adding words to tree set");
    while(in.hasNext())
    {
      // add each word
      String word = in.next();
      tree_set.add(word);
    }
    System.out.println("finished adding "+tree_set.size()+" words to tree set");
  }

  public static void testHashSet() throws FileNotFoundException
  {
    Set<String> hash_set = new HashSet<String>();
    Scanner in = new Scanner(new File(fileName));
    in.useDelimiter("[^a-zA-Z]+"); // separates words

    System.out.println("adding words to hash set");
    while(in.hasNext())
    {
      // add each word
      String word = in.next();
      hash_set.add(word);
    }
    System.out.println("finished adding "+hash_set.size()+" words to hash set");
  }
}
