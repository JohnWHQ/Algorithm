import java.util.*;
class TestFind
{
	public static void main(String[] args) {
         ProduceTree t = new ProduceTree();
         TreeNode head = t.head;

         ProduceSearchBTree st = new ProduceSearchBTree();
         TreeNode shead = st.head;

         // print(shead);
         TraceTreeUtils mUtils = new TraceTreeUtils();
         mUtils.aftTraceUStack(shead);
        

	}
	public static TreeNode[] findErrTreeNode(TreeNode head){
         
         TreeNode[] result = new TreeNode[2];
         Stack<TreeNode> s = new Stack<TreeNode>();
         TreeNode node = head;
         TreeNode pre  = null;

         while (!s.isEmpty() || node != null) {
         	 if (node != null) {
         	 	s.push(node);
         	 	node = node.left;
         	 }
         	 else {
         	 	node = s.pop();
         	 	if (pre != null && pre.value > node.value) {
         	 		result[0] = result[0] == null ? pre : result[0];
         	 		result[1] = node; 
         	 	}
         	 	pre = node;
         	 	node = node.right;
         	 }
         }
        return  result;
	}
	public static void print(TreeNode head){
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = head;
        while (!s.isEmpty() || node != null) {
        	if (node != null) {
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