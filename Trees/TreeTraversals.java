/* 
In-Order successor of a BST
Input:
5 3 8 2 4 1 7 9 6
 
Output:
In Order Traversal
1-2-3-4-5-6-7-8-9
Pre Order Traversal
5-1-2-3-4-6-7-8-9
Post Order Traversal
1-2-3-4-6-7-8-9-5
Level Order Traversal
5-3-8-2-4-7-9-1-6
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTraversals {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Node rootNode = null;
		while (scanner.hasNextInt()) {
			rootNode = insertToTree(rootNode, scanner.nextInt());
		}
		scanner.close();
		System.out.println ("In Order Traversal");
		printInorderTraversal(rootNode);
		System.out.println ("\nPre Order Traversal");
		printPreOrderTraversal(rootNode);
		System.out.println ("\nPost Order Traversal");
		printPostOrderTraversal(rootNode);
		System.out.println ("\nLevel Order Traversal");
		printLevelOrderTraversal(rootNode);
	}

	public static Node insertToTree(Node rootNode, int value) {
		if (rootNode == null) {
			rootNode = new Node(value);
			return rootNode;
		} else if (value > rootNode.value)
			rootNode.rightNode = insertToTree(rootNode.rightNode, value);
		else
			rootNode.leftNode = insertToTree(rootNode.leftNode, value);
		return rootNode;
	}

	public static void printInorderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		printInorderTraversal(rootNode.leftNode);
		System.out.print(rootNode.value + "-");
		printInorderTraversal(rootNode.rightNode);
	}

	public static void printPreOrderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		System.out.print(rootNode.value + "-");
		printInorderTraversal(rootNode.leftNode);
		printInorderTraversal(rootNode.rightNode);
	}

	public static void printPostOrderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		printInorderTraversal(rootNode.leftNode);
		printInorderTraversal(rootNode.rightNode);
		System.out.print(rootNode.value + "-");
	}

	public static void printLevelOrderTraversal(Node rootNode) {
		if (rootNode == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);
		while (queue.size() > 0) {
			Node pollNode = queue.poll();
			System.out.print(pollNode.value + "-");
			if (pollNode.leftNode != null)
			    queue.add(pollNode.leftNode);
			if (pollNode.rightNode != null)
			    queue.add(pollNode.rightNode);
		}
	}
}

class Node {
	public Node leftNode;
	public Node rightNode;
	public int value;

	public Node(int value) {
		this.value = value;
	}
}
