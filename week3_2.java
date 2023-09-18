package week3;
import java.util.*;
import java.io.*;


class Ary implements Serializable{
	public int[] INTary;
	public String[] Strary;
	
	public Ary(int[] in,String[] str) {
		INTary = in;
		Strary = str;
	}
}

public class week3_2 {
	public static void main(String args[]) throws Exception {
		File file = new File("C:/javaio");
		
		int[] intary = {1,5,3,2};
		String[] strary = {"test","test2","test3"};
		
		Ary ary = new Ary(intary,strary);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file+"/objoutput.txt"));
		oos.writeObject(ary);
		
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file+"/objoutput.txt"));
		
		Ary aryCopy = (Ary)ois.readObject();
		
		for(int i=0;i<aryCopy.INTary.length;i++) {
			System.out.print(aryCopy.INTary[i]+ " ");
			
		}
		System.out.println("");
		for(int i=0;i<aryCopy.Strary.length;i++) {
			System.out.print(aryCopy.Strary[i]+ " ");
			
		}
		
	}
}
