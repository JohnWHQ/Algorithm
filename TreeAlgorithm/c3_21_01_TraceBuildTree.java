import java.util.*;

class c3_21_01_TraceBuildTree{
	public static void main(String[] args) {
		
	}
	public static TreeNode preInToTree(int[] pre, int[] mid){
		if (pre == null || mid == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < mid.length; i++) {
			map.put(mid[i], i);
		}
		return preMidbuild(pre, 0, pre.length - 1, mid, 0, mid.length - 1, map);
	}
	public static TreeNode preMidbuild(int[] pre, int pi, int pj, int[] mid, int mi, int mj,
		HashMap<Integer, Integer> map){
		if (pi > pj || mi > mj) {
			return null;
		}
		int index = map.get(pre[pi]);
		TreeNode node = new TreeNode(pre[pi]);
		node.left = preMidbuild(pre, pi + 1, pi + index - mi, mid, mi, index - 1, map);
		node.right = preMidbuild(pre, pi + index - mi + 1, pj, index + 1, mj, map);
	}

	public static TreeNode midPosbuild(int[] mid, int[] pos){
		if (mid == null || pos == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < mid.length; i++) {
			map.put(mid[i], i);
		}
		return midPosbuild(mid, 0, mid.length - 1, pos, 0, pos.length - 1, map);
	}
	public static TreeNode midPosbuild(int[] mid, int mi, int mj, int[] pos, int pi, int pj,
		HashMap<Integer, Integer> map){
		if (mi > mj || pi > pj) {
			return null;
		}
		int index = map.get(pos[pj]);
		TreeNode node = new TreeNode(pos[pj]);
		node.left = midPosbuild(mid, mi, index - 1, pos, pi, pi + index - mi - 1, map);
		node.right = midPosbuild(mid, index + 1, mj, pos, pi + index - mi, pj - 1, map);
	}
}