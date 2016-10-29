class ArrayPartition{
	public static void main(String[] args) {
		int[] arr ={1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
		sortedArrayLeftUnique(arr);
		for (int x : arr ) {
			System.out.println(x);
		}

		int[] arr1 = {0,1,2,0,1,2,0,0,1,1,2,2,2,2,1,1,0,0};
		leftMidRight(arr1);
	    for (int x : arr1 ) {
			System.out.println(x);
		}
	}
	public static void sortedArrayLeftUnique(int[] arr){
		if (arr == null || arr.length < 2) {
			return  ;
		}
		int j = 0;
		int i = 1;
		int tmp ;
		while (i < arr.length) {
			if (arr[i++] != arr[j]) {
				tmp = arr[i-1];
				arr[i-1] = arr[++j];
				arr[j] = tmp;
			}
		}
	}

	public static void leftMidRight(int[] arr){
		if (arr == null || arr.length < 2) {
			return;
		}
		int left = -1;
		int right = arr.length;
		int midR =0;
		int tmp;
		while(midR != right){
			if (arr[midR] == 0) {
				tmp = arr[midR];
				arr[midR] = arr[left + 1];
				arr[left + 1] = tmp;
				left++;
				midR++;
			}else if (arr[midR] == 2) {
				tmp = arr[midR];
				arr[midR] = arr[right - 1];
				arr[right - 1] = tmp;
				right--;
			}else if (arr[midR] == 1) {
				midR++;
			}
		}
	}
}