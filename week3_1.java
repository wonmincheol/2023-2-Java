package week3;
import java.io.*;
import java.util.*;

public class week3_1 {
	public static void main(String args[]) throws Exception{
		String sourceText;
		String targetText;
		File file = new File("C:/javaio/");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Source file : ");
		sourceText = sc.nextLine();
		System.out.print("Target file : ");
		targetText = sc.nextLine();
		
		FileReader fr = new FileReader(file+"/"+sourceText);
		
		try {
			FileReader fwt= new FileReader(file+"/"+targetText);
			
			System.out.println("Target file already exists");
			System.out.println("Overwrite?(y/n)");
			String check = sc.nextLine();
			
			if(check.equals("n")) {
				System.exit(0);
			}
		}catch(Exception e) {
			
		}
		
		FileWriter fw = new FileWriter(file+"/"+targetText);
		
		
		
		int i;
		while((i=fr.read()) != -1){
			fw.write((char)i);
		}
		fr.close();
		fw.close();
		System.out.println("Copy has been completed.");
	}
}
