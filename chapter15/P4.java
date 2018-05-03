/*
P15.4
Your task is to break a number into its individual digits, for example, to turn 1729
into 1, 7, 2, and 9. It is easy to get the last digit of a number n as n % 10. But that gets
the numbers in reverse order. Solve this problem with a stack. Your program should
ask the user for an integer, then print its digits separated by spaces.
*/

import java.util.Stack;
import java.util.Scanner;
public class P4
{
  public static void main(String[] args)
  {
    System.out.print("num: ");
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    Stack<Integer> digits = new Stack<Integer>();
    while(num!=0)
    {
      int digit = num % 10;
      digits.push(digit);
      num /= 10;
    }

    // this line is necessary because the for loop will recalculate stack size each time it checks
    int digits_size = digits.size();
    for (int i=0; i<digits_size; i++)
    {
      System.out.print(digits.pop() + " ");
    }

  }
}
