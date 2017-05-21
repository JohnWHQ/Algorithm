import java.util.*;

class c3_04_SerializeAndsaReTree{
	public static void main(String[] args) {
		ProduceTree t = new ProduceTree();
		// System.out.println(serializePre(t.head));
		// System.out.println(serializePre(reSerializePre(serializePre(t.head))));

		System.out.println(serializeLevel(t.head));
		System.out.println(serializeLevel(ReSerializeLevel(serializeLevel(t.head))));
		
	}

	public static String serializePre(TreeNode head){
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res = res + serializePre(head.left);
		res = res + serializePre(head.right);
		return res;
	}

	public static TreeNode reSerializePre(String str){
		Queue<String> q = new LinkedList<String>();
		String[] sarr = str.split("!");
		for (int i = 0; i < sarr.length; i++) {
			q.add(sarr[i]);
		}
		return reSerialize(q);
	}
	public static TreeNode reSerialize(Queue<String> q){
		if (q.peek().equals("#")) {
			q.poll();
			return null;
		}
		TreeNode res = new TreeNode(Integer.valueOf(q.poll()));
		res.left = reSerialize(q);
		res.right = reSerialize(q);
		return res;
	}

	public static String serializeLevel(TreeNode node){
		if (node == null) {
			return "#!";
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		String res = node.value + "!";
		while(!q.isEmpty()){
			node = q.poll();
			if (node.left != null) {
				q.add(node.left);
				res = res + node.left.value + "!";
			}else {
				res = res + "#!";
			}

			if (node.right != null) {
				q.add(node.right);
				res = res + node.right.value + "!";
			}else {
				res = res + "#!";
			}
		}
		return res;
	}

	public static TreeNode ReSerializeLevel(String s){
		String[] sarr = s.split("!");
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int i = 0;
		TreeNode node = getNode(sarr, i++);
		TreeNode res = node;
		q.add(node);
		while(!q.isEmpty()){
			node = q.poll();
			node.left = getNode(sarr, i++);
			node.right = getNode(sarr, i++);
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		return res;
	}

	public static TreeNode getNode(String[] sarr, int i){
		if (sarr[i].equals("#")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(sarr[i]));
	}

}