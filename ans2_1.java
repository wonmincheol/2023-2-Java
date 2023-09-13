package test;
import java.util.*;

public class ans2_1 {
	public static void main(String args[]) {
		String[] stringNumber = {"23","12","3.141592"};
		try {
			for(int i=0;i<stringNumber.length;i++) {
				System.out.println("Value converted to integer: "+Integer.parseInt(stringNumber[i]));
			}
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage()+"cannot be converted to integer.");
		}
	}
}
