/*
P8.7
Implement a class Student. For the purpose of this exercise, a student has a name
and a total quiz score. Supply an appropriate constructor and methods getName(),
addQuiz(int score), getTotalScore(), and getAverageScore(). To compute the latter, you
also need to store the number of quizzes that the student took.

P8.8
Modify the Student class of Exercise P8.7 to compute grade point averages. Methods
are needed to add a grade and get the current GPA. Specify grades as elements of a
class Grade. Supply a constructor that constructs a grade from a string, such as "B+".
You will also need a method that translates grades into their numeric values (for
example, "B+" becomes 3.3).
*/

public class P7P8
{
  public static void main(String[] args)
  {
    Student student1 = new Student("khan");
    // System.out.println(student1.getName());
    // System.out.println(student1.getTotalQuizScore());
    // System.out.println(student1.getAverageQuizScore());
    // student1.addQuizScore(100);
    // student1.addQuizScore(100);
    // System.out.println(student1.getName());
    // System.out.println(student1.getTotalQuizScore());
    // System.out.println(student1.getAverageQuizScore());

    student1.addGrade(new Grade("A"));
    student1.addGrade(new Grade("A"));
    student1.addGrade(new Grade("A"));
    System.out.println(student1.getName());
    System.out.println(student1.getGPA());

  } // end of main method
} // end of P7P8 class

class Student
{
  private String name;
  private double total_quiz_score;
  private double quizzes;

  //
  private double total_grade;
  private double grade_counter;

  public Student(String name)
  {
    this.name = name;
    this.total_quiz_score = 0;
    this.quizzes = 0;

    this.total_grade = 0;
    this.grade_counter = 0;
  }

  public void addQuizScore(double score)
  {
    this.total_quiz_score+=score;
    this.quizzes++;
  }

  public String getName()  { return this.name; }
  public double getTotalQuizScore()
  {
    return this.total_quiz_score;
  }
  public double getAverageQuizScore()
  {
    if (this.quizzes!=0)
    {
      return this.total_quiz_score / this.quizzes;
    }
    else return 0.0;
  }

  public void addGrade(Grade grade)
  {
    this.total_grade += grade.getGrade();
    this.grade_counter++;

  }
  public double getGPA()
  {
    if (this.grade_counter!=0)
    {
      return this.total_grade / this.grade_counter;
    }
    else
    {
      return 0.0;
    }
  }
}

class Grade
{
  private double grade;
  public Grade(String letter)
  {
    this.grade = translate(letter);
  }
  public double translate(String letter)
  {
    /* Letter | GPA
          A   | 4.00
          A-  | 3.67
          B+  | 3.33
          B   | 3.00
          B-  | 2.67
          C+  | 2.33
          C   | 2.00
          C-  | 1.67
          D+  | 1.33
          D   | 1.00
          D-  | 0.67
          F   | 0
    */

    if (letter.toUpperCase().equals("A"))
    {
      return 4.00;
    } else if (letter.toUpperCase().equals("A-"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("B+"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("B"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("B-"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("C+"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("C"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("C-"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("D+"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("D"))
    {
      return 3.67;
    } else if (letter.toUpperCase().equals("D-"))
    {
      return 3.67;
    } else { return 0.00; }
  } // end of translate method

  public double getGrade()
  {
    return this.grade;
  }
}
