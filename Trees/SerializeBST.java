
// Serialize a binary search tree
/*
Input (hardcoded for simplicity):
---------------------------------
1, 2, 3, 4, 5, 6, 7, 8, 9

Output:
------
Original Binary tree - In Order: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Deserialized list: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Deserialized Binary tree - In Order: [1, 2, 3, 4, 5, 6, 7, 8, 9]
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  @SuppressWarnings ("unchecked")
  public static void main (String args[]) {
    
    // Step-1: Create a binary search tree
    int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Node rootNode = null;
    rootNode = findValueAndInsertToBst (rootNode, input, 0, input.length-1);
    
    // Step-2: Verify the creation of binary tree: by inorder traversal
    System.out.print ("Original Binary tree - In Order: ");
    List<Integer> inOrderList =  getInOrderTraversal(rootNode, new ArrayList<Integer>());
    System.out.println (inOrderList);
    
    List<Integer> readList = null;
    try {
    // Step-3: Serialize bst
    FileOutputStream fos = new FileOutputStream("./output.txt");
    ObjectOutputStream oos = new ObjectOutputStream (fos);
    oos.writeObject (inOrderList);
    oos.close();
    fos.close();
    
    // Step-4: Deserialize bst
    FileInputStream fis = new FileInputStream ("./output.txt");
    ObjectInputStream ois = new ObjectInputStream (fis);
    readList = (List<Integer>) ois.readObject();
    ois.close();
    fis.close();
    
    System.out.println ("Deserialized list: " + readList);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    
    // Step-5: Create back a binary tree with the deserialized 
    Node mainNode = null;
    int[] deserializedInput = new int[readList.size()];
    int count= 0;
    for (int i : readList)
      deserializedInput[count++] = i;
    mainNode = findValueAndInsertToBst (mainNode, deserializedInput, 0, deserializedInput.length-1);
    
    // Step-6: Verify the creation of binary tree: by inorder traversal
    System.out.print ("Deserialized Binary tree - In Order: ");
    List<Integer> deserInOrderList =  getInOrderTraversal(mainNode, new ArrayList<Integer>());
    System.out.println (deserInOrderList);
  }
  
  public static Node findValueAndInsertToBst (Node rootNode, int[] input, int startIndex, int endIndex) {
    if (endIndex < startIndex)
      return rootNode;
    int midIndex = (startIndex + endIndex)/2;
    rootNode = insertIntoBst (rootNode, input[midIndex]);
    rootNode = findValueAndInsertToBst (rootNode, input, startIndex, midIndex-1);
    rootNode = findValueAndInsertToBst (rootNode, input, midIndex+1, endIndex);
    return rootNode;
  }
  
  public static Node insertIntoBst (Node rootNode, int value) {
    if (rootNode == null)
      return new Node (value);
    if (value < rootNode.value)
      rootNode.leftChild = insertIntoBst (rootNode.leftChild, value);
    else
      rootNode.rightChild = insertIntoBst (rootNode.rightChild, value);
    return rootNode;
  }
  
  public static List<Integer> getInOrderTraversal (Node rootNode, List<Integer> list) {
    if (rootNode == null)
      return list;
    list = getInOrderTraversal (rootNode.leftChild, list);
    list.add (rootNode.value);
    list = getInOrderTraversal (rootNode.rightChild, list); 
    return list;
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
