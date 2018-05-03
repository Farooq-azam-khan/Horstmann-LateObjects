public class p1
{
	public static void main(String[] args)
	{
		System.out.println("smallest: " + smallest(10, 20, 30)); 
		System.out.println("average: " + average(10, 20, 30)); 

	}
	public static double smallest(double x, double y, double z)
	{
		if (x < y && x < z)
		{
			return x; 
		}
		else if (y < x && y< z)
		{
			return y; 
		}
		return z; 
	}
	public static double average(double x, double y, double z)
	{
		return (x+y+z)/3;
	}
}