package classwork;

import java.util.Random;

public class Customer {
	protected int time_to_service;
	protected int ticket_num;
	
	public Customer(int service_time,int ticket){
		time_to_service=service_time;
		ticket_num=ticket;
	}
	
	public Customer(int ticket){
		time_to_service=randomizeTime();
		ticket_num=ticket;
	}
	
	private int randomizeTime(){
		int time=0;
		Random rand=new Random(20);   //giving a max task time of twenty
		
		time=rand.nextInt();	//assigns a random value to the Customer
		
		return time;
	}
}
