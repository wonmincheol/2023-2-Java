import java.util.*;

class GStack<T>{
	Vector<T> list;
	
	GStack(){
		list = new Vector<T>(10);
	}
	
	void push(T t) {
		list.add(t);
	}
	T pop() {
		T tar = list.lastElement();
		list.remove(list.size()-1);
		return tar;
	}
}

public class ans3 {
	public static void main(String args[]) {
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		for(int n=0;n<3;n++) {
			System.out.println(stringStack.pop());
			
		}
		GStack<Integer> intStack = new GStack<Integer>();
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);
		
		for(int n=0;n<3;n++) {
			System.out.println(intStack.pop());

		}
		
	}
}
