class arrMid2AVLBST{
	public static void main(String[] args) {
		int[] arr;
		return  createABT(arr,0,arr.length-1);
	}
	public static TreeNode createABT(int[] arr,int start ,int end){
		if (start > end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createABT(arr,start,mid-1);
		node.right = createABT(arr,mid+1,end);
		return node;
	}
}