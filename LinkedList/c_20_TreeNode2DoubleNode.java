class DNode{
	int value;
	DNode last;
	DNode next;
	DNode(int data){
		value = data;
	}
}
class c_20_TreeNode2DoubleNode{
	public static void main(String[] args) {
		 
	}
	public static TreeNode tree2DNode1(TreeNode t){
		if (t == null) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		getQ(t, q);

		head = q.poll();
		TreeNode pre = head;
		pre.left = null
		TreeNode cur = null;
		while (!q.isEmpty()) {
			cur = q.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		 }
		 pre.right = null;
		 return head; 
	}
	public static void getQ(TreeNode t,Queue<TreeNode> q){
		if (t == null) {
			return;
		}
		getQ(t.left);
		q.add(t);
		getQ(t.right);
	}

	public static TreeNode tree2DNode1(TreeNode t){
		if (t == null) {
			return t;
		}
		Node last = process(t);
		t = last.right;
		last.right = null;
		return t;
	}
	public static TreeNode process(TreeNode t){
		if (t == null) {
			return null;
		}
		TreeNode le = process(t.left);
		TreeNode re = process(t.right);
		TreeNode ls = le != null ? le.right : null;
		TreeNode rs = re != null ? re.right : null;
		if (le != null && re != null) {
			le.right = t;
			t.left = le;
			t.right = rs;
			rs.left = t;
			re.right = ls;

		}else if (le != null) {
			t.right = ls;
			le.right = t;
			t.left = le;
			return t;
		}else if (re != null) {
			t.right = rs;
			rs.left = t;
			re.right = t;
			return re;
 		}else{
 			t.right = t;
 			return t;
 		}
	}
}