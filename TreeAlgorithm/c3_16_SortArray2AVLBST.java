class c3_16_SortArray2AVLBST{
	public static void main(String[] args) {
		
	}
	public static TreeNode sortArr2AVLBST(int[] arr){
		if (arr == null || arr.length < 1) {
			return null;
		}
		return build(arr, 0, arr.length);
	}
	public static TreeNode build(int[] arr, int start, int end){
		if (start > end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = build(arr, start, mid - 1);
		node.right = build(arr, mid + 1, end);
		return node; 
	}
}