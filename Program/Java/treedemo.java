import java.io.*;
import java.util.*;

class Node{

	Node node;
	int node_value;
	Node left;
	Node right;

	public Node(int value){
		this.node_value=value;
		this.left=null;
		this.right=null;
	}
}

class BinaryTree {

    Node root;

	private Node addRecursive(Node current,int value){
		if(current==null){
			return new Node(value);
		}

		if(value>current.node_value){
			current.right=addRecursive(current.right,value);
		}else if(value<current.node_value){
			current.left=addRecursive(current.left,value);
		}
		else{
			current.left=addRecursive(current.left,value);
		}

		return current;

	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	public boolean contains_value(Node current,int value)
	{
		if(current==null)
		{
			return false;
		}
		else if(current.node_value==value)
		{
			return true;
		}
		else if(current.node_value>value){
			return contains_value(current.left,value);
		}
		else if(current.node_value<value){
			return contains_value(current.right,value);
		}
			return contains_value(current,value);
	}

	// public void printAll_Preorder(Node current){
	// 	if(current==null)
	// 	{
	// 		System.out.println("Empty Tree!!");
	// 	}
	// 	else{
	// 		print_Preorder(current);
	// 	}
	// }

	// public void print_Preorder(Node current){
	// 	if(current!=null)
	// 	{
	// 	System.out.println(current.node_value);
	// 	}
	// 	print_Preorder(current.left);
	// 	print_Preorder(current.right);
	// }

	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.node_value);
			traverseInOrder(node.right);
		}
	}

	public void BreadthFirstSearch(Node main) {
		if (main == null) {
			return;
		}

		Queue<Node> nodes = new LinkedList<>();
		nodes.add(main);

		while (!nodes.isEmpty()){
			Node node = nodes.remove();

			System.out.print(" " + node.node_value);

			if (node.left != null) {
				nodes.add(node.left);
			}

			if (node.right!= null) {
				nodes.add(node.right);
			}
		}
	}
	public static Node find(Node root,Node cur,int a){
		if(cur==null){
			return null;
		}
		Node one,two;
		if(root==cur){
			if(cur.node_value==a){
				return cur;
			}
			else{
				if(cur.node_value>a){
					root=cur;
					return find(root,cur.left,a);
				}
				else if(cur.node_value<a){
					root=cur;
					return find(root,cur.right,a);
				}

				// one=find(cur,cur.left,a);
				// two=find(cur,cur.right,a);
				// if(one!=null){
				// 	return one;
				// }
				// else if(two!=null){
				// 	return two;
				// }
			}
		}
		else
		{
			if(cur.node_value==a){
				return root;
			}
			else if(cur.node_value>a){
				root=cur;
				return find(root,cur.left,a);
			}
			else if(cur.node_value<a){
				root=cur;
				return find(root,cur.right,a);
			}
		}

		return null;
	}
	public static boolean checkSibilings(Node root,int e,int f){
		Node x=find(root,root,e);
		Node y=find(root,root,f);
		if(x==y){
			return true;
		}
		else{
			return false;
		}
	}
}




class Abc{

	public static void main(String args[]) throws Exception{
		BinaryTree bt=new BinaryTree();
		System.out.println("Enter the no of nodes u wanna have ?: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=0)
		{
			System.out.println("Enter the value : ");
			bt.add(sc.nextInt());
			n--;
		}
		System.out.println("Nodes ADDED !!!");
		// System.out.println("Wanna find the node ? Enter the no : ");
		// System.out.println(bt.contains_value(bt.root,sc.nextInt()));
		// System.out.println("Printing all values of the tree !!");
		bt.traverseInOrder(bt.root);
		System.out.println("Enter 1st value to check sibilings: ");
		int e=sc.nextInt();
		System.out.println("Enter 2st value to check sibilings: ");
		int f=sc.nextInt();
		if(bt.checkSibilings(bt.root,e,f)){
			System.out.println("sibilings");
		}
		else{
			System.out.println("Not sibilings");
		}
		// System.out.println("Breadth First Search of the tree is : ");
		// bt.BreadthFirstSearch(bt.root);
	}

}
