public class Question
{
  private String question_text;
  private String answer_text;

  public Question()
  {
    question_text = "";
    answer_text = "";
  }

  public void setQuestion(String qt)
  {
    this.question_text = qt;
  }
  public void setAnswer(String at)
  {
    at = this.encryptAnswer(at.toLowerCase()); // much like a password
    this.answer_text = at;
  }

  public String encryptAnswer(String unencrypted_answer)
  {
    // TODO : use encryption algorithm to encrypt answer
    String encrypted_answer = unencrypted_answer;
    return encrypted_answer;
  }

  public boolean checkAnswer(String response)
  {
    return encryptAnswer(response.toLowerCase()).equals(this.answer_text);
  }

  public void display()
  {
    System.out.println(question_text);
  }
}
