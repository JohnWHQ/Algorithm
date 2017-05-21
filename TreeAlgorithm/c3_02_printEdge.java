class c3_02_printEdge{
	public static void main(String[] args) {
		ProduceTree node = new ProduceTree();
		// printEdgeStandard1(node.head);
		printEdgeStandard2(node.head);
	}

	public static void printEdgeStandard1(TreeNode node){
		if (node == null) {
			return;
		}

		int h = getHeight(node, 0);
		TreeNode[][] edge = new TreeNode[h][2];

		setEdge(node, 0, edge);

		for (int i = 0; i < h; i++) {
			System.out.println(edge[i][0].value);
		}

		printLeavesNotEdge(node, 0, edge);

		for (int i = h - 1; i >= 0; i--) {
			if (edge[i][0] != edge[i][1]) {
				System.out.println(edge[i][1].value);
			}
		}
	}

	public static int getHeight(TreeNode node, int res){
		if (node == null) {
			return res;
		}
		int l = getHeight(node.left, res + 1);
		int r = getHeight(node.right,res + 1);

		return Math.max(l, r);
	}

	public static void setEdge(TreeNode node, int h, TreeNode[][] edge){
		if (node == null) {
			return;
		}
		edge[h][0] = edge[h][0] == null ? node : edge[h][0];
		edge[h][1] = node;
		setEdge(node.left, h + 1, edge);
		setEdge(node.right, h + 1, edge);
	}

	public static void printLeavesNotEdge(TreeNode node, int h, TreeNode[][] edge){
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null && node != edge[h][0] && node != edge[h][1]) {
			System.out.println(node.value);
		}
		printLeavesNotEdge(node.left, h + 1, edge);
		printLeavesNotEdge(node.right, h + 1, edge);
	}

	public static void printEdgeStandard2(TreeNode node){
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		if (node.left != null && node.right != null) {
			printLeft(node.left, true);
			printRight(node.right, true);
		}else {
			printEdgeStandard2(node.left != null ? node.left : node.right);
		}
	}

	public static void printLeft(TreeNode node, boolean b){
		if (node == null) {
			return;
		}
		if (b || (node.left == null && node.right == null)) {
			System.out.println(node.value);
		}
		printLeft(node.left, b);
		printLeft(node.right, b && (node.left == null ? true : false) );
	}

	public static void printRight(TreeNode node, boolean b){
		if (node == null) {
			return;
		}
		printRight(node.left, b && (node.right == null ? true : false));
		printRight(node.right, b);
		if (b || (node.left == null && node.right == null)) {
			System.out.println(node.value);
		}
	}





}