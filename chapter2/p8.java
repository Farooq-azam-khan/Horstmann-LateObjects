import java.util.Scanner; 
public class p8
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("give a length: "); 
		double l = in.nextDouble(); 
		System.out.print("give a width: "); 
		double w = in.nextDouble(); 
		System.out.printf("area: %.2f\n", l*w); 
		System.out.printf("perimeter: %.2f\n", 2.0*l+2.0*w); 
		System.out.printf("diagonal length: %.2f\n", Math.sqrt(l*l+w*w)); 
	}
}