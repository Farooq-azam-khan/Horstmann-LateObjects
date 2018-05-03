import java.util.Scanner; 
public class p7
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("give a radius: "); 
		double r = in.nextDouble(); 
		System.out.printf("area: %.2f\n", 3.1415*r*r); 
		System.out.printf("circumference: %.2f\n", 2.0*3.14159*r); 
		System.out.printf("volume: %.2f\n", (4.0/3.0)*3.14159*r*r*r); 
		System.out.printf("surface area: %.2f\n", 4.0*3.14159*r*r); 
	}
}