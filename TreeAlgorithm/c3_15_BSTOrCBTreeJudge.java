import java.util.*;

class c3_15_BSTOrCBTJudge{
	public static void main(String[] args) {
		
	}
	public static boolean isBST(TreeNode node){
		if (node == null) {
			return true;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || node != null) {
			if (node != null) {
				s.push(node);
				pre = node;
				node = node.left;
			}else {
				node = s.pop();
				if (node.val < pre.val) {
					return false;
				}
				pre = node;
				node = node.right;
			}
		}
		return true;
	}

	public static boolean isCBT(TreeNode node) {
		if (node  == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean leaf = false;
		TreeNode l = null;
		TreeNode r = null;
		while (!q.isEmpty()) {
			node = q.poll();
			l = node.left;
			r = node.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				q.add(l);
			}
			if (r != null) {
				q.add(r);
			}else {
				leaf = true;
			}
		}
		return true;
	}

}
