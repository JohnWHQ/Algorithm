import java.util.*;
class PrintTreeByZigZagPro
{
	public static void main(String[] args) {
		ProduceTree t =new PsroduceTree();
		TreeNode head =t.head;
		printTree(head);
	}
     
    public static void printTree(TreeNode t){
       if (t==null) {
           return ;
       }
       Deque<TreeNode> mDeque = new LinkedList<TreeNode>();
       TreeNode node = t;
       TreeNode curlast = node;
       TreeNode nexlast = null;
       boolean Left2Right = true;
       
       mDeque.addFirst(node);
       while(!mDeque.isEmpty())
       {
       	    if(Left2Right){
       	    	node = mDeque.pollFirst();
       	    	if(node.left != null){
       	    		mDeque.addLast(node.left);
       	    		nexlast = nexlast == null ? node.left : nexlast;
       	    	}
       	    	if(node.right != null){
       	    		mDeque.addLast(node.right);
       	    		nexlast = nexlast == null ? node.right : nexlast;
       	    	}
       	    }
       	    else {
       	    	node = mDeque.pollLast();
       	    	if (node.right != null) {
       	    		mDeque.addFirst(node.right);
       	    		nexlast = nexlast == null ? node.right : nexlast;
       	    	}
       	    	if (node.left != null) {
                    mDeque.addFirst(node.left);
                    nexlast = nexlast == null ? node.left : nexlast;       	    		
       	    	}
       	    }
       	    System.out.print(node.value + " ");
       	    if (node == curlast && !mDeque.isEmpty()) {
       	    	Left2Right = !Left2Right;
       	    	curlast = nexlast;
       	    	nexlast = null;
       	    	System.out.println();
       	    }

       }
        System.out.println();
    }

     
}