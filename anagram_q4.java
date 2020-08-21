package q4;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class anagram {
	public static boolean Anagram(String s1,String s2) {
		if(s1.length()!=s2.length())
			return false;
		char[] w1=s1.toCharArray();
		Arrays.sort(w1);
		char[] w2=s2.toCharArray();
		Arrays.sort(w2);
		for(int i=0;i<s1.length();i++) {
			if(w1[i]!=w2[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter string 1 ");
		String s1=sc.nextLine();
		System.out.println("Enter string 2 ");
		String s2=sc.nextLine();
		if(Anagram(s1,s2))
			System.out.print("It is an anagram");
		else
			System.out.print("Not an anagram");
	}
}
