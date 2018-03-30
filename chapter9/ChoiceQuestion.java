import java.util.ArrayList;

public class ChoiceQuestion extends Question
{
  private int choices;
  public ChoiceQuestion()
  {
    this.choices = 0;
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
  }
}
