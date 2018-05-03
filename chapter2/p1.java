public class p1
{
	public static void main(String[] args)
	{
		final double m_per_in = 25.4; 
		double l = 8.5 * m_per_in; // 8.5 in x 25.4 mm / in
		double w = 11 * m_per_in; 
		System.out.printf("dimension of 8.5 x 11 inches of paper in mm: %.2f x %.2f\n", l, w);
	}
}