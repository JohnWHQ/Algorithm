class P05isCrossMade{
    public static void  main(String[] args) {

        String str1 = "ABCD";
        String str2 = "1234";
        String aim = "AB12C34D";
        System.out.println(isCrossMade(str1, str2, aim));

    }
    public static boolean isCrossMade(String str1, String str2, String aim){
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        if (str1.length() + str2.length() != aim.length()) {
            return false;
        }

        boolean[][] dp = new boolean[str1.length() + 1][str2.length() + 1];

        dp[0][0] = true;
        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i - 1) != aim.charAt(i - 1)) {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i < str2.length(); i++) {
            if (str2.charAt(i - 1) != aim.charAt(i - 1)) {
                break;
            }
            dp[0][i] = true;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == aim.charAt(i + j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }else if (str2.charAt(j - 1) == aim.charAt(i + j - 1) && dp[i][j - 1]){
                    dp[i][j] = true;
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }	
}