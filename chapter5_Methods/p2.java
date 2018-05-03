public class p2
{
	public static void main(String[] args)
	{
		System.out.println("allTheSame: " + allTheSame(1,1,1));
		System.out.println("allDifferent: " + allDifferent(1,10,3));
		System.out.println("sorted: " + sorted(10,2,3));

	}

	public static boolean allTheSame(double x, double y, double z)
	{
		return x==y&&y==z; 
	}

	public static boolean allDifferent(double x, double y, double z)
	{
		return (x!=y&&y!=z); 
	}

	public static boolean sorted(double x, double y, double z)
	{
		return (x<=y&&y<=z);
	}

}