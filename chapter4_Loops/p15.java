import java.util.Scanner; 
public class p15
{
	public static void main(String[] args)
	{
		String vals = ""; 
		Scanner in = new Scanner(System.in);

		System.out.println("values:");
		while (true)
		{
			String number = in.next(); 
			if (number.equals("q"))
			{
				break; 
			} else {
				vals += number + " "; 
			}
			

		}

		System.out.println("vals: " + vals); 
		int pos = 0; 

		double count = 0; 
		double sum = 0; 
		double sum_sqrd = 0; 
		for (int i=0; i<vals.length(); i++)
		{
			if (vals.charAt(i) == ' ')
			{
				double num = Double.valueOf(vals.substring(pos, i));
				count++; 
				sum += num; 
				sum_sqrd += num*num; 

				pos = i+1; 
			}
		}

		double numerator = sum_sqrd - ((1/count)*(sum*sum));
		double denomenator = count - 1; 
		double s = Math.sqrt(numerator / denomenator); 
		System.out.println("standard dieviation: " + s); 

		

	}
}