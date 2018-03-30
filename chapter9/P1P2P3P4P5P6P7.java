/*
P9.1
Add a class NumericQuestion to the question hierarchy of Section 9.1.
If the response and the expected answer differ by no more than 0.01,
then accept the response as correct.

P9.2
Add a class FillInQuestion to the question hierarchy of Section 9.1.
Such a question is constructed with a string that contains the answer,
surrounded by _ _, for example,
"The inventor of Java was _James Gosling_". The question should be displayed as
The inventor of Java was _____.

P9.3
Modify the checkAnswer method of the Question class so that it does not
take into account different spaces or upper/lowercase characters.
For example, the response "JAMES gosling"
should match an answer of "James Gosling".

P9.4
Add a class AnyCorrectChoiceQuestion to the question hierarchy of
Section 9.1 that allows multiple correct choices.
The respondent should provide any one of the correct choices.
The answer string should contain all of the correct choices, separated by
spaces. Provide instructions in the question text.

P9.5
Add a class MultiChoiceQuestion to the question hierarchy of
Section 9.1 that allows multiple correct choices.
The respondent should provide all correct choices, separated
by spaces. Provide instructions in the question text.

P9.6
Add a method addText to the Question superclass and provide a
different implementation of ChoiceQuestion that calls addText
rather than storing an array list of choices.

P9.7 Provide toString methods for the Question and ChoiceQuestion classes.
*/

import java.util.Scanner;

public class P1P2P3P4P5P6P7
{
  public static void main(String[] args)
  {
    Scanner in;
    MultipleChoiceQuestion accq1 = new MultipleChoiceQuestion();
    in = new Scanner(System.in);
    accq1.addChoice("2", true);
    accq1.addChoice("8/4", true);
    accq1.addChoice("3", false);
    accq1.addChoice("2/3", false);
    accq1.addChoice("2/1", true);
    accq1.addChoice("2.1", false);
    accq1.setQuestion("what is 4/2?");
    accq1.display(); // must be called at the end when everything has been added to class

    if (in.hasNextLine())
    {
      String response = in.nextLine().trim();
      System.out.println("you gave: " + response);
      System.out.println("your response was: " + accq1.checkAnswer(response));
      if (accq1.checkAnswer(response))
      {
        accq1.displayAnswers();
      }

    }
    else
    {
      System.out.println("invalid response");
    }



    // ChoiceQuestion cq2 = new ChoiceQuestion();
    // cq2.setQuestion("What is d/dx of x^2?");
    // cq2.addText("x", false);
    // cq2.addText("2x", true);
    // cq2.addText("1/2 * x", false);
    // cq2.display();
    // System.out.println("your answer is: " + cq2.checkAnswer("2x"));
    // System.out.println("your answer is: " + cq2.checkAnswer("x"));
    //
    // NumericQuestion nq1 = new NumericQuestion();
    // nq1.setQuestion("what is 1/3?");
    // nq1.setAnswer(0.3333);
    //
    // nq1.display();
    //
    // if (in.hasNextDouble())
    // {
    //   double response = in.nextDouble();
    //   System.out.println("your answer is : " + nq1.checkAnswer(response));
    // }
    // else
    // {
    //   System.out.println("invalid answer");
    // }

    // FillInQuestion fq1 = new FillInQuestion();
    // fq1.setQuestion("The inventor of Java was");
    // fq1.setAnswer("James Gosling");
    // in = new Scanner(System.in);
    // fq1.displayQuestion();
    // if (in.hasNextLine())
    // {
    //   String response = String.valueOf(in.nextLine());
    //   System.out.println("you answer was: " + fq1.checkAnswer(response));
    //   if (fq1.checkAnswer(response))
    //   {
    //     fq1.displayAnswer();
    //   }
    // }
    // else
    // {
    //   System.out.println("invlaid response");
    // }

  } // end of main mehtod
}



class FillInQuestion extends Question
{
  private String fill_q;
  private String blank;
  public FillInQuestion()
  {
    this.fill_q="";
    this.blank = "______";
  }

  public void setQuestion(String qt)
  {
    this.fill_q = qt;
  }
  public void displayQuestion()
  {
    System.out.print(this.formatQuestion() + ": ");
  }
  public void displayAnswer()
  {
    String ans = super.getAnswer();
    String question = this.fill_q;
    System.out.println(question + " _" + ans + "_.");
  }

  private String formatQuestion()
  {
    return this.fill_q + blank;
  }
} // end of FillInQuestion class

class NumericQuestion extends Question
{
  private double answer_number;
  public NumericQuestion(){}
  public void setAnswer(double ans)
  {
    this.answer_number = ans;
  }

  public boolean checkAnswer(double response)
  {
    return (this.answer_number - 0.01 <= response && response <= this.answer_number + 0.01);
  }
} // end of NumericQuestion class
