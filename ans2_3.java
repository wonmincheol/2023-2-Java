package test;
import java.util.*;

public class ans2_3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int countChar[] = new int[26];
		for(int i=0;i<countChar.length;i++) {
			countChar[i] = 0;
		}
		try {
			
			String inString = sc.nextLine();
			
			String listString[] = inString.split(" ");
			char list[] = new char[listString.length];
			for(int i=0;i<listString.length;i++) {
				list[i] = listString[i].charAt(0);
			}
			for(int i=0;i<list.length;i++) {
				
				if(list[i]>=97) {
					list[i] -= 32;
				}
				countChar[(int)(list[i]-65)]++;
			}
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Input includes non-alphabet.");
		}
		finally {
			for(int i=0;i<26;i++) {
				System.out.println("Character "+(char)(i+65)+": "+countChar[i]);
			}
		}
	}
}
