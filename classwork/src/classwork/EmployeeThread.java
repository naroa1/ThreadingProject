package classwork;

import java.util.Random;

class ReadyEmployee{
	public void customerNumber(){
		
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
			
			RE.customerNumber();
		}
		int time;
		Random rand=new Random();
		
		
		System.out.println("Employee "+threadNum+" is now taking a customer.");
		try{
			for(int i=4;i>0;i--){
				System.out.println("Employee "+threadNum+" servicing customer "+i);
				//time=rand.nextInt(100); 
				time=20;
				Thread.sleep(time);
			}
		}catch(InterruptedException e){
			System.out.println("Employee "+threadNum+" is in danger!");
		}
		
		System.out.println("Employee "+threadNum+" is calling it a night.");
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
