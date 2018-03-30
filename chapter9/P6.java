/*
P9.6
Add a method addText to the Question superclass and provide a different implementation
of ChoiceQuestion that calls addText rather than storing an array list of choices.
*/
public class P6
{
  public static void main(String[] args)
  {
    ChoiceQuestion cq2 = new ChoiceQuestion();
    cq2.setQuestion("What is d/dx of x^2?");
    cq2.addText("x", false);
    cq2.addText("2x", true);
    cq2.addText("1/2 * x", false);
    cq2.display();
    System.out.println("your answer is: " + cq2.checkAnswer("2x"));
    System.out.println("your answer is: " + cq2.checkAnswer("x"));
  }
}
