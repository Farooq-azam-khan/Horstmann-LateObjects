public class p2
{
	public static void main(String[] args)
	{
		double x = 0; 

		if (x<0)
		{
			System.out.println("neg"); 
		}
		else if (x>0)
		{
			System.out.println("pos"); 
		} else {
			System.out.println("zero"); 
		}
		if (Math.abs(x) < 1)
		{
			System.out.println("small");
		}
		else if (Math.abs(x) > 1000000)
		{ System.out.println("largs");}
	}
}