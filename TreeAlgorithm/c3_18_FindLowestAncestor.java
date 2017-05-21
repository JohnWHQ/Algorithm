class c3_18_FindLowestAncestor{
	public static void main(String[] args) {
		
	}
	public static TreeNode getAncestor(TreeNode node, TreeNode o1, TreeNode o2){
		if (node == null || node == o1 || node == o2) {
			return  node;
		}
		TreeNode left = getAncestor(node.left, o1, o2);
		TreeNode right = getAncestor(node.right, o1, o2);
		if (left != null && right != null) {
			return node;
		}
		return left != null ? left : right;
	}
}