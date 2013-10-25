package producer_consumer;

import java.util.Collections;
import java.util.LinkedList;

public class Resource <T> {
	
	private LinkedList<T> list;
	boolean available;
	
	// Construtor
	public Resource() {
		this.list = (LinkedList<T>) Collections.synchronizedList( new LinkedList<T>() );
		this.available = true;
	}
	// Adiciona um objeto a lista
	public synchronized boolean add(T obj) {
		try{
			return this.list.add(obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// Remove objeto da lista
	public synchronized T pop() {
		try{
			return this.list.pop();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	// Método abstrato de Thread
	public void run() {
		
	}
}
