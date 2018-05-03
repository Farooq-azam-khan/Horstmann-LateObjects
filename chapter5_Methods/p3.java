public class p3
{
	public static void main(String[] args)
	{
		System.out.println("firstDigit: " + firstDigit(100));
		System.out.println("lastDigit: " + lastDigit(101));
		System.out.println("digits: " + digits(101));

	}
	public static int firstDigit(int n)
	{
		return Integer.valueOf( String.valueOf(n).substring(0,1) ); 
	}

	public static int lastDigit(int n)
	{
		return n%10; 
	}
	public static int digits(int n)
	{
		return String.valueOf(n).length(); 
	}
}