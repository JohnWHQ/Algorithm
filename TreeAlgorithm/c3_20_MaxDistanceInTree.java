class c3_20_MaxDistanceInTree{
	public static void main(String[] args) {
		
	}
	public static int getMaxDistance(TreeNode node){
		if (node == null) {
			return  0;
		}
		int[] maxDistance = new int[1];
		return getDistance(node, maxDistance);
	}
	public static int getDistance(TreeNode node, int[] maxDistance){
		if (node == null) {
			maxDistance[0] = 0;
			return 0;
		}
		int leftMax = getDistance(node.left, maxDistance);
		int maxFromLeft = maxDistance[0];
		int rigthMax = getDistance(node.rigth, maxDistance);
		int maxFromRight = maxDistance[0];

		maxDistance[0] = Math.max(maxFromLeft, maxFromRight) + 1;
		int curMax = maxFromLeft + maxFromRight + 1;
		return Math.max(Math.max(leftMax, rigthMax), curMax);
	}
}