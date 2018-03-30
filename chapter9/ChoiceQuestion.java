import java.util.ArrayList;

public class ChoiceQuestion extends Question
{
  private int choices;
  private ArrayList<String> question_choices;
  public ChoiceQuestion()
  {
    this.choices = 0;
    question_choices = new ArrayList<String>();
  } // end of constructor method

  public void addChoice(String choice, boolean isCorrect)
  {
    question_choices.add(choice);
    if (isCorrect)
    {
      super.setAnswer(choice);
    }
  }


  public void addText(String choice, boolean isChoice)
  {
    choices++;
    super.addText("\n choice: "+ choices + "): " + choice);
    if(isChoice)
    {
      super.setAnswer(choice);
    }
  }

  public void display()
  {
    System.out.println(getQuestion());
    System.out.println("will display this: " + question_choices);
    int i=0;
    for (String choice : question_choices)
    {
      i++;
      System.out.println(i+ ") " + choice);
    }
  }

  public void displayQuestionText()
  {
    System.out.println(getQuestion());
  }

  public String toString()
  {
    return getClass().getName() + " " + super.getQuestion(); 
  }
}
