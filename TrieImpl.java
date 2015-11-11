import java.util.*;
import java.lang.*;

class TrieNode {
  char c;
  boolean isLeaf;
  Map<Character, TrieNode> children; // we can use an array as well
  // default constructor --> to create root node
  TrieNode () {
  }
  TrieNode (char c) {
    this.c = c;
  }
}

class TrieImpl {
  public static void main (String args[]) {
    // Step-0: Initialization
    TrieNode root = new TrieNode();
    
    // Step-1: Insert words into TRIE
    insert (root, "abc");
    insert (root, "abcde");
    
    
    // Step-2: Retrieve words from TRIE
    System.out.println (isPresent (root, "abc"));
    System.out.println (isPresent (root, "abcd"));
    System.out.println (isPresent (root, "abcde"));
  }
  
  public static void insert (TrieNode root, String s) { // abcde; abe
    TrieNode rootHead = root;
    for (int i=0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (root.children == null)
        root.children = new HashMap<Character, TrieNode> ();
      
      TrieNode t = null;
      if (root.children.containsKey (c))
        t = root.children.get (c);
      else {
        t = new TrieNode (c);
        root.children.put (c, t);
      }
      root = t;
      if (i == s.length()-1)
        t.isLeaf = true;
    }
    root = rootHead;
  }
  
  public static boolean isPresent (TrieNode root, String s) {
    if (root == null || root.children == null || s == null || s.equals(""))
      return false;
    
    for (int i=0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (root.children.containsKey(c)) { // node has children
        TrieNode child = root.children.get(c);
        if (i == s.length()-1 && child.isLeaf) {
          // System.out.println (s + "--" + c);
          return true;
        }
        else if (i == s.length()-1 && !child.isLeaf)
          return false;
        else
          root = child;
      }
      else // node has no children == false
        return false;
    }
    return false;
  }
}
