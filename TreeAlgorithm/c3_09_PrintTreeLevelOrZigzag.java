import java.util.*;

class c3_09_PrintTreeLevelOrZigzag{
	public static void main(String[] args) {
		ProduceTree node = new ProduceTree();
		// printTreeByLevel(node.head);
		// printTreeByLevelPro(node.head);
		printTreeByZigzag(node.head);
	}

	public static void printTreeByLevel(TreeNode node){
		if (node == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			System.out.println(node.value);
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	public static void printTreeByLevelPro(TreeNode node){
		if (node == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		TreeNode clast = node;
		TreeNode last = node;
		while (!q.isEmpty()) {
			node = q.poll();
			System.out.print(node.value + " ");
			if (node.left != null) {
				q.add(node.left);
				last = node.left;
			}
			if (node.right != null) {
				q.add(node.right);
				last = node.right;
			}
			if (clast == node && (!q.isEmpty()) ) {
				System.out.println();
				clast = last;
			}
		}
	}

	public static void printTreeByZigzag(TreeNode node){
		if (node == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		TreeNode clast = node;
		TreeNode last = node;
		boolean l2r = true;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while(!q.isEmpty()) {

			node = q.poll();
			tmp.add(node.value);

			if (node.left != null) {
				q.add(node.left);
				last = node.left;
			}
			if (node.right != null) {
				q.add(node.right);
				last = node.right;
			}
			if (node == clast) {
				clast = last;
				if (!l2r) {
					Collections.reverse(tmp);
				}
				for (int x : tmp) {
					System.out.print(x + " ");
				}
				System.out.println();
				tmp.clear();
				l2r = !l2r;
			}
	    }
	}

}