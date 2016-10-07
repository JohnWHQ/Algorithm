import java.util.*;
class TreeSerial2Re{
	public static void main(String[] args) {
		ProduceTree t =new ProduceTree();
		// System.out.println(serialPre(t.head));
		// System.out.println(serialPre(reSerialPre(serialPre(t.head))));
		System.out.println(serialLevel(t.head));
		System.out.println(serialLevel(reSerialLevel(serialLevel(t.head))));
	}
	public static String serialPre(TreeNode head){
		if(head == null){
			return "#!";
		}
		String res = String.valueOf(head.value)+"!";
		res = res + serialPre(head.left);
		res = res + serialPre(head.right);
		return res;
	}

	public static TreeNode reSerialPre(String s){
		Queue<String> q = new LinkedList<String>();
		String[] sarr = s.split("!");
		for (int i = 0; i < sarr.length ; i++) {
			q.add(sarr[i]);
		}
		return reSerialPreMethod(q);

	}
	public static TreeNode reSerialPreMethod(Queue<String> q){
		String s = q.poll();
		if (s.equals("#")) {
			return null;
		}
		TreeNode res = new TreeNode(Integer.valueOf(s));
		res.left = reSerialPreMethod(q);
		res.right =reSerialPreMethod(q);
		return res;
	}

	public static String serialLevel(TreeNode head){
		if (head == null) {
			return "#!";
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode cur = head;
		String res = cur.value+"!";

		q.add(cur);
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.left!=null) {
				q.add(cur.left);
				res = res + cur.left.value + "!";
			}else {
				res = res + "#!";
			}
			if (cur.right!=null) {
				q.add(cur.right);
				res = res + cur.right.value + "!";
			}else {
				res = res + "#!";
			}
		}
		return res;
	}

	public static TreeNode reSerialLevel(String s){
		TreeNode res = null;
		String[] sarr = s.split("!");
		Queue<TreeNode> q = new  LinkedList<TreeNode>();
		int index = 0;
		if (s == null || sarr.length<1 || sarr.equals("#!")) {
			return res;
		}
		res = new TreeNode(Integer.valueOf(sarr[index++]));
		q.add(res);

		TreeNode cur = null;

		while(!q.isEmpty()){
			cur = q.poll();
			if (sarr[index++].equals("#") ) {
				cur.left = null;
			}else{
				cur.left = new TreeNode(Integer.valueOf(sarr[index-1]));
				q.add(cur.left);
			}
			if (sarr[index++].equals("#")) {
				cur.right = null;
			}else{
				cur.right = new TreeNode(Integer.valueOf(sarr[index-1]));
				q.add(cur.right);
			}
		}
		return res;
	}
}