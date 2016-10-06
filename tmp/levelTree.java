import java.util.*;
class levelTree{
	public static void main(String[] args) {
					
	}
	public static void print(TreeNode head){
		if (head == null) {
			return ;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode cur ;
		q.add(head);
		while(!q.isEmpty()){
			cur = q.pull();
			if(cur.left!=null){
				q.add(cur.left);
			}
			if (cur.right!=null) {
				q.add(cur.right);
			}
		}
	}
}
