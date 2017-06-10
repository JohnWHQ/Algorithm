class c5_21_MinCutStrToPandidrome{
	public static void main(String[] args) {
		
	}
	public static int getMinCut(String str){
		if (str == null || str.length == 0) {
			return 0;
		}
		boolean[][] p = new boolean[str.length()][str.length()];
		int[] dp = new int[str.length() + 1];
		for (int i = str.length - 1; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < str.length; j++) {
				if (str.charAt(i) == str.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
	}
}