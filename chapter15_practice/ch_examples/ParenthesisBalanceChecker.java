import java.util.Stack;

public class ParenthesisBalanceChecker
{
  public static String expression = "-{[b*b-(4*a*c)]/(2*a)}";
  public static void main(String[] args)
  {
    Stack<String> paren = new Stack<String>();
    int exp_len = expression.length(); // lenght of expression (for looping)
    boolean isBalanced = true;

    System.out.println("exp: " + expression);
    for (int i=0; i<exp_len; i++)
    {
      String ch = String.valueOf(expression.charAt(i));
      // check for opening parenthesis
      if (ch.equals("{") || ch.equals("(") || ch.equals("["))
      {
        System.out.println("found "+ ch+ " adding to stack");
        paren.push(ch);
      }
      else if (ch.equals("}") && (!paren.pop().equals("{")|| paren.isEmpty()))
      {
        isBalanced = false;
        break;
      }
      else if (ch.equals(")") && (!paren.pop().equals("(")|| paren.isEmpty()))
      {
        isBalanced = false;
        break;
      }
      else if (ch.equals("]") && (!paren.pop().equals("[")|| paren.isEmpty()))
      {
        isBalanced = false;
        break;
      }
    }
    if (paren.isEmpty())
    {
      System.out.println("Balanced");
    }
    else
    {
      System.out.println("Unbalanced");
    }
  }
}
