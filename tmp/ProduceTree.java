class ProduceTree
{
	TreeNode t1;
	TreeNode t2;
	TreeNode t3;
	TreeNode t4;
	TreeNode t5;
	TreeNode t6;
	TreeNode t7;
	TreeNode t8;

	TreeNode head;
	public ProduceTree()
	{
		t1 = new TreeNode(1);
		t2 = new TreeNode(2);
		t3 = new TreeNode(3);
		t4 = new TreeNode(4);
		t5 = new TreeNode(5);
		t6 = new TreeNode(6);
		t7 = new TreeNode(7);
		t8 = new TreeNode(8);

		t1.right  =t3;
		t1.left   =t2;
		t2.right  =null;
		t2.left   =t4;
		t3.right  =t6;
		t3.left   =t5;
		t4.right  =null;
		t4.left   =null;
		t5.right  =t8;
		t5.left   =t7;
		t6.right  =null;
		t6.left   =null;
		t7.right  =null;
		t7.left   =null;
		t8.right  =null;
		t8.left   =null;

		head=t1;
	}
}