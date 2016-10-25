import java.util.*;
class TreeUtil{
	public static void main(String[] args) {
		ProduceTree t =new ProduceTree();
		TreeNode head =t.head;
		printlevel(head);
		// printPre(head);					
	}
	public static void printlevel(TreeNode head){
		if (head == null) {
			return ;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode cur ;
		TreeNode now = head;
		TreeNode next = null;
		q.add(head);
		while(!q.isEmpty()){
			cur = q.poll();
			System.out.println(cur.value);
			if(cur.left!=null){
				q.add(cur.left);
				next = cur.left;
			}
			if (cur.right!=null) {
				q.add(cur.right);
				next = cur.right;
			}
			if (now == cur && !q.isEmpty()) {
				now = next;
				System.out.println("-------------");
			}
		}
	}
	public static void printPre(TreeNode head){
		if (head == null) {
			return ;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur;
		s.push(head);
		while(!s.isEmpty()){
			cur = s.pop();
			System.out.println(cur.value);
			if(cur.right!=null){
				s.push(cur.right);
			}
			if (cur.left!=null) {
				s.push(cur.left);
			}
		}
	}
	public static void printMid(TreeNode head){
		if (head == null) {
			return ;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = head;
		while(!s.isEmpty() || cur!=null){
			if(cur!=null){
			    s.push(cur);
				cur = cur.left;
			}else{
				cur = s.pop();
				System.out.println(cur.value);
				cur = cur.right;
			}
		}
	}
	public static void printPos(TreeNode head){
		if (head == null) {
			return ;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> res = new Stack<TreeNode>();
		TreeNode cur = head;
		s.push(cur);
		while(!s.isEmpty()){
			cur = s.pop();
			res.push(cur);
			if(cur.left!=null){
				s.push(cur.left);
			}
			if (cur.right!=null) {
				s.push(cur.right);
			}
		}
		while(!res.isEmpty()){
			System.out.println(res.pop().value);
		}
	}
	public static void printPosPro(TreeNode head){
		if (head == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode last = head;
		TreeNode cur = null;
		s.push(head);
		while(!s.isEmpty()){
			cur = s.peek();
			if (cur.left!=null && last!=cur.left && last!=cur.right) {
				s.push(cur.left);
			}else if(cur.right!=null && last!=cur.right){
				s.push(cur.right);
			}else{
				last = s.pop();
				System.out.println(last.value);
			}
		}
	}
}
