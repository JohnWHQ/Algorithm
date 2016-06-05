import java.util.*;
class FindErrSearchTree
{
	public static void main(String[] args) {
	   ProduceTree t = new ProduceTree();
		TreeNode head = t.head;
		TraceTreeMid(head);
		TreeNode[] errors;
	}
	public static TreeNode[] findErrInSearchTree(TreeNode head){
		 if (head==null) {
		 	return  null;
		 }
         TreeNode[] errors = new TreeNode[2];
         Stack<TreeNode> s = new Stack<TreeNode>();
         TreeNode node = head;
         TreeNode pre  = null;
         while (!s.isEmpty()||node != null) {
         	 if(node != null){
         	 	s.push(node);
         	 	node = node.left;
         	 }
         	 else{
         	 	node = s.pop();
         	 	if (pre != null && pre.value > node.value) {
         	 		errors[0] = errors[0] == null ? pre : errors[0];
         	 		errors[1] = node;
         	 	}
         	 	pre =  node;
         	 	node = node.right
         	 }
         }
         return errors;
	}
}