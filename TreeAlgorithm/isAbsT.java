import java.util.*;
class isAbsT{
	public static void main(String[] args) {
		
	}
	public static boolean isAbsT(TreeNode head){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean isLeaf = false;
		TreeNode  node = head;
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if ((node.left == null)&&(node.right != null) ) {
				return false;
			}
			if (isLeaf&&(node.left!=null || node.right != null)) {
				return false;
			}
			if (node.left!=null) {
				q.add(node.left);
			}
			if (node.right!=null) {
				q.add(node.right);
			}else {
				isLeaf = true;
			}
		}
		return true;
	}
}