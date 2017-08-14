public class P03maxSameSubLen {
    public static void  main(String[] args){
        String str1 = "AB123C4567D";
        String str2 = "A12C4567E";

        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(0) == str2.charAt(i)) {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                 }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }
        char[] res = new char[max];
        for(int i = max - 1; i >= 0; i--){
            res[i] = str1.charAt(index--);
        }
        System.out.println(new String(res));
    }

}
