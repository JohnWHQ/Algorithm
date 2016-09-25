import java.util.*;
class isBST{
	public static void main(String[] args) {
		ProduceSearchBTree p = new ProduceSearchBTree();
		System.out.println(isBST(p.head));
		
	}
	public static boolean isBST(TreeNode head){
		if(head == null){
			return true;
		}
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = head;
        TreeNode pre = null;
        while(!s.isEmpty() || node != null){
        	if (node!=null) {
        	    s.push(node);
        	    pre = node; 
        		node = node.left;
        	} else {
        		node = s.pop();
        		if (node.value < pre.value) {
        			return false;
        		}
        		pre = node;
        		node = node.right;
        	}
        }
        return true;
	}
}