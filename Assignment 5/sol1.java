//package solution1;

class MyThread implements Runnable{
	public void run() {
		for(int i=1;i<=100;i++) {
			if(i%10==0)
				System.out.print(i);
			try {
				Thread.sleep(1000);
			}
			catch(Exception error) {}
		}
	}
}
public class counting_thread {
	public void main(String args[]) {
		MyThread obj = new MyThread();
		Thread t1 = new Thread(obj);
		t1.start();
	}
}
	
	
