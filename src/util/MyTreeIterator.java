package util;

import java.util.Stack;

import datastructure.TreeNode;

public class MyTreeIterator<E> implements MyIterator<E> {

	/**
	 * Using stacks to iterate over tree, so basically doing pre-order traversal:
	 * (values just for reference, not indicating BST!)
	 * 
	 *           0		
	 * 	  	   /   \		
	 *   	  1     2   
	 *  	 / \   / \
	 * 		3   4 5   6
	 * 
	 * would get: 3, 1, 4, 0, 2, 5, 6
	 */
	private Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
	private TreeNode<E> curr;
	
	public MyTreeIterator(TreeNode<E> root) {
		this.curr = root;
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty() || curr != null;
	}

	@Override
	public E next() {
		// This will get the left sub-tree first
		while (curr != null) {
			stack.push(curr);
			curr = curr.getLeft();
		}
	
		curr = stack.pop();
		TreeNode<E> out = curr;
		curr = curr.getRight();
		
		return out.getData();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
