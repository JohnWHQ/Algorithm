class c3_14_PosArray2BST{
	public static void main(String[] args) {
		
	}
	public static boolean isPosTraceFromBST(int[] arr){
		if (arr == null || arr.length < 1) {
			return false;
		}
		return check(arr, 0, arr.length - 1);
	}
	public static boolean check(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		int l = -1;
		int r = end;
		for (int i = start; i < end; i++) {
			if (arr[i] < arr[end]) {
				l = i;
			}else {
				r = r == end ? i : r;
			}
		}
		if (l == -1 || r == end) {
			return check(arr, start, end - 1);
		}
		if (l != r - 1) {
			return false;
		}
		return check(arr, start, l) && check(arr, r, end);
	}

	public static TreeNode posArray2BST(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		return build(arr, 0, arr.length - 1);
	}
	public static TreeNode build(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode node = new TreeNode(arr[end]);
		int l = -1;
		int r = end;
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i]) {
				l = i;
			}else{
				r = r == end ? i : r;
			}
		}
		node.left = build(arr, start, l);
		node.right = build(arr, r, end);
		return node;
	}
}