/*
P21
Search for elements in a table
*/

// TODO : fix some bugs with the searching of bond number, bond energy , and bond length 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class P21
{
  public static void main(String[] args)
  {
    try
    {
      Map<String, ArrayList<Double>> chemicals = new HashMap<String, ArrayList<Double>>();
      Scanner in = new Scanner(new File("p21_data.txt"));
      in.nextLine(); // skip first line

      while(in.hasNext())
      {
        String chemical_bond_num = String.valueOf(in.next());
        Double chemical_bond_energy = Double.valueOf(in.next());
        Double chemical_bond_length = Double.valueOf(in.next());
        ArrayList<Double> nums = new ArrayList<Double>();
        nums.add(chemical_bond_energy);
        nums.add(chemical_bond_length);
        chemicals.put(chemical_bond_num, nums);
      }

      // System.out.println(chemicals);
      System.out.println("\t 1. bond numbers");
      System.out.println("\t 2. bond energy ");
      System.out.println("\t 3. bond length");
      System.out.println("\t q. quit");
      System.out.print("how would you like to search data: ");
      in = new Scanner(System.in);
      String input = String.valueOf(in.next());
      while(!input.equals("q"))
      {
        // search by bond number
        if (input.equals("1"))
        {
          System.out.println("Searching by bond number");
          System.out.print("Required Info: [chemical composiition]: ");
          Scanner get = new Scanner(System.in);
          String bond_num = String.valueOf(get.next()).toUpperCase();
          System.out.println("Searching for: " + bond_num);

          // search in hasmap
          Map<String, ArrayList<Double>> found_elemets = new HashMap<String, ArrayList<Double>>();
          Set<String> chems = new HashSet<String>();
          for (String chem : chems)
          {
            if (chem == bond_num)
            {
              found_elemets.put(chem, chemicals.get(chem));
            }
          }

          System.out.printf("found theses data entries\n");
          System.out.println(found_elemets);
        }
        // search by bond energy
        else if (input.equals("2"))
        {
          System.out.println("Searching by bond energy");
          System.out.print("Required Info: [bond energy](kJ/mol): ");
          Scanner get = new Scanner(System.in);
          Double bond_e = Double.valueOf(get.nextDouble());

          System.out.println("Searching for: " + bond_e);

          // search hashmap
          Map<String, ArrayList<Double>> found_elemets = new HashMap<String, ArrayList<Double>>();
          Set<String> chems = chemicals.keySet();
          for (String chem:chems)
          {
            ArrayList<Double> nums = chemicals.get(chem);
            Double bond_energy = nums.get(0);
            if (bond_energy == bond_e)
            {
              found_elemets.put(chem, nums);
            }
          }

          System.out.print("found these elements with corresponding bond energy: ");
          System.out.println(found_elemets);

        }
        // search by bond length
        else if (input.equals("3"))
        {
          System.out.println("Searching by bond length");
          System.out.print("Required Info: [bong length](nm): ");
          Scanner get = new Scanner(System.in);
          Double bond_l = Double.valueOf(get.nextDouble());

          System.out.println("Searching for: " + bond_l);

          // search hashmap
          Map<String, ArrayList<Double>> found_elemets = new HashMap<String, ArrayList<Double>>();
          Set<String> chems = chemicals.keySet();
          for (String chem:chems)
          {
            ArrayList<Double> nums = chemicals.get(chem);
            Double bond_length = nums.get(1);
            if (bond_length == bond_l)
            {
              found_elemets.put(chem, nums);
            }
          }

        }
        else
        {
          System.out.println("invalid input");
        }

        // reprompt user for activity
        System.out.println("\t 1. bond numbers");
        System.out.println("\t 2. bond energy ");
        System.out.println("\t 3. bond length");
        System.out.println("\t q. quit");
        System.out.print("how would you like to search data: ");
        in = new Scanner(System.in);
        input = String.valueOf(in.next());
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    catch(NoSuchElementException e)
    {
      System.out.println(e.getMessage());
    }

  }
}
