public class QuestionTester
{
  public static void main(String[] args)
  {
    Question q1 = new Question();
    q1.setQuestion("How old are you?");
    q1.setAnswer("I am as old as I feel");
    q1.display();
    System.out.println("your answer is: " + q1.checkAnswer("i am as old as i feel")); 
  }
}
