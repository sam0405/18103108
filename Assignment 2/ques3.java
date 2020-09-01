package compare;
import java.util.*;
public class sorting {
	public static void main(String[] args) 
    {
        int n;
        String temp;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of strings ");
        n = scan.nextInt();
        String arr[] = new String[n];
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter the Strings ");
        for(int i = 0; i < n; i++)
        {
            arr[i] = scan2.nextLine();
        }
        scan.close();
        scan2.close();
        for (int i = 0; i<n; i++) 
        {
            for (int j=i+1; j<n; j++) { 
                if (arr[i].compareTo(arr[j])>0) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i=0; i<=n-1; i++) 
        {
            System.out.print(arr[i] + " ");
        }
    }
}
