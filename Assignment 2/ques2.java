package compare;
import java.util.*; 
public class counting {
	static void countSort(int[] arr) 
	{ 
		int mx = Arrays.stream(arr).max().getAsInt(); 
		int mn = Arrays.stream(arr).min().getAsInt(); 
		int r = mx - mn + 1; 
		int count[] = new int[r]; 
		int output[] = new int[arr.length]; 
		for (int i = 0; i < arr.length; i++) 
		{ 
			count[arr[i] - mn]++; 
		} 
		for (int i = 1; i < count.length; i++) 
		{ 
			count[i] += count[i - 1]; 
		} 
		for (int i = arr.length - 1; i >= 0; i--) 
		{ 
			output[count[arr[i] - mn] - 1] = arr[i]; 
			count[arr[i] - mn]--; 
		} 
		for (int i = 0; i < arr.length; i++) 
		{ 
			arr[i] = output[i]; 
		} 
		for (int i = 0; i < arr.length; i++) 
		{ 
			System.out.print(arr[i] + " "); 
		} 
		System.out.println(""); 
	} 
	public static void main(String[] args) 
	{ 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array ");
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		countSort(a);
		sc.close();
	} 
}
