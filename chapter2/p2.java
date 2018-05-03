public class p2
{
	public static void main(String[] args)
	{
		final double l = 8.5; // inches
		final double w = 11; 
		double perimeter = 2*l + 2*w; 
		double diagonal_length = Math.sqrt(l*l + w*w); 

		System.out.printf("The perimeter of a sheet of paper (8.5 by 11 inches) is %.2f inches and the\nlenght of the diagonal is %.2f inches\n", perimeter, diagonal_length);
	}
}