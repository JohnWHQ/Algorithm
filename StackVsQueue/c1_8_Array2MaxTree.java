import java.util.*;

class c1_8_Array2MaxTree{
	public static void main(String[] args) {
		int[] arr = {3,4,5,1,2};
		TreeNode res = array2MaxTree(arr);
		System.out.println(res.value);
		System.out.println(res.left.value);
		System.out.println(res.right.value);
	}
	public static TreeNode array2MaxTree(int[] arr){
		TreeNode res = null;

		if (arr == null || arr.length < 1) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<TreeNode, TreeNode> lmap = new HashMap<TreeNode, TreeNode>();
		HashMap<TreeNode, TreeNode> rmap = new HashMap<TreeNode, TreeNode>();

		TreeNode[] nodes = new TreeNode[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nodes[i] = new TreeNode(arr[i]);
		}

		TreeNode cur;
		for (int i = 0; i < nodes.length; i++) {
			cur  = nodes[i];
			while (!stack.isEmpty() && stack.peek().value < cur.value) {
				lmap.put(stack.pop(), cur);
			}
			stack.push(cur);
		}
		while(!stack.isEmpty()){
			cur = stack.pop();
			if(stack.isEmpty()){
				lmap.put(cur, null);
			}else{
				lmap.put(cur, stack.peek());
			}
		}

		for (int i = nodes.length - 1; i >= 0; i--) {
			cur  = nodes[i];
			while (!stack.isEmpty() && stack.peek().value < cur.value) {
				rmap.put(stack.pop(), cur);
			}
			stack.push(cur);
		}
		while(!stack.isEmpty()){
			cur = stack.pop();
			if(stack.isEmpty()){
				rmap.put(cur, null);
			}else{
				rmap.put(cur, stack.peek());
			}
		}

		for (int i = 0; i < nodes.length; i++) {
			TreeNode node = nodes[i];
			TreeNode l = lmap.get(node);
			TreeNode r = rmap.get(node);

			if (l == null && r == null) {
				res = node;
			}else if(l != null && r == null){
				if (l.left == null) {
					l.left = node; 
				}else {
					l.right = node;
				}
			}else if(l == null && r != null){
				if (r.left == null) {
					r.left = node;
				}else {
					r.right = node;
				}
			}else {
				TreeNode p = l.value < r.value ? l : r;
				if (p.left == null) {
					p.left = node;
				}else {
					p.right = node;
				}
			}
		}
		return res;
	}
}