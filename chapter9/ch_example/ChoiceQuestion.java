import java.util.ArrayList;

public class ChoiceQuestion extends Question
{
  private ArrayList<String> choices;
  public ChoiceQuestion()
  {
    choices = new ArrayList<String>();
  }
  public void addChoice(String choice, boolean isCorrect)
  {
    choices.add(choice);

    if (isCorrect)
    {
      super.setAnswer(choice); 
    }
  }

  public void display()
  {
    int i=0;
    System.out.println(super.getQuestion());
    for (String choice : choices)
    {
      i++;
      System.out.println(i + ") " + choice);
    }
  }
}
