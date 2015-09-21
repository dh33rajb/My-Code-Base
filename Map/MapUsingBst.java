// Implement MAP datastructure using BST
/*
Inputs:
-------
mymap.put ("Apple", 1); mymap.put ("Aragon", 2);
mymap.put ("Archaic", 3); mymap.put ("Achilles", 4);
mymap.put ("apt", 5);mymap.put ("ail", 6);
mymap.put ("Bat", 7); mymap.put ("Ball", 8);
mymap.put ("Cat", 9); mymap.put ("Crawl", 10);

System.out.println (mymap.get("Cat"));

System.out.println (mymap.getSize());

Output:
------
9
10
*/

import java.util.*;
import java.lang.*;

// MapUsingBst
public class MapUsingBst {
  public static void main (String args[]) {
    
    // Step-1: Put to map
    MyMap mymap = new MyMap();
    mymap.put ("Apple", 1); mymap.put ("Aragon", 2);
    mymap.put ("Archaic", 3); mymap.put ("Achilles", 4);
    mymap.put ("apt", 5);mymap.put ("ail", 6);
    mymap.put ("Bat", 7); mymap.put ("Ball", 8);
    mymap.put ("Cat", 9); mymap.put ("Crawl", 10);
    
    // Step-2: Get from map
    System.out.println (mymap.get("Cat"));
    
    // Step-3: Size of map
    System.out.println (mymap.getSize());
  }
}

class MyMap {
  public int key;
  public int value;
  public Node[] cells;
  
  public MyMap() {
    cells = new Node[26];
    for (Node n : cells)
      n = null;
  }
  
  public void put (String key, int value) {
    int index = key.toLowerCase().charAt(0) - 'a';
    Node rootNode = cells[index];
    rootNode = insertIntoBst (rootNode, key, value);
    cells[index] = rootNode;
  }
  
  public int get (String key) {
    int index = key.toLowerCase().charAt(0) - 'a';
    Node rootNode = cells[index];
    Node rightNode = searchBstForNode (rootNode, key);
    return rightNode.value;
  }
  
  public int getSize() {
    int count = 0;
    for (Node root : cells) {
      count = count + countNodesInBst (root);
    }
    return count;
  }
  
  public Node insertIntoBst (Node rootNode, String key, int value) {
    if (rootNode == null) {
      rootNode = new Node (key, value);
      return rootNode;
    }
    if (key.compareTo (rootNode.key) <= 0)
      rootNode.leftChild = insertIntoBst (rootNode.leftChild, key, value);
    else
      rootNode.rightChild = insertIntoBst (rootNode.rightChild, key, value);
    return rootNode;
  }
  
  public Node searchBstForNode (Node rootNode, String key) {
    if (rootNode == null)
      return null;
    if (rootNode.key.equals (key))
      return rootNode;
    else if (key.compareTo (rootNode.key) <= 0)
      rootNode = searchBstForNode (rootNode.leftChild, key);
    else
      rootNode = searchBstForNode (rootNode.rightChild, key);
    return rootNode;
  }
  
  public int countNodesInBst (Node rootNode) {
    int count = countNodes (rootNode, 0);
    return count;
  }
  
  public int countNodes (Node rootNode, int count) {
    if (rootNode == null)
      return count;
    int leftCount = countNodes (rootNode.leftChild, count);
    int rightCount = countNodes (rootNode.rightChild, count);
    count = leftCount+rightCount+1;
    return count;
  }
}

class Node {
  String key;
  int value;
  Node leftChild;
  Node rightChild;
  
  public Node (String key, int value){
    this.key = key;
    this.value = value;
  }
}
