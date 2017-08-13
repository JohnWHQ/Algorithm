class P01maxAscSubArrLen{
	public static void main(String[] args) {
		int[] arr = {2,1,5,3,6,4,8,9,7};

		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int len = 0;
		int index = 0;

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] res = new int[len];
		res[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if(arr[i] < arr[index] && dp[index] == dp[i] + 1){
				res[--len] = arr[i];
			}
		}
		
	}
}