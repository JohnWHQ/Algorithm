class MinCostEdit{
	public static void main(String[] args) {
		String str1 = "ab12cd3";
		String str2 = "abcdf";

		System.out.println(getMinCostEdit(str1, str2, 5, 3, 2));
		System.out.println(getMinCostEdit(str2, str1, 3, 2, 4));
	}
	public static int getMinCostEdit(String str1, String str2, int ic, int dc, int rc){
		if(str1 == null || str2 == null){
			return 0;
		}
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i < str2.length() + 1; i++) {
			dp[0][i] = i * ic;
		}
		for (int i = 1; i < str1.length() + 1; i++) {
			dp[i][0] = i * dc;
		}
		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					dp[i][j] = dp[i - 1][j - 1] + rc;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
				dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
			}
		}
		return dp[str1.length()][str2.length()];
	}
}