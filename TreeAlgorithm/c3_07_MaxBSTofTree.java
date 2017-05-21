class c3_07_MaxBSTofTree{
	public static void main(String[] args) {
		
	}
	public static TreeNode getMaxBSTofTree(TreeNode head){
		int[] record = new int[3];
		return getMaxBST(head, record);
	}
	public static TreeNode getMaxBST(TreeNode node, int[] arr){
		if (node == null) {
			arr[0] = 0;
			arr[1] = Integer.MAX_VALUE;
			arr[2] = Integer.MIN_VALUE;
		}
		TreeNode left = node.left;
		TreeNode right = node.right;

		TreeNode lBST = getMaxBST(left, arr);
		int lsize = arr[0];
		int lmin = arr[1];
		int lmax = arr[2];

		TreeNode rBST = getMaxBST(right, arr);
		int rsize = arr[0];
		int rmin = arr[1];
		int rmax = arr[2];

		arr[1] = Math.min(lmin, node.value);
		arr[2] = Math.max(rmax, node.value);

		if (left = lBST && right = rBST && node.value > lmax && node.value < rmin) {
			arr[0] = lsize + rsize + 1;
			return node;
		}
		arr[0] = Math.max(lsize, rsize);
		return lsize > rsize ? lBST : rBST;
	}
}