import java.util.Scanner; 
public class p14
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); 
		System.out.print("give a num btn 1000 and 999999: "); 
		String num = in.next(); 

		String str = num.substring(0, num.length()-3) + "," + num.substring(num.length()-3); 
		System.out.println("num is: " + str); 
	}
}