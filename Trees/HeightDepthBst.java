/*
Find height and depth of a node in a BST

Input:
5 3 8 2 4 1 7 9 6

Output:
Depth is: 2
Height is: 0
*/
import java.util.*;
import java.lang.*;

public class HeightDepthBst {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
		Node rootNode = null;
		while (scanner.hasNextInt()) {
			rootNode = insertToTree(rootNode, scanner.nextInt());
		}
		scanner.close();
		//findHeightOfNode (rootNode, 5, false);
		// Hardcoded for simplicity.. it's pretty straight forward to get htese values from console
		int depth = findDepthOfNode (rootNode, 3, false);
		System.out.println ("Depth is: " + depth);
		System.out.println ("Height is: " + heightOfNode(rootNode, 5));
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
	
	public static int findDepthOfNode (Node rootNode, int value, boolean flag) {
	    int depth = 0;
	    if (rootNode == null)
	        return depth;
	        
	    if (rootNode.value == value)
	        flag = true;
	        
	    if (flag) {
	        int leftDepth = 0;
	        if (rootNode.leftNode != null) 
	            leftDepth = findDepthOfNode (rootNode.leftNode, value, flag) + 1;
	        int rightDepth = 0;
	        if (rootNode.rightNode != null) 
	            rightDepth = findDepthOfNode (rootNode.rightNode, value, flag) + 1;
	        depth =  Math.max (leftDepth, rightDepth);
	    } else if (value > rootNode.value)
	        depth = findDepthOfNode (rootNode.rightNode, value, flag);
	    else
	        depth = findDepthOfNode (rootNode.leftNode, value, flag);
	    return depth;
	}
	
	public static int heightOfNode (Node rootNode, int value) {
	    int height = 0;
	    if (rootNode == null)
	        return height;
        if (value > rootNode.value)
            height = heightOfNode(rootNode.rightNode, value) + 1;
        else if (value < rootNode.value)
            height = heightOfNode(rootNode.leftNode, value) + 1;
        return height;
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
