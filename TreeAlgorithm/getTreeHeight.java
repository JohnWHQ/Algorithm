class getTreeHeight{
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = TreeDepth(root.left);
		int r = TreeDepth(root.right);

		return (l>r)?l:r;
	}
}
/*
    public int TreeDepth(TreeNode root) {
        if(root==null)
        {
          return 0;  
        }
        int r =TreeDepth(root.right);
        int l =TreeDepth(root.left);
       
        return  (r>l)?(r+1):(l+1);  
        
    }
*/