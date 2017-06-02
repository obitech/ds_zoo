package datastructure;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> left = null;
	private TreeNode<T> right = null;
	
	// Used for recursive insertion into tree
	private int count = 0;

	public TreeNode(T data) {	
		this.data = data;
	}

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	public void setCount(int c) {
		this.count = c;
	}
	
	public int getCount() {
		return this.count;
	}	
}
