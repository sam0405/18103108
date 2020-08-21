//package q1;
import java.util.Scanner;
public class substring {
	public static boolean zeros(int arr[])
	{
		for(int i=0; i<256; i++)
			if(arr[i]!=0)
				return false;
		return true;
	}
	
	public static int countsub(int arr[], String subs, String s)
	{
		if(subs.length()>s.length() || subs.length()==0)
			return 0;
		int total=0;
		for(int i=0; i<subs.length(); i++)
			arr[s.charAt(i)]--;
		if(zeros(arr))
			total++;
		for(int i=subs.length(); i<s.length(); i++)
		{
			arr[s.charAt(i)]--;
			arr[s.charAt(i-subs.length())]++;
			if(zeros(arr))
				total++;
		}
		return total;
	}
	
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the String:");
		String s= sc.nextLine();
		
		System.out.println("Enter the Substring:");
		String subs= sc.nextLine();
		
		int arr[]= new int[256];
		
		for(int i=0; i<subs.length(); i++)
			arr[subs.charAt(i)]++;
		
		System.out.println(countsub(arr, subs, s));
		
		sc.close();

	}
}
