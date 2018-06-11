package com.techlabs.adaptor;

import java.util.Iterator;
import java.util.LinkedList;

public class SwabhavQ<T> implements Iterable<T> {
	
	private LinkedList<T> adapti;
	
	public SwabhavQ() {
		this.adapti = new LinkedList<T>();
	}

	public void enqueue(T element){
		adapti.addLast(element);
	}
	
	public T dequeue(){
		return adapti.removeFirst();
	}
	
	public int count(){
		return adapti.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.adapti.iterator();
	}

}
