class c3_13_BalancedTree{
	public static void main(String[] args) {
		
	}
	public static boolean isBalancedTree(TreeNode node) {
		if (node == null) {
			return true;
		}
		int l = getDepth(node.left);
		int r = getDepth(node.right);

		if (Math.abs(l - 1) > 1) {
			return false;
		}
		return isBalancedTree(node.left) && isBalancedTree(node.right);
	}

	public static int getDepth(TreeNode node){
		if (node == null) {
			return 0;
		}
		int l = getDepth(node.left);
		int r = getDepth(node.right);
		return Math.max(l, r) + 1;
	}
}