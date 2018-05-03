/*
15.5 A homeowner rents out parking spaces in a driveway during special events.
The driveway is a "last-in, first-out" stack.
 Of course, when a car owner retrieves a vehicle that wasn’t the last one in,
 the cars blocking it must temporarily move to the street so
 that the requested vehicle can leave. Write a program that models this
behavior, using one stack for the driveway and one stack for the street.
Use integers as license plate numbers.
Positive numbers add a car, negative numbers remove a car, zero stops the simulation.
Print out the stack after each operation is complete.
*/

import java.util.Stack;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.EmptyStackException;

public class P5
{
  public static void main(String[] args)
  {
    Stack<Integer> driveway = new Stack<Integer>();
    Stack<Integer> street = new Stack<Integer>();

    // fill driveway stack for testing
    driveway.add(1);
    driveway.add(2);
    driveway.add(3);
    driveway.add(10);
    driveway.add(20);
    System.out.println("driveway: " + driveway);

    System.out.println("what is your licence plate number: ");
    try
    {
      Scanner in = new Scanner(System.in);
      Integer input = Integer.valueOf(in.nextInt());

      while (input != 0)
      {
        System.out.println("input: " + input);
        if (driveway.isEmpty())
        {
          System.out.println("no cars here");
          break;
        }
        if (input != driveway.peek())
        {
          System.out.println("have to remove other cars first");
          // remove other cars
          while(input != driveway.peek())
          {
            street.add(driveway.pop());
          }
          // if car found then pop it and add the ones in the street back to driveway
          if (input == driveway.peek())
          {
            System.out.println("found your car: " + driveway);
            driveway.pop();
            System.out.println("removed your car");

            while(!street.isEmpty())
            {
              System.out.println("add " + street.peek() + " back to driveway");
              driveway.add(street.pop());
            }
            System.out.println("driveway without "+input+": " + driveway);
          }
          else
          {
            System.out.println("car not in driveway");
          }
        }
        else
        {
          System.out.println("your car has been removed");
          driveway.pop();
        }

        System.out.println("what is your licence plate number: ");
        in = new Scanner(System.in);
        input = Integer.valueOf(in.nextInt());
      }

    }
    catch (NoSuchElementException e)
    {
      System.out.println(e.getMessage());
    }
    catch (EmptyStackException e)
    {
      System.out.println(e.getMessage());
    }

  }
}
