package util;

import java.util.NoSuchElementException;

import datastructure.ListNode;

public class MyListIterator<E> implements MyIterator<E> {

	
	public MyListIterator() {
	}
	
	private ListNode<E> itHead = null;
	
	public MyListIterator(ListNode<E> node) {
		itHead = node;
	}
	
	@Override
	public boolean hasNext() {
		return itHead != null;
	}

	@Override
	public E next() {
		if (hasNext()) {
			ListNode<E> out = itHead;
			itHead = itHead.getNext();
			return out.getData();
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
