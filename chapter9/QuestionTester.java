public class QuestionTester
{
  public static void main(String[] args)
  {
    Question q1 = new Question();
    q1.setQuestion("How old are you?");
    q1.setAnswer("I am as old as I feel");
    q1.display();
    System.out.println("your answer is: " + q1.checkAnswer("i am as old as i feel"));

    ChoiceQuestion cq1 = new ChoiceQuestion();
    cq1.setQuestion("What is 2*2?");
    cq1.addChoice("4", true);
    cq1.addChoice("2", false);
    cq1.addChoice("3", false);
    cq1.addChoice("0", false);
    cq1.display();
    System.out.println("your answer is: " + cq1.checkAnswer("4"));
  }
}
