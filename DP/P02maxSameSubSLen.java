class P02maxSameSubSLen{
	public static void main(String[] args) {
		String str1 = "A1B2C34DE5F";
        String str2 = "G12H3I45K";

        int[][] dp = new int[str1.length()][str2.length()];

        dp[0][0] = str2.charAt(0) == str1.charAt(0) ? 1 : 0;

        for (int i = 1; i < str1.length(); i++) {
            dp[i][0] = Math.max(str1.charAt(i) == str2.charAt(0) ? 1 : 0, dp[i - 1][0]);
        }
        for (int i = 1; i < str2.length(); i++) {
            dp[0][i] = Math.max(str1.charAt(0) == str2.charAt(i) ? 1 : 0, dp[0][i - 1]);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
//        System.out.println(dp[str1.length() - 1][str2.length() - 1]);
        int len = dp[str1.length() - 1][str2.length() - 1];
        int r = str1.length() - 1;
        int c = str2.length() - 1;
        char[] res = new char[len];
        len--;
        while (len >= 0) {
            if (r > 0 && dp[r][c] == dp[r - 1][c]) {
                r--;
            }else if (c > 0 && dp[r][c] == dp[r][c - 1]) {
                c--;
            }else {
                res[len--] = str1.charAt(r);
                r--;
                c--;
            }
        }
        System.out.println(new String(res));
	}
}