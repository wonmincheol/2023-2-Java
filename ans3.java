package test;
import java.util.*;

public class ans3 {
	public static void main(String args[]) {
		int maxStack=3;
		int count=0;
		int ary[]= new int[maxStack];
		int result=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter three integer values:");

		while(true) {
			try {
				sc = new Scanner(System.in);
				System.out.print(count+">>");
				ary[count] = sc.nextInt();
				count++;
				
			}
			catch(InputMismatchException e) {
				System.out.println("Not a integer. Please try again.");
			}
			finally {
				if(count==maxStack) {
					for(int i=0;i<maxStack;i++) {
						result +=ary[i];
					}
					System.out.println("Results: "+result);
					break;
				}
			}
		}
		
		
	}
}
