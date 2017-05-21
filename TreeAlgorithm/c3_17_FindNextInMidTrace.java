class c3_17_FindNextInMidTrace{
	public static void main(String[] args) {
		
	}
	public static TreeNode findNode(TreeNode node){
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			return getMostLeftNode(TreeNode node);
		}else {
			TreeNode parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
		}
		return parent;
	}
	public static TreeNode getMostLeftNode(TreeNode node){
		if (node == null) {
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
class TreeNode{

	int value;

	TreeNode left;
	TreeNode right;
	TreeNode parent;

	public TreeNode(int data){
		value = data;
	}

}