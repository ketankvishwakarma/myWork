package Threads;

class RunnerWithRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< 10 ;i++)
			System.out.println("Hello from "+Thread.currentThread()+" :: "+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class Thread2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnerWithRunnable());
		Thread t2 = new Thread(new RunnerWithRunnable());
		
		t1.start();
		t2.start();
	
	}
}
