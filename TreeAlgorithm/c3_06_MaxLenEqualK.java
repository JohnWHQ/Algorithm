import java.util.*;

class c3_06_MaxLenEqualK{
	public static void main(String[] args) {
		
	}
	public static int getMaxLenEqualK(TreeNode node, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		getMax(node, sum, 0, 1, 0, map);

	}
	public static int getMax(TreeNode node, int sum, int presum, int level, int max,
		HashMap<Integer, Integer> map){
		if (node == null) {
			return max;			
		}
		int curSum = presum + node.value;
		if (!map.cotainKey(curSum)) {
			map.put(curSum, level);
		}
		if (map.cotainKey(curSum - sum)) {
			max = Math.max(max, level - map.get(curSum - sum));
		}
		max = Math.max(max, getMax(node.left, sum, curSum, level + 1, max, map));
		max = Math.max(max, getMax(node.right, sum, curSum, level + 1, max, map));
		if (map.get(curSum) == level) {
			map.remove(curSum);
		}
		return max;
	}
}