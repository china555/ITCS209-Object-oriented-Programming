package ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice_HashMap {
	public static Map<Integer,String> x = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		x.put(5, "a boy in love");
		x.put(15, "b a iwnfr i n");
		List<String> y = new ArrayList<String>();
		for(Integer i : x.keySet()) {
			if(x.get(i).contains("in")) {
			y.add(x.get(i));
			}
		}
		for(String i : y) {
			System.out.println(i);
		}
	}

}
