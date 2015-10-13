import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LowestCommonAncestorRecursion {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);

		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		TreeNode node = lowestCommonAncestor(root, new TreeNode(4),
				new TreeNode(6));

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		// Step-0: base conditions
		if (root == null || p == null || q == null)
			return null;

		// Step-1: Find paths to p and q from the root node
		List<TreeNode> pathOne = new LinkedList<TreeNode>();
		List<TreeNode> pathTwo = new LinkedList<TreeNode>();

		pathOne = findPath(root, p, pathOne);
		pathTwo = findPath(root, q, pathTwo);

		int i = 0, j = 0;
		TreeNode commonAncestor = null;

		while (i < pathOne.size() && j < pathTwo.size()) {
			if (pathOne.get(i).val == pathTwo.get(j).val)
				commonAncestor = pathOne.get(i);
			else
				break;
			i++;
			j++;
		}
		System.out.println(commonAncestor.val);
		return commonAncestor;
	}

	public static List<TreeNode> findPath(TreeNode root, TreeNode p,
			List<TreeNode> list) {
		System.out.println(root != null ? root.val : null);
		if (root == null)
			return null;
		if (root.val == p.val) {
			System.out.println("aaa");
			list.add(p);
			return list;
		}
		list.add(root);
		List<TreeNode> leftList = new LinkedList<TreeNode>();
		List<TreeNode> rightList = new LinkedList<TreeNode>();

		leftList.addAll(list);
		rightList.addAll(list);

		leftList = findPath(root.left, p, leftList);
		System.out.println("LL: " + leftList);
		if (leftList != null)
			return leftList;
		rightList = findPath(root.right, p, rightList);
		System.out.println("RL: " + rightList);
		if (rightList != null)
			return rightList;
		else
			return null;
	}
}
