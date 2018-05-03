import java.util.Scanner; 
public class p10
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("cost ($): "); 
		double c = in.nextDouble(); 
		System.out.print("miles/yr: "); 
		double ml_per_yr = in.nextDouble(); 
		System.out.print("gas pirce ($): "); 
		double gp = in.nextDouble();
		System.out.print("efficiency (miles/gallon): "); 
		double e = in.nextDouble(); 
		System.out.print("resale value (after 5yrs): "); 
		double resale = in.nextDouble();


		double total_cost = ml_per_yr; // for 5 years

	}
}