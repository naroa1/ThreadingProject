package classwork;

public class FishCounter extends Thread{
	private static int customerNumber=0;
	
	public static void main(String[] args)
	{
		ReadyEmployee RE=new ReadyEmployee();
		EmployeeThread E1=new EmployeeThread("1",RE);
		E1.start();
		EmployeeThread E2=new EmployeeThread("2",RE);
		E2.start();
		EmployeeThread E3=new EmployeeThread("3",RE);
		E3.start();
		EmployeeThread E4=new EmployeeThread("4",RE);
		E4.start();
		EmployeeThread E5=new EmployeeThread("5",RE);
		E5.start();
	}
	
	public static int getCustomer(){
		return customerNumber;
	}
}
