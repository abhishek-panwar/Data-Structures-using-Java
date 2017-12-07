
/*** 
 * this is very basic implementation of binary tree
 * there is a lot of scope of further modification
 * @author Abhishek Panwar
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
		BTree b = new BTree();
		for (int i = 0; i < 10; i++) {
			b.add(i);
		}
		b.print();
		System.out.println();
		System.out.println(b.search(0));
		System.out.println(b.countNode());
		System.out.println(b.ifEmpty());

	}
}

/***
 * Binary tree implementation
 * @author Abhishek Panwar
 *
 */
class BTree
{
	BTreeNode root; //root of the tree
	public BTree()
	{
		root = null;
	}
	
	public void add(int data)
	{
		root = add(root, data);
	}
	
	private BTreeNode add(BTreeNode root, int data)
	{// finds a null node/pointer to add the new node there, recursively
		 if(root==null)
			 root = new BTreeNode(data);
		 else
		 {
			 if(root.getRight()==null)
				 root.right = add(root.getRight(), data);
			 else
				 root.left = add(root.getLeft(), data);
		 }
		 return root;
	}
	
	public boolean search(int data)
	{
		return search(root,data);
	}
	private boolean search(BTreeNode root, int data)
	{//recursive search for node
		if(root.getData()==data)
			return true;
		else
		{
			if(root.getLeft()!=null)
				if(search(root.getLeft(),data))
					return true;
			if(root.getRight()!=null)
				if(search(root.getRight(),data))
					return true;
		}
		
		return false;
	}
	
	public int countNode()
	{
		return countNode(root);
	}
	private int countNode(BTreeNode root)
	{
		if(root==null)
			return 0;
		else
		{
			int count= 1;
			count += countNode(root.getLeft());
			count += countNode(root.getRight());
			return count;
		}
	}
	
	public boolean ifEmpty()
	{
		return root==null;
	}
	
	public void print()
	{
		inorder(root);
	}
	private void inorder(BTreeNode root)
	{//inorder traversal
		if(root!=null)
		{
			inorder(root.getLeft());
			System.out.print(root.getData()+" ");
			inorder(root.getRight());
		}
	}
	
}

/***
 * node consisting of two pointers- left and right
 * and data/label
 * @author Abhishek Panwar
 *
 */
class BTreeNode
{
	int data;
	BTreeNode left;
	BTreeNode right;
	public BTreeNode(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BTreeNode getLeft() {
		return left;
	}
	public void setLeft(BTreeNode left) {
		this.left = left;
	}
	public BTreeNode getRight() {
		return right;
	}
	public void setRight(BTreeNode right) {
		this.right = right;
	}
}
