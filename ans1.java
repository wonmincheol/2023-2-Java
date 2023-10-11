import java.util.*;
import java.io.*;
public class ans1 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		FileWriter  fw = new FileWriter("c:/javatest/phone.txt");
		for(int i=0;i<5;i++) {
			System.out.print((i+1)+"번째 학생의 이름과 전화번호를 입력하세요 (공백으로 분리) : ");
			String ar = sc.nextLine();
			Scanner tar = new Scanner(ar).useDelimiter("\\s*");
			fw.write(tar.next());
			fw.write(tar.nextLine());
			fw.write("\n");
		}
		System.out.println("phone.txt 파일에 저장되었습니다.");
		fw.close();
	}
}
