import java.util.Stack;
import java.util.Scanner;

/**
algorithm(Algebraic Expression):
if you red a number
  to to number stack
else if you read "("
  push to operation stack
else if you read an operation
  whle to has higher precedence than op
    evaluateTheTop()
  pushoperation to operator stack
else if you read ")"
  while top of stack is not "("
    evaluateTheTop()
  pop "("
else if no more inputs
  while operator stack not empty
      evaluateTheTop()

algorithm(EvaluateTheTop()):
  pop 2 numbers off of number stack
  pop operator off operator stack
  combine numbers with operator
  push result to number stack
*/
public class AlgebraicExpressions
{

  public static Stack<Integer> num_stk = new Stack<Integer>();
  public static Stack<String> op_stk = new Stack<String>();

  public static String expression = "3+4";
  public static Scanner in = new Scanner(expression);

  public static void main(String[] args)
  {

    // TODO:implement algebraic expression
    // figure out how to read numbers from expression
    // figure out how to read operations from expressions


  }

  public static void evaluate_the_top()
  {
    if (num_stk.size() >= 2 && op_stk.size() >= 1)
    {
      Integer num1 = num_stk.pop();
      Integer num2 = num_stk.pop();
      String op = op_stk.pop();
      // TODO: add more operations
      if (op.equals("+"))
      {
        num_stk.push(num1+num2);
      }
      else if (op.equals("-"))
      {
        num_stk.push(num1-num2);
      }
    }
  }

}
