class productExpSelf{
	public static void main(String[] args) {
		int[] arr = {2,3,1,4};
		int[] res = product1(arr);
		int[] res1 = product2(arr);
		for (int x : res1 ) {
			System.out.println(x);
		}
		
	}
	public static int[] product1(int[] arr){
		if (arr == null || arr.length <=1) {
			return arr;
		}
		int[] res = new int[arr.length];
		int count = 0;
		int all = 1;
		for (int i = 0; i < arr.length ; i++) {
			if (arr[i] != 0) {
				all = all * arr[i];
			}else{
				count++;
			}
		}
		if (count == 0) {
			for (int i = 0; i < arr.length ; i++ ) {
				res[i] = all / arr[i];
			}
		}
		if (count == 1) {
			for (int i = 0; i < arr.length ; i++ ) {
				if (arr[i] == 0) {
					res[i] = all;
				}else{
					res[i] = 0;
				}
			}
		}
		return res;
	}

	public static int[] product2(int[] arr){
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int[] res = new int[arr.length];
		res[0] = arr[0];
		for (int i = 1; i < arr.length ; i++) {
			res[i] = res[i - 1] * arr[i];
		}
		int tmp = 1;
		for (int i = arr.length - 1; i > 0 ; i-- ) {
			res[i] = res[i-1] * tmp;
			tmp = tmp * arr[i];
		}
		res[0] = tmp;
		return res;
	}
}