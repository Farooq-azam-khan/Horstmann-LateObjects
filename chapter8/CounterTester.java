public class CounterTester
{
  public static void main(String[] args)
  {
    Counter tally = new Counter();
    tally.count();
    tally.count();
    System.out.println(tally.getC());
    System.out.println(tally.getStroke());
    tally.reset();
    System.out.println(tally.getC() + " stroke: " + tally.getStroke());

    Counter steps = new Counter();
    System.out.println(steps.getC());

  }
}

class Counter
{
  private int c;
  private String stroke;
  Counter()
  {
    c = 0;
    stroke = "";
  }
  public void count()
  {
    c++;
    stroke += "|";
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
    c= 0;
  }
  public void resetStroke()
  {
    stroke = "";
  }
}
