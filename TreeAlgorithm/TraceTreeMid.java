import java.util.*;
class TraceTreeMid
{
	public static void main(String[] args) {
		produceTree t =new produceTree();
		TreeNode head =t.head;
		TraceTreeMid(head);
	}
	public static void TraceTreeMid(TreeNode head){
		if(head==null){
			return ;
		}
        Stack<TreeNode> s =new Stack<TreeNode>();
        TreeNode node = head;
        TreeNode index = null;
        while (!s.isEmpty()||node != null) {
            if(node != null){
            	s.push(node);
            	node = node.left;
            }
            else {
            	node = s.pop();
            	System.out.println(node.value);
            	node = node.right;
            }
        }  
 	}
}