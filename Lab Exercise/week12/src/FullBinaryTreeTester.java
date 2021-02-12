import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FullBinaryTreeTester {
	
	public static void inOrderTraverse(Node root)
	{
		//YOUR CODE GOES HERE
		if(root == null) {
			return;
		} else {
			inOrderTraverse(root.left);
			System.out.print(root.id + " ");
			inOrderTraverse(root.right);
		}
	}
	
	public static boolean isFullBinTree(Node root)
	{	//YOUR CODE GOES HERE
		if(root == null) {
			return true;
		}
		
		if(root.left == null && root.right == null) {
			return true;
		}
		
		if(root.left != null && root.right != null) {
			return isFullBinTree(root.left) && isFullBinTree(root.right);
		}
		
		return false;
	}
	
	public static void normalTester()
	{
		Node[] ts = new Node[7];
		int count = 0;
		ts[count++] = null;
		ts[count++] = new Node(16, null, null);
		
		ts[count++] = new Node(16, new Node(14, null, null), null);
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, null, null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				null);
		
		for(int i = 0; i < ts.length; i++)
		{
			System.out.print("[T"+i+"] in-order: ");
			inOrderTraverse(ts[i]);
			System.out.println("\n[T"+i+"] is"+(isFullBinTree(ts[i])?" ":" NOT ")+"a full binary tree.\n");
		}
		
	}
	
	
	/**************BONUS STARTS***************/
	public static void printBinTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		if(root == null) {
			return;
		}
		System.out.print("(");
		printBinTree(root.left);
		System.out.print("	"+root.id);
		printBinTree(root.right);
		System.out.print(")");
	}
	
	public static Node getBinSearchTree(Node root)
	{	//YOUR BONUS CODE GOES HERE
		if (root==null) {
			return null;
		}
		else {
			System.out.println("      "+root.left.left.id);
			if(root.left != null && root.right != null) {
				System.out.print("  "+root.left.id +"       "); System.out.println(root.right.left.id);
				System.out.print(root.id+"   ");System.out.print(root.right.id+"   ");System.out.print(root.left.right.id+"   ");System.out.println(root.right.right.id+"   ");
			}
			return null;
		}
	}
	public static void bonusTester()
	{
		Node t = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		System.out.println("Before Transforming: ");
		printBinTree(t);
		System.out.println("\nAfter Transforming: ");
		getBinSearchTree(getBinSearchTree(t));
		
	}
	/**************BONUS ENDS***************/
	
	
	
	public static void main(String[] args)
	{
		normalTester();
		
		//Uncomment for bonus
		bonusTester();
	}
}
