class P04minEditCost{
	public static void  main(String[] args) {

        String str1 = "EA2CD";
        String str2 = "ABCD";

        System.out.println(getMinCost(str1, str2, 1, 1, 1));

    }
    public static int getMinCost(String str1, String str2, int ic, int dc, int rc){

        // str1 change to str2
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // ic => insert cost;
        // dc => delect cost;
        // rc => change cost;

        dp[0][0] = 0;
        for (int i = 1; i <= str2.length(); i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i <= str1.length(); i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
            }
        }
        return dp[str1.length()][str2.length()];
    }
}