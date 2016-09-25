import java.util.*;
/**
  *  二叉树遍历工具类 各种遍历方式
  */
class TraceTreeUtils
{
  //  public static void main(String[] args) {
  //  	    produceTree t = new produceTree();
		// TreeNode head = t.head;

	 //    System.out.println("pre----------------------");
	 //    preTreeByReturn(head);
	 //    System.out.println("pre----------------------");
  //       preTraceUStack(head);

	 //    System.out.println("mid----------------------");
	 //    midTreeByReturn(head);
	 //    System.out.println("mid----------------------");
	 //    midTraceUStack(head);

	 //    // System.out.println("aft----------------------");
	 //    // aftTreeByReturn(head);
  //  }
   /**
    * 前序遍历 递归版
    */
   public static void preTreeByReturn(TreeNode head){
   	   if(head == null){
   	   	  return ; 
   	   }
   	   System.out.println(head.value);
   	   preTreeByReturn(head.left);
   	   preTreeByReturn(head.right);
   }

   /**
    * 中序遍历 递归版
    */
   public static void midTreeByReturn(TreeNode head){
   	   if(head == null){
   	   	  return ; 
   	   }
   	   midTreeByReturn(head.left);
   	   System.out.println(head.value);
   	   midTreeByReturn(head.right);
   }

   /**
    * 后序遍历 递归版
    */
   public static void aftTreeByReturn(TreeNode head){
   	   if(head == null){
   	   	  return ; 
   	   }
   	   aftTreeByReturn(head.left);
   	   aftTreeByReturn(head.right);
   	   System.out.println(head.value);
   }
 
  /**
   * 前序遍历 非递归版 利用栈
   */
  public static void preTraceUStack(TreeNode head){
  	   Stack<TreeNode> s = new Stack<TreeNode>();
  	   TreeNode node = head;
  	   s.push(node);
  	   while (!s.isEmpty()) {
  	   	   node = s.pop();
  	   	   System.out.println(node.value);
  	   	   if(node.right != null){
  	   	   	   s.push(node.right);
  	   	   }
  	   	   if (node.left != null) {
  	   	   	   s.push(node.left);
  	   	   }
  	   }

  }

  /**
   *中序遍历 非递归版 利用栈
   */
 public static void midTraceUStack(TreeNode head){
    Stack<TreeNode>  s = new Stack<TreeNode>();
    TreeNode node = head;
    while (!s.isEmpty() || node != null) {
    	if(node != null){
    		s.push(node);
    		node = node.left; 
    	}
    	else{
    		node = s.pop();
    		System.out.println(node.value);
    		node = node.right;
    	}
    }

 }
   /**
   *后序遍历 非递归版 利用栈
   */
 public static void aftTraceUStack(TreeNode head){
     	if (head == null) {
     		return;
     	}
     Stack<TreeNode> s1 = new Stack<TreeNode>();
     Stack<TreeNode> s2 = new Stack<TreeNode>();
     TreeNode node = head;
     s1.push(node);
     while (!s1.isEmpty()) {
     	node = s1.pop();
     	s2.push(node);
     	if (node.left != null) {
     		s1.push(node.left);
     	}
     	if (node.right != null) {
     		s1.push(node.right);
     	}

     }
     while (!s2.isEmpty()) {
     	node = s2.pop();
     	System.out.println(node.value);
     }
 }





}