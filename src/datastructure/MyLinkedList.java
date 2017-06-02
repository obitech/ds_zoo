package datastructure;

import static util.Utility.p;

import util.MyListIterator;

public class MyLinkedList<T> {
	private ListNode<T> head;
	private int size = 0;
	
	public MyListIterator<T> iterator(){
		return new MyListIterator<T>(head);
	}
	
	public MyLinkedList(ListNode<T> head) {
		this.head = head;
	}
	
	public MyLinkedList() {
		this.head = null;
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void add(ListNode<T> listNode) {
		
		// Add front
		listNode.setNext(this.head);
		this.head = listNode;
		size++;
	}
	
	public void add(T data) {
		ListNode<T> listNode = new ListNode<T> (data);
		
		// Add front
		listNode.setNext(this.head);
		this.head = listNode;
		size++;
	}
	
	public ListNode<T> find(T data) {
		ListNode<T> tmp = this.head;
		
		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				return tmp;
			}
			tmp = tmp.getNext();
		}
		
		return null;
	}
	
	public void print() {
		MyListIterator<T> it = this.iterator();
		
		while (it.hasNext()) {
			T data = it.next();
			p(data);
		}
	}
	
	public int size() {
		MyListIterator<T> it = this.iterator();
		int count = 0;
		
		while (it.hasNext()) {
			count++;
			it.next();
		}
		
		return count;
	}
	
	public void delete() {
		this.head = null;
	}

}
