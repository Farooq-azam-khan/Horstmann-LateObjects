public class p4
{
	public static void main(String[] args)
	{
		System.out.println(middle("middle")); 
	}

	public static String middle(String str)
	{
		if (str.length() %2 == 0)
		{
			return str.substring(str.length()/2 - 1, str.length()/2 + 1);
		}
		return str.substring(str.length()/2, str.length()/2 + 1); 
	}
}