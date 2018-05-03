/*
P8.12
Write a class Bug that models a bug moving along a horizontal line. The bug moves
either to the right or left. Initially, the bug moves to the right, but it can turn to
change its direction. In each move, its position changes by one unit in the current
direction. Provide a constructor
public Bug(int initialPosition)
and methods
• public void turn()
• public void move()
• public int getPosition()
*/

public class P12
{
  public static void main(String[] args)
  {
    Bug bug = new Bug(10);
    System.out.println("initial position: " + bug.getPosition());
    for (int i=0; i<10; i++)
    {
      bug.move();
    }
    System.out.println("position: " + bug.getPosition());

    bug.turn();
    for (int i=0; i<10; i++)
    {
      bug.move();
    }
    System.out.println("position: " + bug.getPosition());
  }
}

class Bug
{
  private int pos;
  private int direction;
  public Bug(int initial_position)
  {
    this.pos = initial_position;
    this.direction = 1;
  }

  public void turn()
  {
    this.direction *= -1;
  }

  public void move()
  {
    this.pos += this.direction;
  }

  public int getPosition()
  {
    return this.pos;
  }
}
