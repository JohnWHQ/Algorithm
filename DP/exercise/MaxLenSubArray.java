class MaxLenSubArray{
	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 3, 6, 4, 9};
		int[] res = getMaxLenSubArray2(arr);
		for (int i = 0; i < res.length; i++ ) {
			System.out.println(res[i]);
		}
	}

	// 最长递增子序列

	// O(n^2) 
	public static int[] getMaxLenSubArray1(int[] arr){
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getDp1(arr);
		return generate(arr, dp);
	}
	public static int[] getDp1(int[] arr){
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length ; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	// O(n*logn)
	public static int[] getMaxLenSubArray2(int[] arr){
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getDp2(arr);
		return generate(arr, dp);
	}

	public static int[] getDp2(int[] arr){
		int[] dp = new int[arr.length];
		int[] tail = new int[arr.length];

		tail[0] = arr[0];
		dp[0] = 1;

		int index = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = index;
			while(l <= r){
				m = (l + r) / 2;
				if(arr[i] > tail[m]){
					l = m + 1;
				}else{
					r = m - 1;
				}
			}
			index = Math.max(index, l);
			tail[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}

	public static int[] generate(int[] arr, int[] dp){
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++ ) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] res = new int[len];
		res[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if(arr[i] < arr[index] && dp[i] == dp[index] - 1){
				res[--len] = arr[i];
				index = i;
			}
		}
		return res;
	}
}