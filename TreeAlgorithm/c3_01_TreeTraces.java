import java.util.*;

class c3_01_TreeTraces{
	public static void main(String[] args) {
		ProduceSampleTree t = new ProduceSampleTree();
		// preTrace(t.head);
		// midTrace(t.head);
		// posTrace(t.head);

		// preTraceByStack(t.head);
		// midTraceByStack(t.head);
		// posTraceByStack(t.head);
		posTraceByStackPro(t.head);

	}

	public static void preTrace(TreeNode node){
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		preTrace(node.left);
		preTrace(node.right);
	}

	public static void midTrace(TreeNode node){
		if (node == null) {
			return;
		}
		midTrace(node.left);
		System.out.println(node.value);
		midTrace(node.right);
	}

	public static void posTrace(TreeNode node){
		if (node == null) {
			return;
		}
		posTrace(node.left);
		posTrace(node.right);
		System.out.println(node.value);
	}

	public static void preTraceByStack(TreeNode node){
		if (node == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(node);
		while(!s.isEmpty()){
			node = s.pop();
			System.out.println(node.value);
			if (node.right != null) {
				s.push(node.right);
			}
			if (node.left != null) {
				s.push(node.left);
			}
		}
	}

	public static void midTraceByStack(TreeNode node){
		if (node == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(!s.isEmpty() || node != null){
			if (node != null) {
				s.push(node);
				node = node.left;
			}else {
				node = s.pop();
				System.out.println(node.value);
				node = node.right;
			}
		}
	}

	public static void posTraceByStack(TreeNode node){
		if (node == null) {
			return;
		}
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.push(node);
		while(!s1.isEmpty()){
			node = s1.pop();
			s2.push(node);
			if (node.left != null) {
				s1.push(node.left);
			}
			if (node.right != null) {
				s1.push(node.right);
			}
		}
		while(!s2.isEmpty()){
			System.out.println(s2.pop().value);
		}
	}

	public static void posTraceByStackPro(TreeNode node){
		if (node == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode last = node;
		TreeNode cur = null;
		s.push(node);
		while(!s.isEmpty()){
			cur = s.peek();
			if (cur.left  != null && last != cur.left && last != cur.right) {
				s.push(cur.left);
			}else if (cur.right != null && last != cur.right) {
				s.push(cur.right);
			}else {
				last = s.pop();
				System.out.println(last.value);
			}
		}
	}

}




class ProduceSampleTree
{
	TreeNode t1;
	TreeNode t2;
	TreeNode t3;
	TreeNode t4;
	TreeNode t5;
	TreeNode t6;
	TreeNode t7;
	TreeNode t8;

	TreeNode head;
	public ProduceSampleTree()
	{
		t1 = new TreeNode(1);
		t2 = new TreeNode(2);
		t3 = new TreeNode(3);
		t4 = new TreeNode(4);
		t5 = new TreeNode(5);
		t6 = new TreeNode(6);
		t7 = new TreeNode(7);
		t8 = new TreeNode(8);

		t1.right  =t3;
		t1.left   =t2;
		t2.right  =null;
		t2.left   =t4;
		t3.right  =t6;
		t3.left   =t5;
		t4.right  =null;
		t4.left   =null;
		t5.right  =t8;
		t5.left   =t7;
		t6.right  =null;
		t6.left   =null;
		t7.right  =null;
		t7.left   =null;
		t8.right  =null;
		t8.left   =null;

		head=t1;
	}
}