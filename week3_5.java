package week3;

import java.util.*;
import java.io.*;


public class week3_5 {
	public static void main(String args[]) {
		try {
			File file = new File("C:/javaio/words.txt");
			BufferedReader buf = new BufferedReader(new FileReader(file));
			Vector<String> vec = new Vector<String>();
			String str;
			String line = "";
			while((line = buf.readLine())!=null) {
				vec.add(line);
			}
			
			
			System.out.println("words.txt has been found");

			while(true) {
				System.out.print("Word>>");
				Scanner sc = new Scanner(System.in);
				String st = sc.nextLine();
				
				st = st.replace("\n", "");
				System.out.println(st);

				if(st.equals("exit")) {
					System.out.println("Bye");
					break;
					
				}
				else {
					for(String now : vec) {
						if(now.toLowerCase().startsWith(st.toLowerCase())==true) {
							System.out.println(now);
						}
					}
				}
			}
			
		}
		catch(Exception e) {
		}
	}
}
