// Serialize a COMPLETE BINARY Tree (DOES NOT WORK FOR BINARY TREES THAT ARE NOT COMPLETE)
/*

Input (Hardcoded):
------
[1, 2, 3, 4, 5, 6, 7, 8, 9]

Output:
------
Original Binary tree - Level Order: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Serialized data is stored at: ./output.txt
De-serialized data: [1, 2, 3, 4, 5, 6, 7, 8, 9]
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class SerializeCOMPLETEBinaryTree {
  @SuppressWarnings({"unchecked", "deprecation"})
  public static void main(String args[]) {
    // Step-1: Create a binary tree
    int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Node rootNode = null;
    for (int i : input)
      rootNode = inserIntoBinaryTree (rootNode, i);
    // Step-2: Verify the creation of binary tree
    System.out.print ("Original Binary tree - Level Order: ");
    List<Integer> levelOrderList =  getLevelOrderTraversal(rootNode, new ArrayList<Integer>());
    System.out.println (levelOrderList);
    
    // Step-2: Write the data to a file
    try {
      FileOutputStream fos = new FileOutputStream ("./output.txt");
      ObjectOutputStream oos = new ObjectOutputStream (fos);
      oos.writeObject(levelOrderList);
      oos.close();
      fos.close();
      System.out.println ("Serialized data is stored at: " + "./output.txt");

      // Step-3: Read data from file
      FileInputStream fis = new FileInputStream ("./output.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      List<Integer> dataRead = (List<Integer>) ois.readObject();
      ois.close();
      fis.close();

      // Step-4: verify data read
      System.out.println ("De-serialized data: " + dataRead);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
  }
  
  public static Node inserIntoBinaryTree (Node rootNode, int value) {
    if (rootNode == null)
      return new Node (value);
    Queue <Node> queue = new LinkedList<Node> ();
    queue.add (rootNode);
    while (!queue.isEmpty()) {
      Node peekNode = queue.peek();
      if (peekNode.leftChild == null) {
        peekNode.leftChild = new Node (value);
        return rootNode;
      }
      else if (peekNode.rightChild == null) {
        peekNode.rightChild = new Node (value);
        return rootNode;
      }
      else {
        Node poppedNode = queue.remove();
        queue.add(poppedNode.leftChild);
        queue.add (poppedNode.rightChild);
        
      }
    }
    return rootNode;
  }
  
  public static List<Integer> getLevelOrderTraversal (Node rootNode, List<Integer> levelOrderList) {
    if (rootNode == null)
      return levelOrderList;
    Queue<Node> queue = new LinkedList<Node> ();
    queue.add (rootNode);
    
    while(!queue.isEmpty()) {
      Node poppedNode = queue.poll();
      levelOrderList.add(poppedNode.value);
      if (poppedNode.leftChild != null)
        queue.add (poppedNode.leftChild);
      if (poppedNode.rightChild != null)
      queue.add (poppedNode.rightChild);
    }
    return levelOrderList;
  }
}

class Node {
  public int value;
  public Node leftChild;
  public Node rightChild;
  
  public Node (int value) {
    this.value =  value;
  }
}
