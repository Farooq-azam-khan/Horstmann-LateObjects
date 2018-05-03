public class p14
{
	public static void main(String[] args)
	{
		int x = 13; 
		while (x!=0)
		{
			int rem = x%2; 
			x /= 2; 
			System.out.println(rem); 
		}
	}
}