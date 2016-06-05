import java.util.*;
class PrintTreeByZigZag
{
	public static void main(String[] args) {
		ProduceTree t =new ProduceTree();
		TreeNode head =t.head;
		printTreeZ(head);
	}
	public static void printTreeZ(TreeNode head)
	{
		ArrayList<TreeNode> list=new ArrayList<TreeNode>();

		Queue<TreeNode> q =new LinkedList<TreeNode>();
		TreeNode node =head;
		q.add(node);

		TreeNode curlast=node;
		TreeNode nlast=null;

		int flag = 1;

		while(!q.isEmpty())
		{
			node=q.poll();
			list.add(node);
			if(node.left!=null)
			{
				nlast=node.left;
				q.add(node.left);
			}
			if(node.right!=null)
			{
				nlast=node.right;
				q.add(node.right);
			}
			if(curlast==node)
			{
				curlast = nlast;
				if(flag==1)
				{
	                 for(int i=0;i<list.size();i++)
					{
						System.out.print(list.get(i).value+"  ");
					}
					System.out.println("");
					list.clear();
					flag++;

				}
				else
				{
					for(int i=list.size()-1;i>=0;i--)
					{
						System.out.print(list.get(i).value+"  ");
					}
					System.out.println("");
					list.clear();
					flag--;
                   
				}
			}
		}

	}
}