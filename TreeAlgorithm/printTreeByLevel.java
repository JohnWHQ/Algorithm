import java.util.*;
class printTreeByLevel
{
	public static void main(String[] args) {
		ProduceTree t =new ProduceTree();
		TreeNode head =t.head;
		// pretreeTrace(head);
		printByLevelN(head);
	}
	// 前序遍历
	public static void pretreeTrace(TreeNode head)
	{
		if(head==null)
		{
			return ;
		}
        System.out.println(head.value);
		pretreeTrace(head.left);
		pretreeTrace(head.right);
	}
	//广度优先搜索遍历
	public static void printByLevel(TreeNode head)
	{
		Queue<TreeNode> q =new LinkedList<TreeNode>();
		TreeNode node =head;
		q.add(node);
		while(!q.isEmpty())
		{
			node = q.poll();
			System.out.println(node.value);
			if(node.left!=null){q.add(node.left);}
			if(node.right!=null){q.add(node.right);}
		}

	}
	//分层号打印
		public static void printByLevelN(TreeNode head)
	{
		Queue<TreeNode> q =new LinkedList<TreeNode>();
		TreeNode node =head;
		TreeNode curlast;
		TreeNode nlast;
		curlast = node;
		nlast = null;
		q.add(node);
		int level=0;
		System.out.print(" Level:"+(++level)+":");
		while(!q.isEmpty())
		{

			node = q.poll();
			System.out.print(node.value+"  ");
			if(node.left!=null)
				{
					q.add(node.left);
					nlast = node.left;
				}
			if(node.right!=null)
			    {
				   q.add(node.right);
				    nlast = node.right;
				}

			if (curlast==node&&!q.isEmpty()) {
				curlast=nlast;
				System.out.print("\n Level:"+(++level)+":");
			}
		}
		System.out.print("\n");

	}
}