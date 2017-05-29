class c5_18_maxLenUniqueSubStr{
	public static void main(String[] args) {
		
	}
	public static int getLen(String str){
		if (str == null || str.length == 0) {
			return 0;
		}
		int res = 0;
		int pre = -1;
		int[] map = new int[256];
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		int cur = 0;
		for (int i = 0; i < str.length; i++) {
			pre = Math.max(pre, map[str.charAt(i)]);
			cur = i - pre;
			res = Math.max(res, cur);
			map[str.charAt(i)] = i;
		}
		return res;
	}
}