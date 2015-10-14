/* Driver program to test above function */

// RectanglesOverlap
public class Solution {
  public static void main(String args[]){
    
    Point l1 = new Point (0, 10);
    Point r1 = new Point (10, 0);
    
    Point l2 = new Point (5, 5);
    Point r2 = new Point (15, 0);
    
    if (doOverlap(l1, r1, l2, r2))
        System.out.println ("Rectangles Overlap");
    else
        System.out.println ("Rectangles Don't Overlap");
  }
  
  public static boolean doOverlap (Point l1, Point r1, Point l2, Point r2) {
    int x1 = l1.x;
    int x2 = r1.x;
    
    int y1 = l1.y;
    int y2 = r1.y;
    
    int a1 = l2.x;
    int a2 = r2.x;
    
    int b1 = l2.y;
    int b2 = r2.y;
    
    System.out.println (x1 + ", " + y1);
    System.out.println (x2 + ", " + y2);
    
    System.out.println (a1 + ", " + b1);
    System.out.println (a2 + ", " + b2);
    
    if (((a1 <= x1 && x1 <= a2) || (a1 <= x2 && x2 <= a2)) &&
       ((b2 <= y1 && y1 <= b1) || (b2 <= y2 && y2 <= b1 )))
      return true;
    
    return false;
  }
}

class Point {
  public int x;
  public int y;
  
  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }
}
