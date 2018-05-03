public class clicker
{
	private int value; 
	public clicker()
	{
		value = 0; 
	}
	public clicker(int val)
	{
		value = val; 
	}
	public void click()
	{
		value+=1; 
	}
	public void reset()
	{
		value = 0; 
	}
	public int getValue()
	{
		return value; 
	}
	public static void main(String[] args)
	{
		clicker click1 = new clicker(); 
		clicker click2 = new clicker(10); 
		click1.click(); 
		click2.click(); 

		System.out.println("value: " + click1.getValue()); 
		System.out.println("value: " + click2.getValue()); 
	}
}