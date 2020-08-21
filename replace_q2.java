
//package q2;
import java.util.*;
public class replace {
	public static String replacing(String word,String text) {
		String[] new_t=text.split(" ");
		int index=0;
		for(String str:new_t) {
			if(str.compareTo(word)==0) {
				String s="";
				s+=str.charAt(0);
				for(int i=1;i<str.length();i++)
					s+='*';
				new_t[index]=s;
			}
			index++;
		}
		String res="";
		for(String st:new_t) {
			res+=st;
			res+=" ";
		}
		res=res.trim();
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a paragraph");
		String text=sc.nextLine();
		String[] word= {"bad","good"};
		for(String str:word) {
			text=replacing(str,text);
		}
		System.out.print(text);
	}
}
