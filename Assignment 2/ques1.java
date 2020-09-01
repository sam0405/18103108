package compare;
import java.util.*;
public class compare_lexo {
	public static int stringCompare(String s1, String s2){ 
		for (int i=0; i<s1.length() &&  i<s2.length();i++){ 
			if ((int)s1.charAt(i) == (int)s2.charAt(i)) { 
				continue; 
			}  
			else { 
				return (int)s1.charAt(i) - (int)s2.charAt(i); 
			} 
		} 
		if (s1.length() < s2.length()) { 
			return (s1.length()-s2.length()); 
		}  
		else if (s1.length() > s2.length()) { 
			return (s1.length()-s2.length()); 
		} 
		else { 
			return 0; 
		} 
	} 

	public static void main(String args[]){ 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first string");
		String s1=sc.nextLine();
		
		System.out.println("Enter Second string");
		String s2=sc.nextLine();
		
		System.out.println(stringCompare(s1,s2));
		sc.close();
	} 
}
