package generic;

import java.util.List;
import java.util.ArrayList;

public class One {
	
	public static void main(String[] args) {
		List rowList = new ArrayList();
		List<String> list = new ArrayList<String>();
		
		rowList = list;
		rowList.add(8);//(1)
		System.out.println(list.get(0)); //(2)
	}
}
