/**
  *生成搜索二叉树 
  *
  **/
class ProduceSearchBTree
{

	TreeNode t1;
	TreeNode t2;
	TreeNode t3;
	TreeNode t4;
	TreeNode t5;
	TreeNode t6;
	TreeNode t7;
	TreeNode t8;
	TreeNode t9;
	TreeNode t10;
	TreeNode t11;
	TreeNode t12;
	TreeNode t13;
	TreeNode t14;
	TreeNode t15;

	TreeNode head;
	public ProduceSearchBTree(){
		t1 = new TreeNode(1);
		t2 = new TreeNode(2);
		t3 = new TreeNode(3);
		t4 = new TreeNode(4);
		t5 = new TreeNode(5);
		t6 = new TreeNode(6);
		t7 = new TreeNode(7);
		t8 = new TreeNode(8);
		t9 = new TreeNode(9);
		t10 = new TreeNode(10);
		t11 = new TreeNode(11);
		t12 = new TreeNode(12);
		t13 = new TreeNode(13);
		t14 = new TreeNode(14);
		t15 = new TreeNode(15);


        // level1
        t8.left = t4;
        t8.right = t12;

        // level2
        t4.left = t2;
        t4.right = t6;
        t12.left = t10;
        t12.right = t14;
        
        // level3
        t2.left = t1;
        t2.right =t3;
        t6.left = t5;
        t6.right = t7;
        t10.left = t9;
        t10.right = t11;
        t14.left = t13;
        t14.right = t15;

        //level4
        t1.left =null;
        t1.right =null;
        t3.left =null;
        t3.right =null;
        t5.left =null;
        t5.right =null;
        t7.left =null;
        t7.right =null;
        t9.left =null;
        t9.right =null;
        t11.left =null;
        t11.right =null;
        t13.left =null;
        t13.right =null;
        t15.left =null;
        t15.right =null;
     
        // ----------destroy code
        // t8.value=6;
        // t6.value =8;
        // ----------destroy code


		head=t8;

	}
}