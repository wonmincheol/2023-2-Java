package test;
import java.util.*;

public class ans2_2 {
	public static void main(String args[]) {
		int first=0,last=99;
		int ans = (int)(Math.random()*100);
		int in;
		int trynum=1;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Random number is generated. Guess the number:");
			ans = (int)(Math.random()*100);
			first=0;
			last=99;
			trynum=1;
			while(true) {
				try {
					System.out.println(first + "-" + last);
					System.out.print(trynum + ">>");
					sc = new Scanner(System.in);
					in = sc.nextInt();
					
					
					if(in==ans) {
						System.out.println("Correct.");
						break;
					}
					else if(in>ans) {
						System.out.println("Enter a low number");
						last = in;
					}
					else {
						System.out.println("Enter a high number");
						first = in;
					}
					trynum++;
					
				}
				catch(InputMismatchException e) {
					System.out.println("Only integer is allowed.");
				}
			}
			System.out.print("Try again (y/n)>>");
			String input = sc.next();
			if(input.equals("y")) {
				continue;
			}
			else if(input.equals("n")) {
				break;
			}
		}
	}
}
