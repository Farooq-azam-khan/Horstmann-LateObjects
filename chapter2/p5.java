import java.util.Scanner; 
public class p5
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("give two numbers");
		System.out.print("num1: ");
		int num1 = in.nextInt(); 
		System.out.print("num2: ");
		int num2 = in.nextInt();

		System.out.printf("sum: %10d\n", (num2 + num1)); 
		System.out.printf("difference: %2d\n", (num1 - num2)); 
		System.out.printf("product: %7d\n", num1*num2); 
		System.out.printf("average: %9.2f\n", (double)((num1+num2)/2));
		System.out.printf("distance: %5d\n", Math.abs(num1-num2)); 
		System.out.printf("max: %10d\n", Math.max(num1, num2)); 
		System.out.printf("min: %10d\n", Math.min(num1, num2)); 

	}
}