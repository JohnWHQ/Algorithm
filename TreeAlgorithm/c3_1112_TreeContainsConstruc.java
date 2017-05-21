class c3_1112_TreeContainsConstruct{
	public static void main(String[] args) {
		
	}
	public static boolean containsAbsConstruct(TreeNode node, TreeNode compare){
		return check1(node, compare) || containsAbsConstruct(node.left, compare) 
		|| containsAbsConstruct(node.right, compare);
	}
	public static boolean check1(TreeNode n1, TreeNode n2){
		if (n1 == null && n2 == null) {
			return true;
		}
		if (n1 == null || n2 == null) {
			return false;
		}
		if (n1.value != n2.value) {
			return false;
		}
		return check1(n1.left, n2.left) && check1(n1.right, n2.right); 
	}

	public static boolean containsConstruct(TreeNode node, TreeNode compare){
		return check2(node, compare) || containsConstruct(node.left, compare) 
		|| containsConstruct(node.right, compare);		
	}
	public static boolean check2(TreeNode n1, TreeNode n2){
		if (n2 == null) {
			return true;
		}
		if (n1 == null || n1.value != n2.value) {
			return false;
		}
		return check2(n1.left, n2.left) && check2(n1.right, n2.right);
	}




	public static boolean isSubTree(TreeNode node, TreeNode compare){
		String s1 = getTreeStr(node);
		String s2 = getTreeStr(compare);
		return KMP(s1, s2) == -1 ? false : true;
	}
	public static String getTreeStr(TreeNode node){
		if (node == null) {
			return "#!";
		}
		String res = node.value + "!";
		res = res + getTreeStr(node.left);
		res = res + getTreeStr(node.right);
		return res;
	}

	public static int KMP(String str, String match){
		if (str == null || match == null || str.length() < match.length()) {
			return -1;
		}
		char[] scarr = str.toCharArray();
		char[] mcarr = match.toCharArray();

		int[] next = getNext(mcarr);

		int si = 0;
		int mi = 0;
		while (si < scarr.length && mi < mcarr.length) {
			if (scarr[si] == mcarr[mi]) {
				si++;
				mi++;
			}else if (next[mi] == -1) {
				si++;
			}else {
				mi = next[mi];
			}
		}
		return mi == mcarr.length ? (si - mi) : -1;

	}
	public static int[] getNext(char[] mcarr){
		if (mcarr.length == 1) {
			return new int[]{-1};
		}
		int[] next = new int[mcarr.length];
		int index = 2;
		int n = 0;
		next[0] = -1;
		next[1] = 0;
		while(index < mcarr.length) {
			if (mcarr[index - 1] == mcarr[n]) {
				next[index++] = ++n;
			}else if (n > 0) {
				n = next[n];
			}else{
				next[index++] = 0;
			}
		}
	}
}