class c5_20_Str1ContainsStr2MinSub{
	public static void main(String[] args) {
		
	}
	public static int getMinContainsMin(String str1, String str2){
		if (str1 == null || str2 == null || str1.length() < str2.length()) {
			return 0;
		}
		int[] map = new int[256];
		for (int i = 0; i < str2.length(); i++) {
			map[str2.charAt(i)]++;
		}
		int l = 0;
		int r = 0;
		int min = Integer.MAX_VALUE;
		int match = str2.length;
		while(r < str2.length()){
			map[str2.charAt(r)]--;
			if (map[str2.charAt(r)] >= 0) {
				match--;
			}
			if (match == 0) {
				while(map[str2.charAt(l)] < 0){
					map[str2.charAt(l++)]++;
				}
				min = Math.min(min, r - l + 1);
				match++;
				map[str2.charAt(l++)]++;
			}
			r++;
		}
		return min == Integer.MIN_VALUE ? 0 : min;
	}
}