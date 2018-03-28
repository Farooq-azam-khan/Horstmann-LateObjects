public class unchecked
{
  public static void main(String[] args)
  {

    try
    {
      String str = "hello world to try catch finally";
      for (int i=0; i<str.length()+1; i++)
      {
        System.out.println(String.valueOf(str.charAt(i)));
      }
    }
    catch(IndexOutOfBoundsException e)
    {
      System.out.println(e.getMessage());

    }
  }

}
