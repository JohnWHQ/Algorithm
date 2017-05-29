class c5_14_validOfString{
	public static void main(String[] args) {
		
	}
	public boolean isValid(String str){
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str.charAt(i) != '(' && str.charAt(i) != ')') {
				return false;
			}
			if (str.charAt(i) == ')' && --count < 0) {
				return false;
			}
			if (str.charAt(i) == '(') {
				count++;
			}
		}
		return count == 0;
	}
	public int maxValidLen(String str){
		if (str == null || str.length == 0) {
			return 0;
		}
		char[] carr = str.toCharArray();
		int[] dp = new int[carr.length];
		int res = 0;
		int pre = 0;
		for (int i = 0; i < carr.length; i++) {
			if (carr[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && carr[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}