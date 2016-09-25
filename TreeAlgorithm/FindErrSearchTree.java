import java.util.*;
class FindErrSearchTree
{
	public static void main(String[] args) {
	   ProduceSearchBTree t = new ProduceSearchBTree();
		TreeNode head = t.head;

      // System.out.println("搜索二叉树中序遍历：");
      // TraceTreeUtils.midTraceUStack(head);


      // TreeNode[] errors = findErrInSearchTree(head);
      // System.out.println("错误节点：");
      // System.out.println(errors[0].value);
      // System.out.println(errors[1].value);

      // TreeNode[] errPn = findErrP(head,errors[0],errors[1]);
      
      // System.out.println("错误节点父节点：");
      // System.out.println(errPn[0].value);
      // System.out.println(errPn[1].value);

      
      TraceTreeUtils.midTraceUStack(fixTree(head));



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
         	 	node = node.right;
         	 }
         }
         return errors;
	}

   public static TreeNode[] findErrP(TreeNode head , TreeNode err1 , TreeNode err2){
      if(head == null){
         return null;  
      }
      TreeNode[] errP = new TreeNode[2];
      Stack<TreeNode> s = new Stack<TreeNode>();
      TreeNode node = head ;
      while (!s.isEmpty() || node != null) {
         if (node != null) {
            s.push(node);
            node = node.left;
         }
         else{
            node = s.pop();
            if (node.left == err1 || node.right == err1) {
               errP[0] = node;
            }
            if (node.left == err2 || node.right == err2) {
               errP[1] = node;
            }
            node = node.right;
         }     
      }
      return errP;
   }

   public static TreeNode fixTree(TreeNode head){

      System.out.println("搜索二叉树中序遍历：");
      TraceTreeUtils.midTraceUStack(head);

      TreeNode[] errors = findErrInSearchTree(head);
      System.out.println("错误节点：");
      System.out.println(errors[0].value);
      System.out.println(errors[1].value);
      TreeNode[] errPn = findErrP(head,errors[0],errors[1]);
      System.out.println("错误节点父节点：");

      System.out.println(errPn[0] == null ? "null" : errPn[0].value);
      System.out.println(errPn[1] == null ? "null" : errPn[1].value);

     

      // 两错误节点都不是根节点
      if (errPn[0] != null && errPn[1] !=null) {
         // 不是父子关系 
         if ((errors[0] != errors[1].left) && (errors[1] != errors[0].right)) {
            // case1
            if ((errors[0] == errPn[0].left) && (errors[1] == errPn[1].left)) {
               errPn[0].left = errors[1];
               errPn[1].left = errors[0];
            }
            // case2
            if ((errors[0] == errPn[0].right) && (errors[1] == errPn[1].right)) {
               errPn[0].right = errors[1];
               errPn[1].right = errors[0];
            }
            // case3
            if ((errors[0] == errPn[0].right) && (errors[1] == errPn[1].left)) {
               errPn[0].right = errors[1];
               errPn[1].left = errors[0];               
            }
            // case4
            if ((errors[0] == errPn[0].left) && (errors[1] == errPn[1].right)) {
               errPn[0].left = errors[1];
               errPn[1].right = errors[0];                
            }
         }
         // error1是error0的父节点 并若为父子关系 error0只能是error1的左孩子
         if (errors[0] == errors[1].left) {
            // case5
            if (errors[1] == errPn[1].left) {
               TreeNode tmpl = errors[1];
               TreeNode tmpr = errors[1].right;

               errPn[1].left = errors[0];

               errors[1].left = errors[0].left;
               errors[1].right = errors[0].right;

               errors[0].left = tmpl;
               errors[0].right = tmpr;


            }
            // case6
            if (errors[1] == errPn[1].right) {
               TreeNode tmpl = errors[1];
               TreeNode tmpr = errors[1].right;

               errPn[1].right = errors[0];

               errors[1].left = errors[0].left;
               errors[1].right = errors[0].right;

               errors[0].left = tmpl;
               errors[0].right = tmpr;

               
            }
         }
         // error0是error1的父节点 并若为父子关系 error1只能是error0的右孩子
         if (errors[1] == errors[0].right) {
            // case7
            if (errors[0] == errPn[0].left) {
               TreeNode tmpl = errors[0].left;
               TreeNode tmpr = errors[0];

               errPn[0].left = errors[1];

               errors[0].left = errors[1].left;
               errors[0].right = errors[1].right;

               errors[1].left = tmpl;
               errors[1].right = tmpr;
               
            }
            // case8
            if (errors[0] == errPn[0].right) {
               TreeNode tmpl = errors[0].left;
               TreeNode tmpr = errors[0];

               errPn[0].right = errors[1];

               errors[0].left = errors[1].left;
               errors[0].right = errors[1].right;

               errors[1].left = tmpl;
               errors[1].right = tmpr;
            }
         }
         System.out.println("调整后搜索二叉树中序遍历：");
         return head;
      }

      // err0是根
      if (errPn[0] == null) {
         //  不是父子
         if (errors[1] != errors[0].right) {
            TreeNode tmpl ;
            TreeNode tmpr ;
            // case9
            if (errPn[1].right == errors[1]) {
               tmpl = errors[0].left;
               tmpr = errors[0].right;

               errPn[1].right = errors[0];

               errors[0].left = errors[1].left;
               errors[0].right = errors[1].right;

               errors[1].left = tmpl;
               errors[1].right = tmpr;
               
            }
            // case10
            if (errPn[1].left == errors[1]) {
               tmpl = errors[0].left;
               tmpr = errors[0].right;

               errPn[1].left = errors[0];
               errors[0].left = errors[1].left;
               errors[0].right = errors[1].right;

               errors[1].left = tmpl;
               errors[1].right = tmpr;  
            }
         }
         // case11 是父子(只能是err1是err0的右孩子)
         if (errors[1] == errors[0].right) {
               TreeNode tmpl ;
               TreeNode tmpr ;
               tmpl = errors[0].left;
               tmpr = errors[0];

               errors[0].left = errors[1].left;
               errors[0].right =errors[1].right;

               errors[1].left = tmpl;
               errors[1].right = tmpr;  
         }
         System.out.println("调整后搜索二叉树中序遍历：");
         return errors[1];
      }
      // err1是根
      if (errPn[1] == null) {
         //  不是父子
         if (errors[0] != errors[1].left) {
            // case12
            if (errPn[0].right == errors[0]) {
               // System.out.println("----------------");
               TreeNode tmpl = errors[1].left;
               TreeNode tmpr = errors[1].right;

               errPn[0].right = errors[1];

               errors[1].left = errors[0].left;
               errors[1].right = errors[0].right;

               errors[0].left = tmpl;
               errors[0].right =tmpr;

               // System.out.println("调整后搜索二叉树中序遍历：");
               // TraceTreeUtils.midTraceUStack(errors[0]);
            }
            // case13
            if (errPn[0].left == errors[0]) {
               TreeNode tmpl = errors[1].left;
               TreeNode tmpr = errors[1].right;

               errPn[0].left = errors[1];

               errors[1].left = errors[0].left;
               errors[1].right = errors[0].right;

               errors[0].left = tmpl;
               errors[0].right =tmpr;
            }
         }
         // case14 是父子(只能是err0是err1的左孩子)
         if (errors[0] == errors[1].left) {
               TreeNode tmpl ;
               TreeNode tmpr ;
               tmpl = errors[1].left;
               tmpr = errors[1];

               errors[1].left = errors[0].left;
               errors[1].right =errors[0].right;

               errors[0].left = tmpl;
               errors[0].right = tmpr;             
         }
         System.out.println("调整后搜索二叉树中序遍历：");
         return errors[0];
         
      }

      // System.out.println("调整后搜索二叉树中序遍历：");
      // TraceTreeUtils.midTraceUStack(head);
      return null;

   }

}
 
