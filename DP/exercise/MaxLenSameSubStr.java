class MaxLenSameSubStr{
	public static void main(String[] args) {
		String str1 = "1AB2345CD";
		String str2 = "12345EF";
		String res = getMaxLenSameSubStr(str1, str2);
		System.out.println(res);

		String res1 = getMaxLenSameSubStrPro(str1, str2);
		System.out.println(res1);
	}
	public static String getMaxLenSameSubStr(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
			return null;
		}
		int[][] dp = getDp(str1, str2);
		int max = 0;
		int index = 0;
		for (int i = 0; i < str2.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				if (dp[i][j] > max) {
					max = dp[i][j];
					index = j;
				}
			}
		}
		char[] res = new char[max];
		int len = 0;
		for (int i = index - max + 1; i <= index; i++) {
			res[len++] = str1.charAt(i);
		}
		return String.valueOf(res);
		// return new String(res);
	}
	public static int[][] getDp(String str1, String str2){
		int[][] dp = new int[str2.length()][str1.length()];
		dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
		for (int i = 1; i < str1.length(); i++) {
			// if (str1.charAt(i) == str2.charAt(0)) {
			// 	dp[0][i] = 1;
			// }else{
			// 	dp[0][i] = 0;
			// }
			dp[0][i] = str1.charAt(i) == str2.charAt(0) ? 1 : 0;
		}
		for (int i = 1; i < str2.length(); i++) {
			// if (str2.charAt(i) == str1.charAt(0)) {
			// 	dp[i][0] = 1;
			// }else{
			// 	dp[i][0] = 0;
			// }
			dp[i][0] = str2.charAt(i) == str1.charAt(0) ? 1 : 0;
		}
		for (int i = 1; i < str2.length(); i++) {
			for (int j = 1; j < str1.length(); j++) {
				// if (str1.charAt(j) == str2.charAt(i)) {
				// 	dp[i][j] = dp[i - 1][j - 1] + 1;
				// }else{
				// 	dp[i][j] = 0;
				// }
				dp[i][j] = str1.charAt(j) == str2.charAt(i) ? dp[i - 1][j - 1] + 1 : 0;
			}
		}
		return dp;
	}

	public static String getMaxLenSameSubStrPro(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
			return null;
		}
		int row = 0;
		int col = str1.length();
		int max = 0;
		int index = 0;

		while (row < str2.length()) {
			int i = row;
			int j = col;
			int len = 0;
			// 向右下方斜着走
			while(i < str2.length() && j < str1.length()){
				if (str1.charAt(j) == str2.charAt(i)) {
					len++;
				}else{
					len = 0;
				}
				if (len > max) {
					max = len;
					index = j;
				}
				i++;
				j++;
			}
			// 从右向左 col列减完了 向下走row
			if (col > 0) {
				col--;
			}else{
				row++;
			}
		}
		char[] res = new char[max];
		int len = 0;
		for (int i = index - max + 1; i <= index; i++) {
			res[len++] = str1.charAt(i);
		}
		return String.valueOf(res);		
	}
}