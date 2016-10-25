class findNeedSortNum{
	public static void main(String[] args) {
		int[] arr = {1,5,4,3,2,6,7};
		System.out.println(find(arr));
		
	}
	public static int find(int[] arr){
		int min = arr[arr.length - 1];
		int index_l  = -1;
		for (int i = arr.length - 2 ; i >= 0 ; i-- ) {
			if (arr[i] > min ) {
				index_l = i;
			}else{
				min = Math.min(min,arr[i]);
			}
		}
		if (index_l == -1) {
			return 0;
		}
		int max = arr[0];
		int index_r = -1;
		for (int i = 1; i < arr.length ; i++) {
			if (arr[i] < max) {
				index_r = i;
			}else{
				max = Math.max(max,arr[i]);
			}
		}
		return index_r - index_l + 1; 
	}
}