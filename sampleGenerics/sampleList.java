package sampleGenerics;

import java.util.ArrayList;
import java.util.List;

public class sampleList<T> {
	
	private List<T> list = new ArrayList<>();
	
	public void add(T value) {
		if(value == null) {
			return;
		}
		this.list.add(value);
	}
	
	public T get(int index) {
		return this.list.get(index);
	}
	
	public int size() {
		return this.list.size();
	}

}
