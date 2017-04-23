class MaxLenSameSubStrSer{
	public static void main(String[] args) {
		String str1 = "1A2C3D4B56";
		String str2 = "B1D23CA45B6A";
		System.out.println(getMaxLenSameSubStr(str1, str2));
	}

	// 最长公共子序列

	public static String getMaxLenSameSubStr(String str1, String str2){
		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
			return null;
		}
		int[][] dp = getDp(str1, str2);

		// test DP VALUE print screen
		// for (int i = 0; i < dp.length; i++) {
		// 	for (int j = 0; j < dp[0].length; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		int row = str2.length() - 1;
		int col = str1.length() - 1;
		char[] res = new char[dp[row][col]];
		int index = res.length - 1;
		while (index >= 0) {
			if (row > 0 && dp[row][col] == dp[row - 1][col]) {
				row--;
			}else if (col > 0 && dp[row][col] == dp[row][col - 1]) {
				col--;
			}else{
				res[index--] = str1.charAt(col);
				row--;
				col--;
			}
		}

		return new String(res);
		// return "test"; 
	}

	public static int[][] getDp(String str1, String str2){
		char[] carr1 = str1.toCharArray();
		char[] carr2 = str2.toCharArray();
		int[][] dp = new int[carr2.length][carr1.length];
		dp[0][0] = carr1[0] == carr2[0] ? 1 : 0;
		for (int i = 1; i < carr1.length; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], carr1[i] == carr2[0] ? 1 : 0);
		}
		for (int i = 1; i < carr2.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], carr2[i] == carr1[0] ? 1 : 0);
		}
		for (int i = 1; i < carr2.length; i++) {
			for (int j = 1; j < carr1.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (carr2[i] == carr1[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp;
	}
}