
import java.util.*;
import java.io.*;


public class XorCode{
	public XorCode(String args, String key) throws IOException{
		Scanner std= new Scanner(System.in);
		// System.out.print("프로토타입이라서 입력 잘못하면 복구 못할 수도 있습니다.");
		// System.out.print("key 입력\n>>");
		// String key = std.next();
		byte[] key_byte = key.getBytes();
		System.out.println("XorEncoding begins.");
		//String file_Name; //이거에 경로 이름 준 다음에 아래에 넣으면 연결
		FileInputStream is = new FileInputStream(args);
		FileOutputStream os = new FileOutputStream(args);
		byte[] data = new byte[1024];
		int read = is.read(data);
		int index = 0;
		while(read != -1) {
			for(int k = 0; k < read; k++) {
				data[k] ^= key_byte[index % key_byte.length];
				index++;
			}
			os.write(data, 0, read);
			read = is.read(data);
			
		}
		os.flush();
		os.close();
		is.close();
		std.close();
		System.out.println("XorEncoding complete.");
	}
}
