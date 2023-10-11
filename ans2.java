import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;

public class ans2 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.print("1번째 날자 입력(입력 형태 : 2000-03-22) : ");
		String ar = sc.nextLine();
		Scanner tar = new Scanner(ar).useDelimiter("-");
		LocalDateTime d1 = LocalDateTime.of(tar.nextInt(),tar.nextInt(),tar.nextInt(),0,0,0);
		System.out.print("2번째 날자 입력(입력 형태 : 2000-03-22) : ");
		String ar2 = sc.nextLine();
		Scanner tar2 = new Scanner(ar2).useDelimiter("-");
		LocalDateTime d2 = LocalDateTime.of(tar2.nextInt(),tar2.nextInt(),tar2.nextInt(),0,0,0);
		
		Period diff = Period.between(d1.toLocalDate(),d2.toLocalDate());
		

		
		
		
		System.out.println("날짜의 차이는(년월일)"+diff.getYears()+"년"+diff.getMonths()+"월"+diff.getDays()+"일");
		
		
		
	}
}
