/*
P8.1
We want to add a button to the tally counter in Section  8.2 that allows an
operator to undo an accidental button click. Provide a method
public void undo() that simulates such a button.
As an added precaution, make sure that the operator
cannot click the undo button more often than the count button.

P8.2 Simulate a tally counter that can be used to admit a
limited number of people. First, the limit is set with a call
public void setLimit(int maximum)
If the count button was clicked more often than the limit, simulate an alarm by
printing out a message "Limit exceeded".


*/
public class P1andP2
{
  public static void main(String[] args)
  {
    Counter tally = new Counter();
    tally.setLimit(5);

    for (int i=0; i<10; i++)
    {
      tally.count();
    }
    System.out.println(tally.getC());
    for (int i=0; i<15; i++)
    {
      tally.undo();
    }

  }
}

class Counter
{
  private int c;
  private String stroke;
  private int limit;

  Counter()
  {
    c = 0;
    stroke = "";
  }
  public void count()
  {
    if (c>=limit)
    {
      c++;
      stroke += "|";
    }
    else
    {
      System.out.println("Limit exceeded");
    }


  }
  public int getC()
  {
    return c;
  }
  public String getStroke()
  {
    return stroke;
  }
  public void reset()
  {
    c = 0;
    stroke = "";
  }
  public void resetCount()
  {
    c = 0;
  }
  public void resetStroke()
  {
    stroke = "";
  }

  // undo button
  public void undo()
  {
    if(c>0)
    {
      c--;
    }
    else
    {
      System.out.println("count cannot go past zero.");
    }
  }
  // p2 set limit
  public void setLimit(int max_limit)
  {
    limit = max_limit;
  }
}
