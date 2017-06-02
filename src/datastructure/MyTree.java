package datastructure;

import java.util.LinkedList;
import java.util.Queue;

import util.MyTreeIterator;

import static util.Utility.*;

public class MyTree<T> {
	private TreeNode<T> root;
	
	// Necessary for recursive insertion
	private int lastCount;
	private int nodeCount;
	
	public MyTree() {
		this.root = null;
	}
	
	public MyTreeIterator<T> iterator() {
		return new MyTreeIterator<T>(root);
	}
	
	public MyTree(TreeNode<T> node) {
		this.root = node;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	/**
	 * 1) Level-order insertion via Queues
	 * Will construct like this:
	 * 
	 *           0		
	 * 	  	   /   \		
	 *   	  1     2   
	 *  	 / \   / \
	 * 		3   4 5   6
	 */
	public void insertQueue(T data) {
		TreeNode<T> node = new TreeNode<T>(data);
		
		if (root == null) {
			root = node;
			l("Node with " + node.getData() + " has been set as root");
			return;
		}
		
		// Since this is just a helper I hope it's ok to use Collections' LinkedList here...
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.offer(root);
		
		while (true) {
			TreeNode<T> curr = queue.remove();
			
			// Check if left == null
			if (curr.getLeft() == null) {
				// ... yes -> add node on left side
				curr.setLeft(node);
				l("Node with "+node.getData()+" has been set as LEFT CHILD of Node with "+curr.getData());
				return;
			} else {
				// ... no -> queue left as until there are no more left nodes
				queue.offer(curr.getLeft());
				l("Left node with "+curr.getLeft().getData()+" has been queued");
			}
			
			// Same for right side
			if (curr.getRight() == null) {
				curr.setRight(node);
				l("Node "+node.getData()+" has been set as RIGHT CHILD of Node with "+curr.getData());
				return;
			} else {
				queue.offer(curr.getRight());
				l("Right node with "+curr.getLeft().getData()+" has been queued");
			}
		}
	}
	
	/**
	 * 2) Level-order insertion via recursion
	 * Will construct like this:
	 * 
	 *           0		
	 * 	  	   /   \		
	 *   	  1     2   
	 *  	 / \   / \
	 * 		3   4 5   6
	 */
	public void insertRec(TreeNode<T> newNode, TreeNode<T> prevNode, int recentCount) {
		// Tree is empty
		if (root == null) {
			root = newNode;
			l(newNode.getData() + " has been added as root");
			root.setCount(1);
			nodeCount++;
			return;
		}
			
		// Node has two childs: recursive call for both sub-trees
		if((prevNode.getLeft() != null) && (prevNode.getRight() != null)) {
			insertRec(newNode, prevNode.getLeft(), recentCount);
			insertRec(newNode, prevNode.getRight(), recentCount);
			return;
		}
		
		// Node has no childs: start inserting
		if(!(prevNode.getLeft() != null) && (prevNode.getRight() == null)) {
			// Find neighbour of last inserted node...
			if((prevNode.getCount() == (lastCount +1) && (recentCount == nodeCount))) {
				// ... and add as left child
				prevNode.setLeft(newNode);
				l(newNode.getData() + " has been added as LEFT CHILD of " + prevNode.getData());
				nodeCount++;
				newNode.setCount(nodeCount);
			}
			return;
		}
			
		// Node has only left child: add right
		if((prevNode.getLeft() != null) && (prevNode.getRight() == null) && (recentCount == nodeCount)) {
			prevNode.setRight(newNode);
			l(newNode.getData() + " has been added as RIGHT CHILD of " + prevNode.getData());
			nodeCount++;
			newNode.setCount(nodeCount);
			// Save parent of last inserted node 
			lastCount = prevNode.getCount();
			return;
		}
		
		return;
	}
	
	public void print() {
		MyTreeIterator<T> it = this.iterator();
		
		while(it.hasNext()) {
			T data = it.next();
			p(data);
		}
	}
	
	// Returns number of nodes
	public int getSize() {
		int count = 0;
		MyTreeIterator<T> it = new MyTreeIterator<T>(root);
		
		while(it.hasNext()) {
			count++;
			it.next();
		}
		
		return count;
		
	}
	
	public void delete() {
		this.root = null;
	}

	public int getNodeCount() {
		return this.nodeCount;
	}
}
