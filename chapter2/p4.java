import java.util.Scanner; 
public class p4
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("give two numbers");
		System.out.print("num1: ");
		int num1 = in.nextInt(); 
		System.out.print("num2: ");
		int num2 = in.nextInt();

		System.out.println("sum is: " + (num2 + num1)); 
		System.out.println("diff. is: " + (num1 - num2)); 
		System.out.println("product is: " + num1*num2); 
		System.out.println("average is: " + (double)((num1+num2)/2));
		System.out.println("distance is: " + Math.abs(num1-num2)); 
		System.out.println("max is: " + Math.max(num1, num2)); 
		System.out.println("min is: "+ Math.min(num1, num2)); 

	}
}