import java.util.Scanner;
import java.io.IOException;

public class PersonSimmulator
{
  public static void main(String[] args) throws IOException
  {
    try
    {
      PersonsData pd = new PersonsData();
      pd.open("personfile.p");

      boolean done = false;
      Scanner in = new Scanner(System.in);

      while(!done)
      {
        System.out.print("Age: ");
        int age = in.nextInt();
        System.out.print("Height: ");
        double height = in.nextDouble();
        System.out.print("Weight: ");
        double weight = in.nextDouble();

        Person p = new Person(age, height, weight);

        // find the position based on age
        int position = pd.find(p);
        if (position < 0)
        {
          System.out.println("person doesnt exists: " + position);
          System.out.println("adding... " + p + " at: " + pd.size());

          pd.write(pd.size(), p);
        }
        else
        {
          System.out.println(pd.read(age));
        }

        System.out.print("done(y/n): ");
        if (in.next().equals("y"))
        {
          done = true;
        }

      }

    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }

  }
}
