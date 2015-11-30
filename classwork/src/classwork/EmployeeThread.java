package classwork;

import java.util.Random;

class ReadyEmployee{
	public static int custNum;
	public void customerNumber(String number){
		int time;
		Random rand=new Random();
		String threadNum=number;
		
		System.out.println("Employee "+threadNum+" is now taking customers.");
		try{
			for(int i=5;i>0;i--){
				System.out.println("Employee "+threadNum+" servicing customer "+ReadyEmployee.getNumber());
				time=rand.nextInt(500); 
				System.out.println("This customer is going to take: "+time+" ms to service.\n");
				notifyAll();
				Thread.sleep(time);
				wait();
			}
		}catch(InterruptedException e){
			System.out.println("Employee "+threadNum+" is in danger!");
		}
	}
	
	public static int getNumber(){
		custNum++;
		return custNum;
	}
}

public class EmployeeThread extends Thread{
	private Thread t;
	public String threadNum;
	ReadyEmployee RE;
	
	
	public EmployeeThread(String name,ReadyEmployee re){
		threadNum=name;
		System.out.println("Employee "+threadNum+" is available.");
		RE=re;
	}

	public void run(){
		synchronized(RE){
			
			RE.customerNumber(threadNum);
		}
		
		System.out.println("Employee "+threadNum+" is going to take a break.");
	}
	
	public void start(){
		System.out.println("Employee "+threadNum+" ready to work!");
		if(t==null)
		{
			t=new Thread(this,threadNum);
			t.start();
		}
	}
	
}
