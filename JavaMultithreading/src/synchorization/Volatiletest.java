package synchorization;

import java.util.Scanner;

class Processor extends Thread{
	private volatile boolean running = true;
	
	public void run(){
		while(running){
			System.out.println("HELLO ::");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutDown(){
		System.out.println("shutting down...");
		running = false;
	}
}

public class Volatiletest {

	public static void main(String[] args) {
		Processor p = new Processor();
		p.start();
		
		System.out.println("press return to exit");
		Scanner in = new Scanner(System.in);
		in.nextLine();
		p.shutDown();
	}
}
