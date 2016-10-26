class getNsumEqualsK{
	public static void main(String[] args) {
		int[] arr = {-8,-4,-3,0,1,2,4,5,8,9};

		get2SumEqualsK(arr,10);
		System.out.println("-----------------");
		get3SumEqualsK(arr,10);
		
	}
	public static void get2SumEqualsK(int[] arr , int k){
		if (arr == null || arr.length < 1) {
			return ;
		}
		int r = arr.length - 1;
		int l = 0;

		while (l < r) {
			if (arr[r] + arr[l] == k) {
				// check out the repeated data
				if (l == 0 || arr[l] != arr[l - 1]) {
					System.out.println(arr[l] + " " + arr[r]);
				}
				l++;
				r--;
			}else if (arr[r] + arr[l] < k) {
				l++;
			}else if (arr[r] + arr[l] > k) {
				r--;
			}
		}
	}


	public static void get3SumEqualsK(int[] arr ,int k){
		if (arr == null || arr.length < 3) {
			return ;
		}
		// use the 2s method to with the i become 3
		for (int i = 0; i < arr.length - 1 ; i ++ ) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				print3(arr,i,i+1,arr.length - 1,k - arr[i]);
			}
		}
	}
	public static void print3(int[] arr , int pre ,int l ,int r,int k){
		while(l < r){
			if (arr[l] + arr[r] < k) {
				l++;
			}else if (arr[l] + arr[r] > k) {
				r--;
			}else{
				if (l == pre + 1 || arr[l] != arr[l -1]) {
					System.out.println(arr[pre] + " " + arr[l] + " " + arr[r] );
				}
				l++;
				r--;
			}
		}
	}
}