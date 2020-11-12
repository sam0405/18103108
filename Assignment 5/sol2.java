//package solution1;

class Count{
	static int max_int;
	static int num;
	
	public void run(int start, int end) {
		
		
		for(int i=start; i<=end; i++)
		{
			int count=1;
			for(int j=1; j<=(i/2)+1; j++)
			{
				if(i%j==0)
					count++;
			}
			
			synchronized(this) {
				if(count>max_int)
				{
					max_int=count;
					num= i;
				}
			}
				
		}
	}
}

class MyThd extends Thread{
	Count C;
	int start;
	int end;

	MyThd(Count C, int start, int end){
		this.C= C;
		this.start= start;
		this.end= end;
	}
	
	public void run() {
		C.run(start, end);
	}
	
}

public class multi_thread_divisor_sol2 {
		
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Count C= new Count();
		MyThd threads[]= new MyThd[100];
		int j=0;
		for(int i= 100; i<=10000; i+=100) {
			threads[j]= new MyThd(C,i-99,i);
			threads[j].start();
			j++;
		}
		
		for(int i=0; i<100; i++)
		{
			try {
				threads[i].join();
			}
			catch(Exception e) {}
		}
		long end = System.currentTimeMillis();
		System.out.println("Range: 1 to 10000");
		System.out.println("The maximum number of divisors are: "+C.max_int);
		System.out.println("Of number: "+C.num);
		System.out.println("Time elapsed: "+ (end - start) +" milli-seconds");
	}	
}

