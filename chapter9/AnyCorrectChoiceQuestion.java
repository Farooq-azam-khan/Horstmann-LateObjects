
import java.util.ArrayList;

public class AnyCorrectChoiceQuestion extends ChoiceQuestion
{
  private ArrayList<String> correct_choices;
  public AnyCorrectChoiceQuestion()
  {
    correct_choices = new ArrayList<String>();
  }
  public void addChoice(String choice, boolean isCorrect)
  {
    super.addChoice(choice, isCorrect);
    if (isCorrect)
    {
      correct_choices.add(choice);
      // System.out.println("cc: " + correct_choices);
    }
  } // end of addChoice method

  public void displayAnswers()
  {
    System.out.println("answers: ");
    for (String c : correct_choices)
    {
      System.out.print(c + " ");
    }
    System.out.println("");
  }
  public boolean checkAnswer(String response)
  {
    return correct_choices.contains(response.toLowerCase());
  }
} // end of AnyCorrectChoiceQuestion class

class MultipleChoiceQuestion extends AnyCorrectChoiceQuestion
{

}
