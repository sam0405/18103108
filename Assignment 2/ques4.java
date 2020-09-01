package compare;

public class ques4 {
	public static long find_s(int i)
	{
		long sum=0;
		for(int j=i; j>=1; j--)
		{
			sum+= j;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		long sum= find_s(Integer.MAX_VALUE);
		System.out.println("Loading...");
		for(int i=Integer.MAX_VALUE; i>=1; i--)
		{
			long sq= (long)i*(long)i;
			if(sq==sum)
			{
				System.out.println("The number is: "+i);
				break;
			}
			sum= sum-(long)i;
			
			if(i==1)
			{
				System.out.println("There is no such integer.");
			}
		}
	}
}
