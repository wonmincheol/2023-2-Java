package week3;

import java.util.*;
import java.io.*;


public class week3_6 {
	public static void main(String args[]) {
		byte[] key = {10,20,30,40};
		File file = new File("C:/javaio/words.txt");
		try {
			BufferedReader buf = new BufferedReader(new FileReader(file));
			Vector<String> vec = new Vector<String>();
			String line = "";

			try {
				while((line = buf.readLine())!=null) {
					vec.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] data =new byte[1024];
			//file inputstream
			//file outputstream
			for(int k=0;k<vec.size();k++) {
				vec.set(k, vec.get(k)^key[k%key.length]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
