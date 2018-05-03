import java.util.Scanner; 
public class p12
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); 
		System.out.print("OS: "); 
		String os = in.next().toLowerCase(); 

		System.out.print("driver: ");
		String d = in.next().toUpperCase(); 
		System.out.print("path: "); 
		String path = in.next(); 
		System.out.print("filename: ");
		String filename = in.next(); 
		System.out.print("extention: "); 
		String extention = in.next(); 

		if (extention.charAt(0) == '.')
		{
			extention = extention.substring(1); 
		}
		if (path.charAt(0) == '\\')
		{
			path = path.substring(1); 
		}

		
		if (os.equals("windows"))
		{
			System.out.println(d+":\\"+path+"\\"+filename+"."+extention); 
		} else {
			System.out.println(path+"/"+filename+"."+extention); 
		}
	}
}