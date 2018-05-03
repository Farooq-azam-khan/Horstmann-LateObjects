import java.util.Scanner; 
public class p13
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); 
		System.out.print("give a num btn 1,000 and 999,999: "); 
		String num = in.next(); 

		String str = num.substring(0, num.length()-4) + num.substring(num.length()-3); 
		System.out.println("num is: " + str); 
	}
}