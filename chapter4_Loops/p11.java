public class p11
{
	public static void main(String[] args)
	{
		String str = "hare"; 
		int count = 0; 
		boolean in_vol_group = false; 
		for (int i=0; i<str.length(); i++)
		{
			if (str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='y')
			{ 
				if (!in_vol_group)
				{
					in_vol_group = true; 
					count++;
				}
			} else {in_vol_group=false;}
			
		}
		if (count == 0){count = 1;} 
		if (str.charAt(str.length()-1) == 'e'){count--;}
		System.out.println("Syllables: " + count); 
	}
}