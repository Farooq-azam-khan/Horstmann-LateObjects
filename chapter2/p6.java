import java.util.Scanner; 
public class p6
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("give a number in meters: "); 
		double x = in.nextDouble(); 
		System.out.printf("in miles: %.2f\n", x*0.000621371); 
		System.out.printf("in feet: %.2f\n", x*3.28084); 
		System.out.printf("in inches: %.2f\n", x*39.37008); 
	}
}