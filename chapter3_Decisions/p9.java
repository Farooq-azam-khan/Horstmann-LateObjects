public class p9
{
	public static void main(String[] args)
	{
		double temp = 10; 
		char unit = 'C'; 

		if (unit == 'F') { temp = (temp - 32)*(5.0/9.0); }

		if (temp > 0 && temp < 100) {System.out.println("liquid");}
		else if (temp>100) {System.out.println("gas");}
		else if (temp<0){System.out.println("solid");}
	}
}