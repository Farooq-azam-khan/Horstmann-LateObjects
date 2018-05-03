public class p12
{
	public static void main(String[] args)
	{
		String str = "rum"; 
		for (int i=0; i<str.length(); i++)
		{
			System.out.println(str.substring(i, i+1)); 
		}
		for (int i=0; i<str.length()-1; i++)
		{
			System.out.println(str.substring(i, i+2)); 
		}
		for (int i=0; i<str.length()-2; i++)
		{
			System.out.println(str.substring(i, i+3)); 
		}

	}

}