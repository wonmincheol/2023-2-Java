package test;
import java.util.*;



class Cal{
	int a,b;
	Scanner sc = new Scanner(System.in);
	
	void run() {
		try {
			System.out.print("Numerator:");
			a = sc.nextInt();
			System.out.print("Denominator:");
			b = sc.nextInt();
			
			System.out.println("Ceil("+a+"/"+b+") = " +a/b);
		}
		catch(Exception e){
			System.out.println("You cannot divide by zero. Please enter a valid input");
			run();
		}
		
		
	}
}

public class ans1 {
	public static void main(String args[]) {
		Cal cal = new Cal();
		cal.run();
	}
}
