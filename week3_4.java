package week3;

import java.util.*;
import java.io.*;

public class week3_4 {
	public static void main(String args[]) {
		
		File file = new File("C:/");
		System.out.println("***** 파일 탑색기입니다. *****");
		System.out.println("["+file.getPath()+"]");
		while(true) {
			for(File now : file.listFiles()) {

				if(now.isDirectory() ==true) {
					System.out.printf("%-10s","dir");
				}
				else if(now.isFile() ==true) {
					System.out.printf("%-10s","file");
				}
				
				//바이트
				
				System.out.printf("%20d바이트\t",now.length());
				
				//이름
				
				System.out.printf("%-20s\n",now.getName());
			}
			
			System.out.print("다음 경로 : ");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			else {
				file = new File(file.getPath()+str);
			}
		}
		
	}
}
