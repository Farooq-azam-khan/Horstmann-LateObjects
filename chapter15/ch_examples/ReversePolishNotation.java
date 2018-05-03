import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation
{
  public static Stack<Integer> stack = new Stack<Integer>();
  // public static Scanner in = new Scanner(polish_expression);
  public static String polish_expression = "3 11 +";

  public static void main(String[] args)
  {
    // TODO: make it so that it works with arbritrary number of arguments
    // currently args is equal to 3 at max, 2 for the numbers and one for the operation
    // thus need to implment the stack
    Integer num1 = 0;
    Integer num2 = 0;
    String operation = "+";
    if (args.length == 3)
    {
      num1 = Integer.valueOf(args[0]);
      num2 = Integer.valueOf(args[1]);
      System.out.println("arg 0: " + args[0] + " arg 1: " + args[1] + " arg 2: " + args[2]);
      boolean isValidOperation = checkOperationValidity(args[2]);
      if (isValidOperation)
      {
        operation = String.valueOf(args[2].trim());
        // System.out.println("welcome your inputs are: " + num1 + " " + num2 + " " + operation);
      }
      else
      {
        System.out.println("executing this else clause");
        usage();
        System.exit(0);
      }
    }
    else
    {
      usage();
      System.exit(0);
    }

    Integer ans = performPolishOperation(num1, num2, operation);
    System.out.println("answer = " + ans);

  }

  public static Integer performPolishOperation(Integer num1, Integer num2, String operation)
  {
    if (operation.equals("+"))
    {
      return num1 + num2;
    }
    else if (operation.equals("-"))
    {
      return num1 - num2;
    }
    else if (operation.equals("x"))
    {
      return num1 * num2;
    }
    else if(operation.equals("/"))
    {
      if (num2 == 0)
      {
        return 1;
      }
      else
      {
        return num1 / num2;
      }
    }

    else
    {
      return pow(num1, num2);
    }

  }

  public static boolean checkOperationValidity(String op)
  {
    if (op.equals("+")||op.equals("-")||op.equals("x")||op.equals("/")||op.equals("exp"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public static Integer pow(Integer base, Integer power)
  {
    Integer ans = 1;
    for (int i=0; i<power; i++)
    {
      ans*=base;
    }
    return ans;
  }
  public static void usage()
  {
    System.out.println("[num1] [num2] [operation(+,-,/,x,exp)]");
  }
}
