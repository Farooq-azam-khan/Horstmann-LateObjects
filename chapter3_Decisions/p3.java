public class p3
{
	public static void main(String[] args)
	{
		int x = 13000; 
		if (x>=10000)
		{
			System.out.println("num has 5 digits");
		}
		else if (x>=1000)
		{
			System.out.println("num has 4 digits");
		}
		else if (x >= 100)
		{
			System.out.println("num has 3 digits"); 
		}
		else if (x>=10)
		{
			System.out.println("num has 2 digits");
		}		
	}
}