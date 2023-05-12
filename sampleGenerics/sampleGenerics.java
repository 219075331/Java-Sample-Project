package sampleGenerics;

import java.util.ArrayList;
import java.util.List;

public class sampleGenerics {

	public static void main(String[] args) {
		
		List<A> list = new ArrayList<A>();
		list.add(new B());
		
		test(list);	

	}	
	
	private static void test(List<? super B>  list) {
		for(Object obj : list) {
			System.out.println(obj.toString());
		}
	}

}
