package test;
import java.util.*;

public class ans2 {
	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		int ary[] =new int[3]; 
		try {
			int index=0;
			while(true) {
				System.out.print("intArray["+index+"]=");
				ary[index] = sc.nextInt();
				index++;
			}
			
			
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index is out of bounds");
		}
	}
}
